package com.epam.tradingsystem.broker.exchange.quotes.generator.archive;
import java.util.List;


public interface CandleApi {

	int getClosePrice();

	int getHighPrice();

	int getLowPrice();

	int getOpenPrice();

	int getPeriod();

	List<TickApi> getTicks();

	int getVolume();

	void setClosePrice(int closePrice);

	void setHighPrice(int highPrice);

	void setLowPrice(int lowPrice);

	void setOpenPrice(int openPrice);

	void setPeriod(int period);

	void setTicks(List<TickApi> ticks);

	void setVolume(int volume);

}
