package com.epam.tradingsystem.broker.exchange.quotes.generator.archive;

import java.util.ArrayList;
import java.util.List;


public class CandleGenerator implements CandleGeneratorApi {

	private static final int SHADOW_COEFFICIENT = 3;
	private static final int TICK_VOLUME_SCALE = 8;
	private static final int CANDLE_SCALE = 500;
	private static final int MIN_TICK_VOLUME = 10;
	private static final double VOLUME_SCALE = 4;

	TickGeneratorApi tickGenerator = new TickGenerator();
	DistributionConverterApi distributionConverter = new DistributionConverter();

	@Override
	public List<CandleApi> generateCandles(int quantity, int period,
			double scale, int startPrice) {
		List<CandleApi> candles = new ArrayList<CandleApi>();
		int openPrice = 0;
		int closePrice = startPrice;
		int highPrice = 0;
		int tickVolume = 0;
		int lowPrice = 0;
		for (int i = 0; i < quantity; i++) {

			openPrice = (int) (closePrice + tickGenerator
					.generateTickIncrement(scale));
			closePrice = closePrice + generateCandleIncrement(scale, period);

			tickVolume = generateCandleTickVolume(scale, period);

			lowPrice = (int) ((openPrice <= closePrice) ? (openPrice - Math
					.abs(generateCandleIncrement(scale, period)
							/ SHADOW_COEFFICIENT)) : (closePrice - Math
					.abs(generateCandleIncrement(scale, period)
							/ SHADOW_COEFFICIENT)));

			highPrice = (int) ((openPrice >= closePrice) ? (openPrice + Math
					.abs(generateCandleIncrement(scale, period)
							/ SHADOW_COEFFICIENT)) : (closePrice + Math
					.abs(generateCandleIncrement(scale, period)
							/ SHADOW_COEFFICIENT)));

			CandleApi candle = new Candle(openPrice, closePrice, highPrice,
					lowPrice, period, tickVolume);

			candles.add(candle);
		}
		return candles;
	}

	private int generateCandleIncrement(double scale, int period) {
		return (int) (distributionConverter.getRandomLaplas(0, scale) * period / CANDLE_SCALE);
	}

	private int generateCandleTickVolume(double scale, int period) {
		return MIN_TICK_VOLUME
				+ (int) (Math.abs(distributionConverter.getRandomLaplas(0,
						VOLUME_SCALE) * TICK_VOLUME_SCALE));
	}

	@Override
	public List<CandleApi> generatePreciseCandles(int quantity, int period,
			double scale, int startPrice) {
		List<CandleApi> candles = new ArrayList<CandleApi>();
		int tickVolume = 0;
		int totalVolume = 0;
		int globalCounter = 0;
		List<Integer> tickVolumes = new ArrayList<Integer>();
		for (int i = 0; i < quantity; i++) {
			tickVolume = generateCandleTickVolume(scale, period);
			tickVolumes.add(tickVolume);
			totalVolume += tickVolume;
		}
		List<TickApi> allTicks = tickGenerator.generateTicks(startPrice,
				totalVolume, scale);
		for (int i = 0; i < quantity; i++) {
			CandleApi candle = new Candle(period, tickVolumes.get(i));
			List<TickApi> ticks = new ArrayList<TickApi>();
			for (int j = 0; j < tickVolumes.get(i); j++, globalCounter++) {
				ticks.add(new Tick(allTicks.get(globalCounter).getCandleTime(), allTicks.get(globalCounter)
						.getPrice()));
			}
			int lowPrice = ticks.get(0).getPrice();
			int highPrice = ticks.get(0).getPrice();
			int openPrice = ticks.get(0).getPrice();
			int closePrice = ticks.get(tickVolumes.get(i) - 1).getPrice();
			candle.setOpenPrice(openPrice);
			candle.setClosePrice(closePrice);
			for (int j = 0; j < ticks.size(); j++) {
				lowPrice = (lowPrice < ticks.get(j).getPrice()) ? ticks.get(j)
						.getPrice() : lowPrice;
				highPrice = (highPrice > ticks.get(j).getPrice()) ? ticks
						.get(j).getPrice() : highPrice;
			}
			candle.setLowPrice(lowPrice);
			candle.setHighPrice(highPrice);
			candle.setTicks(ticks);
			candles.add(candle);
		}
		return candles;
	}
}
