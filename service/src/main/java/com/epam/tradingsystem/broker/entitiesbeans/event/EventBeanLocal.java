package com.epam.tradingsystem.broker.entitiesbeans.event;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.epam.tradingsystem.broker.entities.Event;
import com.epam.tradingsystem.broker.entities.Trader;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBean;

@Local
public interface EventBeanLocal extends GenericBean<Integer, Event> {
	public List<Event> findEventByTrader(Trader trader);
	public List<Event> search(Date dateFrom, Date dateTo, List<Integer> eventTypes, Trader trader, int currentPage, int eventOnPage);
	public Integer getCount(Date dateFrom, Date dateTo, List<Integer> eventTypes, Trader trader);
}
