package com.epam.tradingsystem.broker.entitiesbeans.orderoperation;

import com.epam.tradingsystem.broker.dao.OrderOperationDAO;
import com.epam.tradingsystem.broker.entities.OrderOperation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 21:51
 * To change this template use File | Settings | File Templates.
 */
public class OrderOperationServiceImpl implements OrderOperationService {

    @Autowired
    private OrderOperationDAO orderOperationDAO;

    @Override
    public OrderOperation findOrderOperationById(long id) {
        return orderOperationDAO.findById(id);
    }

    @Override
    public List<OrderOperation> findAllOrderOperations() {
        return orderOperationDAO.findAll();
    }
}
