package com.epam.tradingsystem.broker.entitiesbeans.account;

import com.epam.tradingsystem.broker.entities.Account;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:01
 * To change this template use File | Settings | File Templates.
 */
public interface AccountService {
    Account getAccountById(long id);
    List<Account> getAllAccounts();
    void updateAccount(Account account);
}
