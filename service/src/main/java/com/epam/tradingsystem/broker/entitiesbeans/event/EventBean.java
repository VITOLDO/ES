package com.epam.tradingsystem.broker.entitiesbeans.event;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.epam.tradingsystem.broker.entities.Event;
import com.epam.tradingsystem.broker.entities.Trader;
import com.epam.tradingsystem.broker.entitiesbeans.GenericBeanImpl;


/**
 * Session Bean implementation class EventTypeBean
 */
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class EventBean extends GenericBeanImpl<Integer, Event>
		implements EventBeanRemote, EventBeanLocal {
    /**
     * Default constructor. 
     */
	public EventBean() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Event> findEventByTrader(Trader trader){
		Query q = entityManager.createQuery("select object(o) from "+entityClass.getName()+" as o where o.trader="+trader.getUserId());
		return q.getResultList();
	}
	
	private Query prepareSearchQuery(Date dateFrom, Date dateTo,
			List<Integer> eventTypes, Trader trader, Integer currentPage, Integer eventOnPage) {
		
		if (eventTypes == null || eventTypes.size() == 0) {
			return null;
		}
		
		Query q = entityManager.createQuery(
				"SELECT " +
					"e " +
				"FROM " +
					"Event e " +
					"JOIN e.eventType e_type " +
				"WHERE " +
					"e_type.eventTypeId IN (:event_types_ids) AND " +
					"e.date >= :dateFrom AND e.date <= :dateTo AND " +
					"e.trader = :trader ");

		if (currentPage != null && eventOnPage != null) {
			q.setFirstResult(currentPage*eventOnPage)
			 .setMaxResults(eventOnPage);
		}
		
		q.setParameter("event_types_ids", eventTypes);
		q.setParameter("trader", trader);
		q.setParameter("dateFrom", dateFrom);
		q.setParameter("dateTo", dateTo);
		
		return q;
	}
	
	@Override
	public List<Event> search(Date dateFrom, Date dateTo,
			List<Integer> eventTypes, Trader trader, 
			int currentPage, int eventOnPage) {
		Query q = prepareSearchQuery(dateFrom, dateTo, eventTypes, trader, 
				currentPage, eventOnPage);

		return q.getResultList();
	}
	
	public Integer getCount(Date dateFrom, Date dateTo,
			List<Integer> eventTypes, Trader trader) {
		
		Query q = prepareSearchQuery(dateFrom, dateTo, eventTypes, trader, null, null);
		List<Event> result = q.getResultList();
		
		return result.size();
	}
}
