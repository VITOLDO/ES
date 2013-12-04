package com.epam.tradingsystem.broker.entitiesbeans.tradingorder;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.Query;

import com.epam.tradingsystem.broker.entities.Account;
import com.epam.tradingsystem.broker.entities.Trader;
import com.epam.tradingsystem.broker.entities.TradingOrder;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBeanImpl;
import com.epam.tradingsystem.broker.entitiesbeans.orderoperation.OrderOperationLocal;
import com.epam.tradingsystem.broker.entitiesbeans.ticker.TickerBeanLocal;

/**
 * Session Bean implementation class TradingOrderBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TradingOrderBean extends GenericBeanImpl<Integer, TradingOrder>
		implements TradingOrderBeanRemote, TradingOrderBeanLocal {

	@EJB
	private TickerBeanLocal tickerBean;
	@EJB
	private AccountBeanLocal accountBean;
	@EJB
	private OrderOperationLocal orderOperationBean;

	private TradingOrder order;

	public TradingOrderBean() {

	}

	public  List<TradingOrder> findLimitByUser(int startPosition, int maxResult, Trader trader)
	{  
		Query q = entityManager.createQuery("select object(o) from "+entityClass.getName()+" as o where o.account.accountId="+trader.getAccount().get(0).getAccountId()).setFirstResult(startPosition).setMaxResults(maxResult);
		return q.getResultList();
		
	}
	
	public  List<TradingOrder> findAllByUserAccount(Trader trader)
	{  
		Query q = entityManager.createQuery("select object(o) from "+entityClass.getName()+" as o where o.account.accountId="+trader.getAccount().get(0).getAccountId());
		return q.getResultList();
		
	}
	
	public  List<TradingOrder> findLimit(int startPosition, int maxResult)
	{
		Query q = entityManager.createQuery("select object(o) from "+entityClass.getName()+" as o" ).setFirstResult(startPosition).setMaxResults(maxResult);
		return q.getResultList();
		
	}
	
	private boolean blockCash(int tickerId, double oz, Trader trader, double price) {
		//add logic how to blockCash and what size of lot (at now, lot is all money in account
		//stub   
		int accountId=1;
		Account currentAccount = accountBean.findById(accountId);
		double orderSum=currentAccount.getDeposit()*oz;
		currentAccount.setDeposit((currentAccount.getDeposit()-orderSum));
		accountBean.update(currentAccount);
		return true;
	}

	private boolean unBlockCash() {
		return true;
	}

	private boolean sendOrderExchange() {
		return true;
	}

	private boolean saveOrder(int tickerId, float oz, int typeOperation,
			BigDecimal price, Trader trader) {
		
			order = new TradingOrder();
			order.setAccount(accountBean.findById(trader.getUserId()));
			order.setCommission((price.multiply(new BigDecimal(0.1))));// insert true formula,which count commission
			order.setCreated(new Date());
			order.setOrderNo(Math.abs(new Random().nextInt())); // how number is count? random?
			order.setPrice(price);
			order.setTicker(tickerBean.findById(tickerId));
			order.setOrderOperation(orderOperationBean.findById(typeOperation));
			order.setValid(new Date());
			order.setVolume((float)oz);
			create(order);

			return true;
		
	}

	
	@Override
	public boolean buyTradingOrder(int tickerId, float oz, double sl,
			double tp, String typeOrder, int typeOperation, double price,
			Trader trader) {
		if (blockCash(tickerId, oz, trader, price)) {
			try {
				if ((saveOrder(tickerId, oz, typeOperation, new BigDecimal(price), trader))
						&& (sendOrderExchange())) {
					return true;
				}
			} catch (Exception e) {
				unBlockCash();
				return false;
			}
		}
		return false;
	}
}
