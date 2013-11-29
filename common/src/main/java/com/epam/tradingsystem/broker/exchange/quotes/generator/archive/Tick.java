package com.epam.tradingsystem.broker.exchange.quotes.generator.archive;



public class Tick implements TickApi {

	@Override
	public String toString() {
		return "Tick [price=" + price + ", candleTime=" + candleTime + "]";
	}

	private int price;
	private int candleTime;

	public Tick(Integer candleTime, Integer price) {
		setCandleTime(candleTime);
		setPrice(price);
	}

	@Override
	public int getCandleTime() {
		return candleTime;
	}

	@Override
	public void setCandleTime(int miliseconds) {
		this.candleTime = miliseconds;
	}

	@Override
	public int getPrice() {
		return price;
	}

	@Override
	public void setPrice(int price) {
		this.price = price;
	}

}
