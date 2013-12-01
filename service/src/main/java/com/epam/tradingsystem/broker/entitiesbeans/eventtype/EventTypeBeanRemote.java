package com.epam.tradingsystem.broker.entitiesbeans.eventtype;
import javax.ejb.Remote;

import com.epam.tradingsystem.broker.entities.EventType;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Remote
public interface EventTypeBeanRemote  extends GenericBean<Integer, EventType>{

}
