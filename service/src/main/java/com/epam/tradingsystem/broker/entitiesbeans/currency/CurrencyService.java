package com.epam.tradingsystem.broker.entitiesbeans.currency;

import com.epam.tradingsystem.broker.entities.Currency;

import java.util.List;

public interface CurrencyService {

    Currency findCurrencyById(long id);
    List<Currency> findAll();
}
