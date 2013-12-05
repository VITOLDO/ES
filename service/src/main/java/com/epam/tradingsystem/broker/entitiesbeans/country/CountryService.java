package com.epam.tradingsystem.broker.entitiesbeans.country;

import com.epam.tradingsystem.broker.entities.Country;

import java.util.List;

public interface CountryService {

    Country findCountryById(long id);
    List<Country> findAllCountries();
}