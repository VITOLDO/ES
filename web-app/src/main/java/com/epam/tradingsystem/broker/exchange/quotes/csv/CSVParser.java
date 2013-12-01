package com.epam.tradingsystem.broker.exchange.quotes.csv;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class CSVParser {


    /**
     * This Pattern will match on either quoted text or text between commas, including
     * whitespace, and accounting for beginning and end of line.
     */
   

    public static CSVParser getInstance() {
          return new CSVParser();   
    }

    public static ArrayList<String> parse(String csvLine, CSVSeparator sep){
    	
    	ArrayList<String> allMatches = new ArrayList<String>();
    	Matcher matcher = sep.getSeparator().matcher(csvLine);
        String match;
        while (matcher.find()) {
                match = matcher.group(1);
                if (match!=null) {
                        allMatches.add(match);
                }
                else {
                        allMatches.add(matcher.group(2));
                }
        }
               
        if (allMatches.size()>0) {
                return allMatches;
        }
        else {
                throw new IllegalArgumentException();
        }                       
    }   
   
}
