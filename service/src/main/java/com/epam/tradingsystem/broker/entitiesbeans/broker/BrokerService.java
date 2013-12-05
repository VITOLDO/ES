package com.epam.tradingsystem.broker.entitiesbeans.broker;

import com.epam.tradingsystem.broker.entities.Broker;

import java.util.List;


public interface BrokerService {

    Broker findBrokerById(long id);
    List<Broker> findAllBrokers();
}
