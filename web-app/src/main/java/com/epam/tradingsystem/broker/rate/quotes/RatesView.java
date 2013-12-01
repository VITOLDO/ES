package com.epam.tradingsystem.broker.rate.quotes;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton RatesView.
 * Contain last quotes pool from exchange.
 * 
 * @author Olexii_Grachev
 *
 */
public class RatesView {
	private static RatesView rv = null;
	
	/**
	 * List of quotes parsed from exchange message.
	 */
	private List<Quote> rates = new ArrayList<Quote>();

	private RatesView() {
		
	}
	
	public static RatesView getInstance() {
		if(rv == null){
		 	rv = new RatesView();
		}
		return rv;
	}

	public List<Quote> getRates() {
		return rates;
	}

	public void setRates(List<Quote> rates) {
		this.rates = rates;
	}	
	
}
