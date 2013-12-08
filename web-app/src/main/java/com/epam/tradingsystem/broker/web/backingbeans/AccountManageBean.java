package com.epam.tradingsystem.broker.web.backingbeans;

import com.epam.tradingsystem.broker.entities.Account;
import com.epam.tradingsystem.broker.entities.Trader;
import com.epam.tradingsystem.broker.entitiesbeans.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public class AccountManageBean {
	@Autowired
	private AccountService accountService;
	
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
		accountService.updateAccount(getUserAccounts().get(0));
		return "accountService";
	}

}
