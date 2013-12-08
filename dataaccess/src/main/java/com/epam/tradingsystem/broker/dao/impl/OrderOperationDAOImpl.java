package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.OrderOperationDAO;
import com.epam.tradingsystem.broker.entities.OrderOperation;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:15
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class OrderOperationDAOImpl extends BaseDAOImpl<OrderOperation> implements OrderOperationDAO {
    public OrderOperationDAOImpl() {
        setClazz(OrderOperation.class);
    }
}
