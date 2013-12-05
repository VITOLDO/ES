package com.epam.tradingsystem.broker.entitiesbeans.trader;

import com.epam.tradingsystem.broker.entities.Trader;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
public interface TraderService {

    Trader findTradaerById(long id);
    List<Trader> findAllTraders();

    void saveTrader(Trader trader);
}
