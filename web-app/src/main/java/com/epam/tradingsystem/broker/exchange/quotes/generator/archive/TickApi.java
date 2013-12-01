package com.epam.tradingsystem.broker.exchange.quotes.generator.archive;

public interface TickApi {
	
	int getCandleTime();
	void setCandleTime(int miliseconds);
	int getPrice();
	void setPrice(int price);

}
