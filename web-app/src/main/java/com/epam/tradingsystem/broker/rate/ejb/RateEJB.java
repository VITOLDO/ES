package com.epam.tradingsystem.broker.rate.ejb;

import com.epam.tradingsystem.broker.rate.quotes.Quote;
import com.epam.tradingsystem.broker.rate.quotes.RatesView;

import java.util.List;

public class RateEJB implements RateEJBLocal, RateEJBRemote {
    /**
     * Default constructor. 
     */
    public RateEJB() {
    }

	@Override
	public List<Quote> getLastQuotes() {	
		RatesView ratesView = RatesView.getInstance();
		
		return ratesView.getRates();
	}
}
