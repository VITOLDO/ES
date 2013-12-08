package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.CurrencyDAO;
import com.epam.tradingsystem.broker.entities.Currency;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:09
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CurrencyDAOImpl extends BaseDAOImpl<Currency> implements CurrencyDAO {
    public CurrencyDAOImpl() {
        setClazz(Currency.class);
    }
}
