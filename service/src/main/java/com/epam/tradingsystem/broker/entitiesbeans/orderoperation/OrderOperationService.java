package com.epam.tradingsystem.broker.entitiesbeans.orderoperation;

import com.epam.tradingsystem.broker.entities.OrderOperation;

import java.util.List;

public interface OrderOperationService {

    OrderOperation findOrderOperationById(long id);
    List<OrderOperation> findAllOrderOperations();
}
