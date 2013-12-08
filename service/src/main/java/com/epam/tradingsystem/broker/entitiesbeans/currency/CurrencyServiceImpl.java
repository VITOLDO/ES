package com.epam.tradingsystem.broker.entitiesbeans.currency;

import com.epam.tradingsystem.broker.dao.CurrencyDAO;
import com.epam.tradingsystem.broker.entities.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 21:43
 * To change this template use File | Settings | File Templates.
 */
@Service("currencyService")
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyDAO currencyDAO;

    @Override
    public Currency findCurrencyById(long id) {
        return currencyDAO.findById(id);
    }

    @Override
    public List<Currency> findAll() {
        return currencyDAO.findAll();
    }
}
