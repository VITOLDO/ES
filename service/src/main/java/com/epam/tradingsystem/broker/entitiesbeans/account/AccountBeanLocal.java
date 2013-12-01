package com.epam.tradingsystem.broker.entitiesbeans.account;

import javax.ejb.Local;

import com.epam.tradingsystem.broker.entities.Account;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Local
public interface AccountBeanLocal  extends GenericBean<Integer, Account>{
}
