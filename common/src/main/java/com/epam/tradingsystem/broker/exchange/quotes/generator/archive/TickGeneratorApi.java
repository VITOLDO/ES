package com.epam.tradingsystem.broker.exchange.quotes.generator.archive;

import java.util.List;

public interface TickGeneratorApi {

	List<TickApi> generateTicksForCandle(CandleApi candleApi, double scale);

	int generateTickIncrement(double scale);

	List<TickApi> generateTickPrices(int startPrice, int period,
			double scale);

	List<Integer> generateTickTimes(CandleApi candle);

	List<TickApi> generateTicks(int startPrice, int period, double scale);

}
