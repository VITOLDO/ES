package com.epam.tradingsystem.broker.rate.ejb;

import java.util.List;

import javax.ejb.Stateless;

import com.epam.tradingsystem.broker.rate.quotes.Quote;
import com.epam.tradingsystem.broker.rate.quotes.RatesView;

/**
 * Session Bean implementation class CurrencyBean
 */
@Stateless
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
