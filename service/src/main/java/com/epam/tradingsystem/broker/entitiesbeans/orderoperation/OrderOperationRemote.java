package com.epam.tradingsystem.broker.entitiesbeans.orderoperation;

import javax.ejb.Remote;


import com.epam.tradingsystem.broker.entities.OrderOperation;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Remote
public interface OrderOperationRemote extends GenericBean<Integer, OrderOperation> {

}
