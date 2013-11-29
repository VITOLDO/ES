package com.epam.tradingsystem.broker.entitiesbeans.country;

import javax.ejb.Local;

import com.epam.tradingsystem.broker.entities.Country;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Local
public interface CountryBeanLocal extends GenericBean<Integer, Country> {

}
