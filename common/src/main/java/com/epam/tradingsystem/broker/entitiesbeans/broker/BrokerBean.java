package com.epam.tradingsystem.broker.entitiesbeans.broker;

import javax.ejb.Stateless;

import com.epam.tradingsystem.broker.entities.Broker;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBeanImpl;

/**
 * Session Bean implementation class BrokerBean
 */
@Stateless
public class BrokerBean extends GenericBeanImpl<Integer, Broker> implements BrokerBeanRemote, BrokerBeanLocal {

    /**
     * Default constructor. 
     */
    public BrokerBean() {
        // TODO Auto-generated constructor stub
    }

}
