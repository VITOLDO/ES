package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.RateDAO;
import com.epam.tradingsystem.broker.entities.Rate;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:16
 * To change this template use File | Settings | File Templates.
 */
public class RateDAOImpl extends BaseDAOImpl<Rate> implements RateDAO {
    public RateDAOImpl() {
        setClazz(Rate.class);
    }
}
