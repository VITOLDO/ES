package com.epam.tradingsystem.broker.entitiesbeans.country;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.epam.tradingsystem.broker.entities.Country;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBeanImpl;

/**
 * Session Bean implementation class CountryBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CountryBean extends GenericBeanImpl<Integer, Country> implements CountryBeanRemote, CountryBeanLocal {

    /**
     * Default constructor. 
     */
    public CountryBean() {
        // TODO Auto-generated constructor stub
    }

}
