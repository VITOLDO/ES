package com.epam.tradingsystem.broker.rate.quotes;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;

import com.epam.tradingsystem.broker.exchange.quotes.csv.CSVParser;
import com.epam.tradingsystem.broker.exchange.quotes.csv.CSVSeparator;
import com.epam.tradingsystem.broker.exchange.quotes.csv.SeparatorType;

public class QuoteBuilder {

	public static Quote build(String buildStr) {
		ArrayList<String> quoteInfo = CSVParser.parse(buildStr,
				new CSVSeparator(SeparatorType.COMA));

		String code;
		String bidstr;
		String askstr;
		String datestr;

		if (quoteInfo.size() == 4) {
			code = quoteInfo.get(0);
			datestr = quoteInfo.get(1);
			bidstr = quoteInfo.get(2);
			askstr = quoteInfo.get(3);

			if (validateSymbol(code) 
					&& validateRate(bidstr)
					&& validateRate(askstr)
					&& validateDate(datestr)) {
				
				Date date = new Date(Long.valueOf(datestr));
				Double bid = Double.parseDouble(bidstr);
				Double ask = Double.parseDouble(askstr);
				return new Quote(code, date, bid, ask);
			}
			else{
				return null;
			}
		}
		return null;
	}

	private static boolean validateSymbol(String symbolString) {
		// TODO: hardcode
		if (symbolString.equalsIgnoreCase("USD/EUR")
				|| symbolString.equalsIgnoreCase("USD/CHF")) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean validateDate(String dateString) {
		return true;
	}

	private static boolean validateRate(String rateString) {
		return true;
	}
}
