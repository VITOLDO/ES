package com.epam.tradingsystem.broker.entitiesbeans.ticker;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.epam.tradingsystem.broker.entities.Ticker;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBeanImpl;

/**
 * Session Bean implementation class TickerBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TickerBean extends GenericBeanImpl<Integer, Ticker> implements TickerBeanRemote, TickerBeanLocal {

    /**
     * Default constructor. 
     */
    public TickerBean() {
        // TODO Auto-generated constructor stub
    }

}
