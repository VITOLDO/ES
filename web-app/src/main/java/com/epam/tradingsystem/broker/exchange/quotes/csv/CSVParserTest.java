package com.epam.tradingsystem.broker.exchange.quotes.csv;

import java.util.ArrayList;

import com.epam.tradingsystem.broker.rate.quotes.QuoteBuilder;



public class CSVParserTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> temp = CSVParser.parse("USD/EUR,Wed Sep 14 12:56:34 EEST 2011,1.366132242052781,1.5792027779746196;" +
				"USD/CHF,Wed Sep 14 12:56:34 EEST 2011,1.3782244854714194,1.4782290280617787",(new CSVSeparator(SeparatorType.DOTCOMA)));
		
		for(String t:temp){
			System.out.println(QuoteBuilder.build(t));
		}
		
	}

}
