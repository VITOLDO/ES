package com.epam.tradingsystem.broker.entitiesbeans.accounttype;
import javax.ejb.Local;

import com.epam.tradingsystem.broker.entities.AccountType;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Local
public interface AccountTypeBeanLocal  extends GenericBean<Integer, AccountType>{

}
