package com.epam.tradingsystem.broker.entitiesbeans.event;

import com.epam.tradingsystem.broker.dao.EventDAO;
import com.epam.tradingsystem.broker.entities.Event;
import com.epam.tradingsystem.broker.entities.Trader;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class EventServiceImpl implements EventService {

    @Autowired
    private EventDAO eventDAO;
	
	public List<Event> findEventByTrader(Trader trader){
		return eventDAO.findEventsByTrader(trader);
	}
	
//	private Query prepareSearchQuery(Date dateFrom, Date dateTo,
//			List<Integer> eventTypes, Trader trader, Integer currentPage, Integer eventOnPage) {
//
//		if (eventTypes == null || eventTypes.size() == 0) {
//			return null;
//		}
//
//		Query q = entityManager.createQuery(
//				"SELECT " +
//					"e " +
//				"FROM " +
//					"Event e " +
//					"JOIN e.eventType e_type " +
//				"WHERE " +
//					"e_type.eventTypeId IN (:event_types_ids) AND " +
//					"e.date >= :dateFrom AND e.date <= :dateTo AND " +
//					"e.trader = :trader ");
//
//		if (currentPage != null && eventOnPage != null) {
//			q.setFirstResult(currentPage*eventOnPage)
//			 .setMaxResults(eventOnPage);
//		}
//
//		q.setParameter("event_types_ids", eventTypes);
//		q.setParameter("trader", trader);
//		q.setParameter("dateFrom", dateFrom);
//		q.setParameter("dateTo", dateTo);
//
//		return q;
//	}
//
//	@Override
//	public List<Event> search(Date dateFrom, Date dateTo,
//			List<Integer> eventTypes, Trader trader,
//			int currentPage, int eventOnPage) {
//		Query q = prepareSearchQuery(dateFrom, dateTo, eventTypes, trader,
//				currentPage, eventOnPage);
//
//		return q.getResultList();
//	}
//
//	public Integer getCount(Date dateFrom, Date dateTo,
//			List<Integer> eventTypes, Trader trader) {
//
//		Query q = prepareSearchQuery(dateFrom, dateTo, eventTypes, trader, null, null);
//		List<Event> result = q.getResultList();
//
//		return result.size();
//	}

    @Override
    public Event findEventById(long id) {
        return eventDAO.findById(id);
    }

    @Override
    public List<Event> findAll() {
        return eventDAO.findAll();
    }
}
