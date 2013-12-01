package com.epam.tradingsystem.broker.web.backingbeans;

import java.util.List;

import javax.ejb.EJB;

import com.epam.tradingsystem.broker.rate.ejb.RateEJBLocal;
import com.epam.tradingsystem.broker.rate.quotes.Quote;

//@ManagedBean(name="rates")
//@ApplicationScoped
public class RatesManagedBean {
	
	@EJB
	private RateEJBLocal rateBean;

	public RatesManagedBean() {

	}
	
	public List<Quote> getRatesView() {
		return rateBean.getLastQuotes();
	}
	
}