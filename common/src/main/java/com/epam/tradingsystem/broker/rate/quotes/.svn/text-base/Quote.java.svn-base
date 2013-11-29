package com.epam.tradingsystem.broker.rate.quotes;

import java.sql.Date;

public class Quote {
	/**
	 * code - identifier of quote
	 */
	private String code;
	
	/**
	 * Price for buy 
	 */
	private double ask;
	
	/**
	 * Price for sale
	 */
	private double bid;
	
	/**
	 * Date of creation
	 */
	private Date date;
	
	
	public Quote(String code, Date date, double ask, double bid) {
		this.code = code;
		this.date = date;
		this.ask = ask;
		this.bid = bid;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getAsk() {
		return ask;
	}
	public void setAsk(double ask) {
		this.ask = ask;
	}
	public double getBid() {
		return bid;
	}
	public void setBid(double bid) {
		this.bid = bid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format(
				"CODE: %s, \n" +
				"DATE: %s, \n" +
				"BID: %f, \n" +
				"ASK: %f \n", code,date.toString(),bid,ask
			 );
	}
}
