package com.epam.tradingsystem.broker.exchange.quotes.generator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yulia_Kramarenko
 * 
 */
public class Generator {

	/**
	 * These two constants, TIME_SCALE and PRICE SCALE may be needed for
	 * advanced tuning of our chart
	 */
	private static final double TIME_SCALE = 1;

	/**
	 * These two constants, TIME_SCALE and PRICE SCALE may be needed for
	 * advanced tuning of our chart
	 */
	private static final double PRICE_SCALE = 1;

	/**
	 * Expected squared deviation of time increment function
	 */
	private static final int TIME_VARIATION = 400;

	/**
	 * Minimum value of time increment in milliseconds
	 */
	private static final int MIN_TICK = 200;

	/**
	 * Maximum value of time increment in milliseconds
	 */
	private static final int MAX_TICK = 3000;

	/**
	 * Scale quotient to convert between units of measurement
	 */
	private static final double MILLI_QUOTIENT = 0.001;

	/**
	 * This method is recommended to be used to generate quotes for advance.
	 * Attention: be careful with price and variation value choice to prevent overflows as
	 * exponential conversions during generation process take place.
	 * 
	 * @param startPrice
	 *            - price from which we start ticking.
	 * @param period
	 *            - quantity of ticks
	 * @param trend
	 *            - location parameter. Depending on it's sign (positive or
	 *            negative) and absolute value, the vector of price moving can
	 *            be tuned up or down with certain angle respectively
	 * @param volatility
	 *            - square deviation or the process model
	 * @return list of ticks for the specified period
	 */
	public List<Tick> generateTicks(int startPrice, int period, double trend,
			double volatility) {
		List<Tick> ticks = new ArrayList<Tick>();
		double price = startPrice;
		int timeDelta = 0;
		for (int i = 0; i < period; i++) {
			Tick tick = new Tick(timeDelta, price);
			timeDelta = (int) Math.min(MAX_TICK, (Math.max(MIN_TICK, Math
					.abs(DistributionConverter.getRandomNormal(600,
							TIME_VARIATION)))));
			double timedeltaInSeconds = timeDelta * MILLI_QUOTIENT * TIME_SCALE;
			price = incrementPrice(price, trend, volatility, timedeltaInSeconds);
			ticks.add(tick);
		}
		return ticks;
	}

	/**
	 * Can be used instead of generateTicks() method to generate quotes
	 * "on the fly".
	 * Attention: be careful with price and variation value choice to prevent overflows as
	 * exponential conversions during generation process take place.
	 * 
	 * @param price
	 *            - current price value
	 * @param trend
	 *            - location parameter
	 * @param volatility
	 *            - variance
	 * @param timeDelta
	 *            - time increment value
	 * @return incremented price for the specified time delta
	 */
	public double incrementPrice(double price, double trend, double volatility,
			double timeDelta) {

		double laplasProcessDelta = DistributionConverter.getRandomLaplas(0,
				timeDelta);
		double logarithmDelta = (trend - (Math.pow(volatility, 2) / 2))
				* timeDelta + volatility * laplasProcessDelta;
		logarithmDelta = Math.log(PRICE_SCALE * (Math.exp(logarithmDelta) - 1)
				+ 1);
		double logarithmResultingPrice = Math.log(price) + logarithmDelta;
		double resultingPrice = Math.exp(logarithmResultingPrice);
		return resultingPrice;
	}

}
