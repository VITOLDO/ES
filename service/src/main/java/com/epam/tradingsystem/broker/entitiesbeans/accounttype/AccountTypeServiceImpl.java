package com.epam.tradingsystem.broker.entitiesbeans.accounttype;

import com.epam.tradingsystem.broker.dao.AccountTypeDAO;
import com.epam.tradingsystem.broker.entities.AccountType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 21:36
 * To change this template use File | Settings | File Templates.
 */
public class AccountTypeServiceImpl implements AccountTypeService {

    @Autowired
    private AccountTypeDAO accountTypeDAO;

    @Override
    public AccountType findAccountTypeById(long id) {
        return accountTypeDAO.findById(id);
    }

    @Override
    public List<AccountType> findAllAccountTypes() {
        return accountTypeDAO.findAll();
    }
}
