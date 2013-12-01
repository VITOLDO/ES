package com.epam.tradingsystem.broker.entitiesbeans.orderoperation;

import javax.ejb.Local;

import com.epam.tradingsystem.broker.entities.OrderOperation;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Local
public interface OrderOperationLocal extends GenericBean<Integer, OrderOperation> {

}
