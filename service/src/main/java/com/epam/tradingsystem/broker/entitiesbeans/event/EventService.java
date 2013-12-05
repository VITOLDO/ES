package com.epam.tradingsystem.broker.entitiesbeans.event;

import com.epam.tradingsystem.broker.entities.Event;
import com.epam.tradingsystem.broker.entities.Trader;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 21:46
 * To change this template use File | Settings | File Templates.
 */
public interface EventService {

    Event findEventById(long id);
    List<Event> findAll();

    List<Event> findEventByTrader(Trader trader);
}
