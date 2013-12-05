package com.epam.tradingsystem.broker.entitiesbeans.tradingorder;

import com.epam.tradingsystem.broker.entities.TradingOrder;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 22:02
 * To change this template use File | Settings | File Templates.
 */
public interface TradingOrderService {

    TradingOrder findTradingOrderById(long id);
    List<TradingOrder> findAllTradingOrders();
}
