package com.epam.tradingsystem.broker.rate.ejb;

import java.util.List;

import com.epam.tradingsystem.broker.rate.quotes.Quote;

public interface RateEJBI {
	List<Quote> getLastQuotes();
}
