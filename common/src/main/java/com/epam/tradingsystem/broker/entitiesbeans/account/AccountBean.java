package com.epam.tradingsystem.broker.entitiesbeans.account;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.epam.tradingsystem.broker.entities.Account;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBeanImpl;

/**
 * Session Bean implementation class AccountBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AccountBean extends GenericBeanImpl<Integer, Account> implements AccountBeanRemote, AccountBeanLocal {

    /**
     * Default constructor. 
     */
    public AccountBean() {
        // TODO Auto-generated constructor stub
    }




}
