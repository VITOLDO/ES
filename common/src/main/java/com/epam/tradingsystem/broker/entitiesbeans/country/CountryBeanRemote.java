package com.epam.tradingsystem.broker.entitiesbeans.country;

import javax.ejb.Remote;

import com.epam.tradingsystem.broker.entities.Country;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Remote
public interface CountryBeanRemote extends GenericBean<Integer, Country> {

}
