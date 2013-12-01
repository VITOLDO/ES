package com.epam.tradingsystem.broker.exchange.quotes.generator.archive;

public class BearingPoints {

	private static final int BEARING_POINTS_VOLUME = 4;

	private int[] indexes = new int[BEARING_POINTS_VOLUME];
	private int[] prices = new int[BEARING_POINTS_VOLUME];

	public int[] getIndexes() {
		return indexes;
	}

	public int[] getPrices() {
		return prices;
	}

}