package com.epam.tradingsystem.broker.entitiesbeans.account;


import javax.ejb.Remote;

import com.epam.tradingsystem.broker.entities.Account;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;


@Remote
public interface AccountBeanRemote  extends GenericBean<Integer, Account>{
}
