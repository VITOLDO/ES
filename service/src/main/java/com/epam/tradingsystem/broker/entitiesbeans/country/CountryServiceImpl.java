package com.epam.tradingsystem.broker.entitiesbeans.country;

import com.epam.tradingsystem.broker.dao.CountryDAO;
import com.epam.tradingsystem.broker.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Viktor
 * Date: 05.12.13
 * Time: 21:41
 * To change this template use File | Settings | File Templates.
 */
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDAO countryDAO;

    @Override
    public Country findCountryById(long id) {
        return countryDAO.findById(id);
    }

    @Override
    public List<Country> findAllCountries() {
        return countryDAO.findAll();
    }
}
