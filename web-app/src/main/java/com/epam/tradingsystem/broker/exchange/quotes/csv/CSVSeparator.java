package com.epam.tradingsystem.broker.exchange.quotes.csv;

import java.util.regex.Pattern;

public class CSVSeparator {
	 private static final Pattern dotcomaPattern = Pattern.compile("\"([^\"]*)\"|(?<=;|^)([^;]*)(?:;|$)");
	 private static final Pattern comaPattern = Pattern.compile("\"([^\"]*)\"|(?<=,|^)([^,]*)(?:,|$)");
	 private SeparatorType sepType;
	 public CSVSeparator(SeparatorType sepType){
		this.sepType = sepType;
	 }
	 
	 public Pattern getSeparator(){
		 switch(sepType){
			case COMA: return comaPattern;
			case DOTCOMA:return dotcomaPattern;
			default: return null;
			}
	 }
}
