package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.EventDAO;
import com.epam.tradingsystem.broker.entities.Event;
import com.epam.tradingsystem.broker.entities.Trader;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:12
 * To change this template use File | Settings | File Templates.
 */
public class EventDAOImpl extends BaseDAOImpl<Event> implements EventDAO {
    public EventDAOImpl() {
        setClazz(Event.class);
    }

    @Override
    public List<Event> findEventsByTrader(Trader trader) {
        return getHibernateTemplate().find("from Event e where e.trader = trader");
    }
}
