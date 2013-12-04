package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.AccountDAO;
import com.epam.tradingsystem.broker.entities.Account;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 01.12.13
 * Time: 12:45
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AccountDAOImpl extends BaseDAOImpl<Account> implements AccountDAO {
    public AccountDAOImpl() {
        setClazz(Account.class);
    }
}
