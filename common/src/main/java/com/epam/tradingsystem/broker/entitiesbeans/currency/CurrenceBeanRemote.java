package com.epam.tradingsystem.broker.entitiesbeans.currency;
import javax.ejb.Remote;

import com.epam.tradingsystem.broker.entities.Currency;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Remote
public interface CurrenceBeanRemote extends GenericBean<Integer, Currency>{

}
