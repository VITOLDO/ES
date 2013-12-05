package com.epam.tradingsystem.broker.entitiesbeans.account;

import com.epam.tradingsystem.broker.dao.AccountDAO;
import com.epam.tradingsystem.broker.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:01
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public Account getAccountById(long id) {
        return accountDAO.findById(id);
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountDAO.findAll();
    }

    @Override
    public void updateAccount(Account account) {
        accountDAO.update(account);
    }
}
