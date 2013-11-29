package com.epam.tradingsystem.broker.exchange.quotes.generator.archive;

import java.util.List;


public class Candle implements CandleApi {

	private int closePrice;
	private int highPrice;
	private int lowPrice;
	private int openPrice;
	private int period;
	private List<TickApi> ticks = null;
	private int volume;

	@Override
	public String toString() {
		return "" + openPrice + ", " + lowPrice + ", " + highPrice
				+ ", " + closePrice + ", " + volume + ", " + period;
	}

	public Candle(int openPrice, int closePrice, int highPrice, int lowPrice,
			int period, int tickVolume) {
		setOpenPrice(openPrice);
		setClosePrice(closePrice);
		setHighPrice(highPrice);
		setLowPrice(lowPrice);
		setPeriod(period);
		setVolume(tickVolume);
	}

	public Candle(int period, int volume) {
		setPeriod(period);
		setVolume(volume);
	}

	@Override
	public int getClosePrice() {
		return closePrice;
	}

	@Override
	public int getHighPrice() {
		return highPrice;
	}

	@Override
	public int getLowPrice() {
		return lowPrice;
	}

	@Override
	public int getOpenPrice() {
		return openPrice;
	}

	@Override
	public int getPeriod() {
		return period;
	}

	@Override
	public List<TickApi> getTicks() {
		return ticks;
	}

	@Override
	public int getVolume() {
		return volume;
	}

	@Override
	public void setClosePrice(int closePrice) {
		this.closePrice = closePrice;
	}

	@Override
	public void setHighPrice(int highPrice) {
		this.highPrice = highPrice;
	}

	@Override
	public void setLowPrice(int lowPrice) {
		this.lowPrice = lowPrice;
	}

	@Override
	public void setOpenPrice(int openPrice) {
		this.openPrice = openPrice;
	}

	@Override
	public void setPeriod(int period) {
		this.period = period;
	}

	@Override
	public void setTicks(List<TickApi> ticks) {
		this.ticks = ticks;

	}

	@Override
	public void setVolume(int volume) {
		this.volume = volume;
	}

}
