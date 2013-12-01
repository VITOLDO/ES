package com.epam.tradingsystem.broker.entitiesbeans.accounttype;
import javax.ejb.Remote;

import com.epam.tradingsystem.broker.entities.AccountType;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Remote
public interface AccountTypeBeanRemote  extends GenericBean<Integer, AccountType>{

}
