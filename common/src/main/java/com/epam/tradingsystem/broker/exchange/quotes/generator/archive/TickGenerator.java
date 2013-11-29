package com.epam.tradingsystem.broker.exchange.quotes.generator.archive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TickGenerator implements TickGeneratorApi {

	private DistributionConverter distributionConverter = new DistributionConverter();

	private static final int DEFAULT_CORRECTION = 10;

	private static final int TIME_SCALE = 10;

	private static final int TICK_INCREMENT_SCALE = 50;

	private int correction = DEFAULT_CORRECTION;

	private int correctRegardingExtremum(int price, CandleApi candle) {

		if (price > candle.getHighPrice()) {
			price = candle.getHighPrice()
					- (int) (Math.random() * ((price - candle.getHighPrice() > candle
							.getLowPrice()) ? price - candle.getHighPrice()
							: correction));
		}

		if (price < candle.getLowPrice()) {
			price = candle.getLowPrice()
					+ (int) (Math.random() * ((candle.getLowPrice() - price < candle
							.getHighPrice()) ? candle.getLowPrice() - price
							: correction));
		}
		return price;
	}

	private BearingPoints generateBearingPoints(CandleApi candle) {

		int correctionInterval = candle.getVolume() / correction;
		int minExtremumInterval = correctionInterval * 2;
		;

		BearingPoints bearingPoints = new BearingPoints();

		int firstExtremumTickIndex = bearingPoints.getIndexes().length - 3;

		int secondExtremumTickIndex = bearingPoints.getIndexes().length - 2;

		bearingPoints.getIndexes()[0] = 0;
		bearingPoints.getPrices()[firstExtremumTickIndex] = minExtremumInterval
				+ (int) (Math.random() * (candle.getVolume() - 2
						* minExtremumInterval - correctionInterval));
		bearingPoints.getIndexes()[secondExtremumTickIndex] = bearingPoints
				.getIndexes()[firstExtremumTickIndex]
				+ minExtremumInterval
				+ +(int) (Math.random() * (candle.getVolume()
						- bearingPoints.getIndexes()[firstExtremumTickIndex]
						- 2 * minExtremumInterval - correctionInterval));
		bearingPoints.getIndexes()[bearingPoints.getIndexes().length - 1] = candle
				.getVolume() - 1;

		int extremumOrderChoice = (int) (Math.random() * 2);

		bearingPoints.getPrices()[0] = candle.getOpenPrice();
		bearingPoints.getPrices()[firstExtremumTickIndex] = (extremumOrderChoice == 1) ? candle
				.getHighPrice() : candle.getLowPrice();
		bearingPoints.getPrices()[secondExtremumTickIndex] = (extremumOrderChoice == 0) ? candle
				.getHighPrice() : candle.getLowPrice();
		bearingPoints.getPrices()[bearingPoints.getIndexes().length - 1] = candle
				.getClosePrice();

		if (bearingPoints.getPrices()[firstExtremumTickIndex] == candle
				.getOpenPrice()) {
			bearingPoints.getIndexes()[firstExtremumTickIndex] = 0;
		}

		if (bearingPoints.getPrices()[secondExtremumTickIndex] == candle
				.getClosePrice()) {
			bearingPoints.getIndexes()[secondExtremumTickIndex] = candle
					.getVolume() - 1;
		}
		return bearingPoints;

	}

	private List<Integer> generateTickPrices(CandleApi candle,
			BearingPoints bearingPoints, List<Integer> times, double scale) {
		ArrayList<Integer> prices = new ArrayList<Integer>();

		for (int i = 0; i < bearingPoints.getIndexes().length - 1; i++) {
			prices.addAll(generateTickPrices(
					times.subList(bearingPoints.getIndexes()[i],
							bearingPoints.getIndexes()[i + 1]),
					bearingPoints.getPrices()[i],
					bearingPoints.getPrices()[i + 1], candle, scale));
		}

		return (prices);
	}

	public int generateTickIncrement(double scale) {
		return (int) distributionConverter.getRandomLaplas(0, scale);
	}

	private List<Integer> generateTickPrices(List<Integer> period,
			int startPrice, int destinationEndPrice, CandleApi candle,
			double scale) {

		ArrayList<Integer> prices = new ArrayList<Integer>();

		if (period.size() == 0) {
			return prices;
		}

		int price = startPrice;

		for (int i = 0; i < period.size(); i++) {
			prices.add(price);

			price = (int) (price + generateTickIncrement(scale));

			price = correctRegardingExtremum(price, candle);

		}

		int actualEndPrice = prices.get(period.size() - 1);
		int[] actualCorrectionLineValues = new int[period.size()];
		int[] destinationCorrectionLineValues = new int[period.size()];
		int correctionTime = period.get(period.size() - 1) - period.get(0);

		int correctionPrice = 0;

		for (int i = 1; i < period.size() - 1; i++) {

			actualCorrectionLineValues[i] = startPrice
					+ (period.get(i) - period.get(0))
					* (actualEndPrice - prices.get(0)) / (correctionTime);

			destinationCorrectionLineValues[i] = startPrice
					+ (period.get(i) - period.get(0))
					* (destinationEndPrice - prices.get(0)) / (correctionTime);

			correctionPrice = destinationCorrectionLineValues[i]
					+ prices.get(i) - actualCorrectionLineValues[i];

			correctionPrice = correctRegardingExtremum(correctionPrice, candle);

			prices.set(i, correctionPrice);

		}

		prices.set(period.size() - 1, destinationEndPrice);

		return prices;
	}

	@Override
	public List<Integer> generateTickTimes(CandleApi candle) {

		if (candle.getVolume() == 0) {
			return null;
		}
		int[] ticksArray = new int[candle.getVolume()];

		ArrayList<Integer> ticks = new ArrayList<Integer>();

		int tick = 0;
		for (int i = 0; i < candle.getVolume(); i++) {
			tick = (int) (Math.random() * candle.getPeriod());
			ticksArray[i] = tick;
		}

		Arrays.sort(ticksArray);

		for (int i = 0; i < ticksArray.length; i++) {
			ticks.add(ticksArray[i]);
		}

		return ticks;
	}

	@Override
	public List<TickApi> generateTicksForCandle(CandleApi candle, double scale) {
		List<TickApi> ticks = new ArrayList<TickApi>();

		List<Integer> times = generateTickTimes(candle);
		List<Integer> prices = generateTickPrices(candle,
				generateBearingPoints(candle), times, scale);
		for (int i = 0; i < times.size(); i++) {
			TickApi tick = new Tick(times.get(i), prices.get(i));
			ticks.add(tick);
		}
		return ticks;

	}

	@Override
	public List<TickApi> generateTickPrices(int startPrice, int period,
			double scale) {
		List<TickApi> ticks = new ArrayList<TickApi>();
		int price = startPrice;
		for (int i = 0; i < period; i++) {
			TickApi tick = new Tick(0, price);
			price = (int) (price + generateTickIncrement(scale));
			ticks.add(tick);
		}
		return ticks;
	}

	@Override
	public List<TickApi> generateTicks(int startPrice, int period, double scale) {
		List<TickApi> ticks = new ArrayList<TickApi>();
		int price = startPrice;
		int timeDelta = 0;
		int time = 0;
		for (int i = 0; i < period; i++) {
			TickApi tick = new Tick(time, price);
			timeDelta = (int) Math.abs(distributionConverter.getRandomNormal(
					0, scale) * TIME_SCALE);
			time += timeDelta;
			price = (int) (price + generateTickIncrement(timeDelta / TICK_INCREMENT_SCALE * scale
					));
			ticks.add(tick);
		}
		return ticks;
	}
}