package com.epam.tradingsystem.broker.entitiesbeans.eventtype;
import javax.ejb.Local;

import com.epam.tradingsystem.broker.entities.EventType;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Local
public interface EventTypeBeanLocal extends GenericBean<Integer, EventType> {

}
