package com.epam.tradingsystem.broker.entitiesbeans.broker;
import javax.ejb.Remote;

import com.epam.tradingsystem.broker.entities.Broker;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Remote
public interface BrokerBeanRemote extends GenericBean<Integer, Broker>{

}
