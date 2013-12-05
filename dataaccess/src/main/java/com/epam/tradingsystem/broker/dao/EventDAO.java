package com.epam.tradingsystem.broker.dao;

import com.epam.tradingsystem.broker.entities.Event;
import com.epam.tradingsystem.broker.entities.Trader;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:11
 * To change this template use File | Settings | File Templates.
 */
public interface EventDAO extends BaseDAO<Event> {
    List<Event> findEventsByTrader(Trader trader);
}
