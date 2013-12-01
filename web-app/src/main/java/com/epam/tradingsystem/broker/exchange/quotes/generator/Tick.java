package com.epam.tradingsystem.broker.exchange.quotes.generator;

public class Tick {

	@Override
	public String toString() {
		return "Tick [price=" + price + ", timeIncrement="
				+ timeDelta + "]";
	}

	/**
	 * Current tick price
	 */
	private double price;

	/**
	 * Current tick time delta (previous tick time minus current tick time)
	 */
	private int timeDelta;

	
	public Tick(Integer candleTime, double price) {
		setCandleTime(candleTime);
		setPrice(price);
	}

	public int getCandleTime() {
		return timeDelta;
	}

	public void setCandleTime(int miliseconds) {
		this.timeDelta = miliseconds;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
