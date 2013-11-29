package com.epam.tradingsystem.broker.entitiesbeans.ticker;
import javax.ejb.Remote;

import com.epam.tradingsystem.broker.entities.Ticker;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Remote
public interface TickerBeanRemote extends GenericBean<Integer, Ticker> {

}
