package com.epam.tradingsystem.broker.entitiesbeans.rate;

import com.epam.tradingsystem.broker.entities.Rate;

import java.util.List;

public interface RateService {

    Rate findRateById(long id);
    List<Rate> findAllRates();
}
