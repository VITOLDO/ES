package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.TickerDAO;
import com.epam.tradingsystem.broker.entities.Ticker;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:17
 * To change this template use File | Settings | File Templates.
 */
public class TickerDAOImpl extends BaseDAOImpl<Ticker> implements TickerDAO {
    public TickerDAOImpl() {
        setClazz(Ticker.class);
    }
}
