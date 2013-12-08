package com.epam.tradingsystem.broker.entitiesbeans.rate;

import com.epam.tradingsystem.broker.dao.RateDAO;
import com.epam.tradingsystem.broker.entities.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 21:53
 * To change this template use File | Settings | File Templates.
 */
@Service("rateService")
public class RateServiceImpl implements RateService {

    @Autowired
    private RateDAO rateDAO;

    @Override
    public Rate findRateById(long id) {
        return rateDAO.findById(id);
    }

    @Override
    public List<Rate> findAllRates() {
        return rateDAO.findAll();
    }
}
