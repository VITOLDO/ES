package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.TradingOrderDAO;
import com.epam.tradingsystem.broker.entities.TradingOrder;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:19
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class TradingOrderDAOImpl extends BaseDAOImpl<TradingOrder> implements TradingOrderDAO {
    public TradingOrderDAOImpl() {
        setClazz(TradingOrder.class);
    }
}
