package com.epam.tradingsystem.broker.exchange.quotes.generator.archive;

import java.util.List;

public interface CandleGeneratorApi {
	
	List<CandleApi> generateCandles(int quantity, int period, double scale, int startPrice);

	List<CandleApi> generatePreciseCandles(int quantity, int period, double scale, int startPrice);

}
