package com.epam.tradingsystem.broker.entitiesbeans.rate;
import javax.ejb.Local;

import com.epam.tradingsystem.broker.entities.Rate;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Local
public interface RateBeanLocal extends GenericBean<Integer, Rate> {

}
