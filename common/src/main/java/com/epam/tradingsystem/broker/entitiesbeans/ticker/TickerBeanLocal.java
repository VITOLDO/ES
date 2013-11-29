package com.epam.tradingsystem.broker.entitiesbeans.ticker;
import javax.ejb.Local;

import com.epam.tradingsystem.broker.entities.Ticker;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Local
public interface TickerBeanLocal extends GenericBean<Integer, Ticker> {

}
