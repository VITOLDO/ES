package com.epam.tradingsystem.broker.entitiesbeans.tradingorder;
import java.util.List;
import javax.ejb.Remote;

import com.epam.tradingsystem.broker.entities.TradingOrder;
import com.epam.tradingsystem.broker.entities.Trader;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Remote
public interface TradingOrderBeanRemote extends GenericBean<Integer, TradingOrder> {
	
	public boolean buyTradingOrder(int tickerId, float oz, double sl, double tp,String typeOrder, int typeOperation, double price, Trader trader);
	public  List<TradingOrder> findLimit(int startPosition, int maxResult);
	public  List<TradingOrder> findLimitByUser(int startPosition, int maxResult, Trader trader);
	public  List<TradingOrder> findAllByUserAccount(Trader trader);
}
