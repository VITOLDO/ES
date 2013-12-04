package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.OrderOperationDAO;
import com.epam.tradingsystem.broker.entities.OrderOperation;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:15
 * To change this template use File | Settings | File Templates.
 */
public class OrderOperationDAOImpl extends BaseDAOImpl<OrderOperation> implements OrderOperationDAO {
    public OrderOperationDAOImpl() {
        setClazz(OrderOperation.class);
    }
}
