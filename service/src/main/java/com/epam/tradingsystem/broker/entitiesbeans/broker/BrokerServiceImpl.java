package com.epam.tradingsystem.broker.entitiesbeans.broker;

import com.epam.tradingsystem.broker.dao.BrokerDAO;
import com.epam.tradingsystem.broker.entities.Broker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 21:38
 * To change this template use File | Settings | File Templates.
 */
@Service("brokerService")
public class BrokerServiceImpl implements BrokerService {

    @Autowired
    private BrokerDAO brokerDAO;

    @Override
    public Broker findBrokerById(long id) {
        return brokerDAO.findById(id);
    }

    @Override
    public List<Broker> findAllBrokers() {
        return brokerDAO.findAll();
    }
}
