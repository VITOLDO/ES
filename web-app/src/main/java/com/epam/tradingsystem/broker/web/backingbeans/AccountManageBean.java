package com.epam.tradingsystem.broker.web.backingbeans;

import java.util.List;

import javax.ejb.EJB;
import com.epam.tradingsystem.broker.entities.Account;
import com.epam.tradingsystem.broker.entities.Trader;
import com.epam.tradingsystem.broker.entitiesbeans.account.AccountBeanLocal;

public class AccountManageBean {
	@EJB
	AccountBeanLocal account;
	
	public List<Account> getUserAccounts() {	
		//get user from session
		Trader trader = UserManageBean.getCurrentUser(); 
		return trader.getAccount();
	}

	public Account getCurrentAccount() {
		return getUserAccounts().get(0);
	}

	public String replenish() {
		getCurrentAccount().setDeposit(getCurrentAccount().getDeposit()+100000);
		account.update(getUserAccounts().get(0));
		return "account";
	}

}
