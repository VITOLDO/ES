package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.BrokerDAO;
import com.epam.tradingsystem.broker.entities.Broker;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:05
 * To change this template use File | Settings | File Templates.
 */
public class BrokerDAOImpl extends BaseDAOImpl<Broker> implements BrokerDAO {
    public BrokerDAOImpl() {
        setClazz(Broker.class);
    }
}
