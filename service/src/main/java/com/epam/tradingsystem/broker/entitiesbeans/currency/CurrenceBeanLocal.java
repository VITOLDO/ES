package com.epam.tradingsystem.broker.entitiesbeans.currency;
import javax.ejb.Local;

import com.epam.tradingsystem.broker.entities.Currency;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Local
public interface CurrenceBeanLocal  extends GenericBean<Integer, Currency>{

}
