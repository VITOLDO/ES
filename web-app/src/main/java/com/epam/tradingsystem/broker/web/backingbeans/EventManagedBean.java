package com.epam.tradingsystem.broker.web.backingbeans;

import com.epam.tradingsystem.broker.entities.Event;
import com.epam.tradingsystem.broker.entities.Trader;
import com.epam.tradingsystem.broker.entitiesbeans.event.EventService;
import com.epam.tradingsystem.broker.events.commands.LoggerCommand;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.util.*;

public class EventManagedBean {
	@Autowired
	private EventService eventService;
	
	/**
	 * List of filter names
	 */
	private final String[] FILTERS = new String[] {"Order activity", "Trader activity"};
	
	/**
	 * Relation between filter and event types. One filter have a list of event_types_id
	 */
	private Map<String, List<Integer>> TYPES_BY_FILTERS;
	
	/**
	 * List of filter type checkboxes. 
	 * Key(String) value is name filter type. Value(Boolean) is state of checkbox. 
	 */
	private Map<String, Boolean> filterTypes;
	
	/**
	 * Date range for search - filterDateFrom to filterDateTo. 
	 */
	private Date filterDateFrom;
	private Date filterDateTo;
	
	/**
	 * List of event that satisfy conditions.
	 */
	private List<Event> eventData;
	
	/**
	 * Count events that shows on one page.
	 */
	private final int EVENTS_PER_PAGE = 10;
	
	private Integer currentPage = 0;
	private Integer totalPages = 0;
	
	private int countEvents = 0;

	/**
	 * Initial all filters by default values
	 */
	public EventManagedBean() {
		filterDateFrom = Calendar.getInstance().getTime();
        filterDateTo = Calendar.getInstance().getTime();

        TYPES_BY_FILTERS = new HashMap<String, List<Integer>>();
        filterTypes = new HashMap<String, Boolean>();
		
        // Order activity
        filterTypes.put(FILTERS[0], true);
		List<Integer> eventTypes = new ArrayList<Integer>();
		eventTypes.add(LoggerCommand.ORDER_CREATE);
		eventTypes.add(LoggerCommand.ORDER_EXEC);
		eventTypes.add(LoggerCommand.ORDER_CANCELED);
		TYPES_BY_FILTERS.put(FILTERS[0], eventTypes);
		
        // Trader activity
		filterTypes.put(FILTERS[1], true);
		eventTypes = new ArrayList<Integer>();
		eventTypes.add(LoggerCommand.POSITION_CREATE);
		eventTypes.add(LoggerCommand.POSITION_EXEC);
		eventTypes.add(LoggerCommand.POSITION_CANCELED);
		TYPES_BY_FILTERS.put(FILTERS[1], eventTypes);
	}
	
	/**
	 * Use filters for refresh data
	 * @return
	 */
	public String applyFilters() {
		/**
		 * List of EVENT_TYPE.IDs in database for search
		 *
		 */
		List<Integer> eventTypesForSearch = new ArrayList<Integer>();
		
		// for each filter type
		for (String key : filterTypes.keySet()) {
			// If filter is true, get All Event types for this filter.
			if (filterTypes.get(key)) {
				List<Integer> eventTypesByFilter = TYPES_BY_FILTERS.get(key);
				eventTypesForSearch.addAll(eventTypesByFilter);
			}
		}
		
		// Get count of events for paging 
//		countEvents = eventService.getCount(filterDateFrom, filterDateTo, eventTypesForSearch, getCurrentTrader());
		totalPages = countEvents / EVENTS_PER_PAGE;
		
		// Get all events that satisfy filters
//		eventData = eventService.search(filterDateFrom, filterDateTo, eventTypesForSearch, getCurrentTrader(), currentPage, EVENTS_PER_PAGE);
		
		return null;
	}
	
	public String previousPageAction() {
		if (currentPage > 0) {
			currentPage--;			
		}
		return applyFilters();
	}
	
	public String nextPageAction() {
		if (currentPage < (totalPages)) {
			currentPage++;			
		}
		return applyFilters();		
	}

	private Trader getCurrentTrader() {
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(
				true);
		return (Trader) session.getAttribute("currentUser");
	}

	// Default Getters and Setters.
	
	public Map<String, Boolean> getFilterTypes() {
		return filterTypes;
	}

	public void setFilterTypes(Map<String, Boolean> filterTypes) {
		this.filterTypes = filterTypes;
	}

	public Date getFilterDateFrom() {
		return filterDateFrom;
	}

	public void setFilterDateFrom(Date filterDateFrom) {
		this.filterDateFrom = filterDateFrom;
	}

	public Date getFilterDateTo() {
		return filterDateTo;
	}

	public void setFilterDateTo(Date filterDateTo) {
		this.filterDateTo = filterDateTo;
	}

	public String[] getFILTERS() {
		return FILTERS;
	}

	public List<Event> getEventData() {
		return eventData;
	}

	public void setEventData(List<Event> eventData) {
		this.eventData = eventData;
	}

	/**
	 * Return page + 1 for show on page, because paging begin from zero
	 * @return
	 */
	public Integer getCurrentPage() {
		return currentPage+1;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	/**
	 * Return page + 1 for show on page, because paging begin from zero
	 * @return
	 */
	public Integer getTotalPages() {
		return totalPages+1;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

}
