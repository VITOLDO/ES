package com.epam.tradingsystem.broker.entitiesbeans.ticker;

import com.epam.tradingsystem.broker.entities.Ticker;

import java.util.List;

public interface TickerService {

    Ticker findTickerById(long id);
    List<Ticker> findAllTickers();
}
