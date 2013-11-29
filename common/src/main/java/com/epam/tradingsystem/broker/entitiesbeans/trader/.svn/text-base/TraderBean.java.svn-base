package com.epam.tradingsystem.broker.entitiesbeans.trader;

import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.epam.tradingsystem.broker.config.UserDefaults;
import com.epam.tradingsystem.broker.entities.Account;
import com.epam.tradingsystem.broker.entities.AccountType;
import com.epam.tradingsystem.broker.entities.Currency;
import com.epam.tradingsystem.broker.entities.Trader;
import com.epam.tradingsystem.broker.entities.Usergroup;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBeanImpl;
import com.epam.tradingsystem.broker.entitiesbeans.account.AccountBeanRemote;
import com.epam.tradingsystem.broker.entitiesbeans.accounttype.AccountTypeBeanRemote;
import com.epam.tradingsystem.broker.entitiesbeans.currency.CurrenceBeanRemote;
import com.epam.tradingsystem.broker.entitiesbeans.usergroup.UserGroupBeanRemote;


/**
 * Session Bean implementation class TraderBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TraderBean extends GenericBeanImpl<Integer, Trader> implements TraderBeanRemote, TraderBeanLocal {

	@EJB
	private TraderBeanRemote traderDaoBean;
	@EJB
	private UserGroupBeanRemote userGroupDaoBean;
	@EJB
	private AccountTypeBeanRemote accountTypeDaoBean;
	@EJB
	private AccountBeanRemote accountDaoBean;
	@EJB
	private CurrenceBeanRemote currenceDaoBean;
	
    /**;
     * Default constructor. 
     */
    public TraderBean() {

    }

    @Override
    public void create(Trader trader) {
    	super.create(trader);
    	
    	Usergroup group = new Usergroup();
		group.setLogin(trader.getLogin());
		group.setName(UserDefaults.TRADER_DEFAULT_GROUP);
		userGroupDaoBean.create(group);
		
		Account account = new Account();
		AccountType accountType = accountTypeDaoBean.findById(UserDefaults.TRADER_DEFAULT_ACCOUNT_TYPE_ID);
		trader = traderDaoBean.findById(trader.getUserId());
    	account.setAccountType(accountType);
    	
    	Currency currency = currenceDaoBean.findById(UserDefaults.TRADER_DEFAULT_CURRENCY_ID) ;
		account.setCurrency(currency);
		//TODO: FIX Account number generation!
		account.setNum(UUID.randomUUID().hashCode());
		account.setDeposit(UserDefaults.TRADER_DEFAULT_DEPOSIT);
		account.setTrader(trader);
		
		accountDaoBean.create(account);
    }
    
    
	@Override
	public Trader findTraderByLogin(String login) {
		Query q = entityManager
				.createQuery("SELECT t FROM Trader t WHERE t.login LIKE :login")
			    .setParameter("login", login);
		Trader trader;
		try {
			trader = (Trader) q.getSingleResult();
		} catch (NoResultException e) {
			trader = null;
		}
		
		return trader;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Trader> findAll(){
		return entityManager.createQuery("SELECT t FROM Trader t").getResultList();
	}

	@Override
	public List<Trader> findLimited(int first, int last, String fieldToSort,
			boolean sortOrder) {
		Query query = entityManager.createQuery("SELECT t FROM Trader t ");
		return query.setFirstResult(first).setMaxResults(last).getResultList();
	}

}
