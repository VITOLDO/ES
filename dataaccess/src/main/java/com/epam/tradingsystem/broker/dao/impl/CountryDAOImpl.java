package com.epam.tradingsystem.broker.dao.impl;

import com.epam.tradingsystem.broker.dao.CountryDAO;
import com.epam.tradingsystem.broker.entities.Country;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 0:06
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class CountryDAOImpl extends BaseDAOImpl<Country> implements CountryDAO {
    public CountryDAOImpl() {
        setClazz(Country.class);
    }
}
