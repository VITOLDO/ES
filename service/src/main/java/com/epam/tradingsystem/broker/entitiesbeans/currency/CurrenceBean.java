package com.epam.tradingsystem.broker.entitiesbeans.currency;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.epam.tradingsystem.broker.entities.Currency;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBeanImpl;

/**
 * Session Bean implementation class CurrenceBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CurrenceBean extends GenericBeanImpl<Integer, Currency> implements CurrenceBeanRemote, CurrenceBeanLocal {

    /**
     * Default constructor. 
     */
    public CurrenceBean() {
        // TODO Auto-generated constructor stub
    }

}
