package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.EventTypeDAO;
import com.epam.tradingsystem.broker.entities.EventType;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:13
 * To change this template use File | Settings | File Templates.
 */
public class EventTypeDAOImpl extends BaseDAOImpl<EventType> implements EventTypeDAO {
    public EventTypeDAOImpl() {
        setClazz(EventType.class);
    }
}
