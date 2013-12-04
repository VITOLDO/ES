package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.AccountTypeDAO;
import com.epam.tradingsystem.broker.entities.AccountType;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:03
 * To change this template use File | Settings | File Templates.
 */
public class AccountTypeDAOImpl extends BaseDAOImpl<AccountType> implements AccountTypeDAO {
    public AccountTypeDAOImpl() {
        setClazz(AccountType.class);
    }
}
