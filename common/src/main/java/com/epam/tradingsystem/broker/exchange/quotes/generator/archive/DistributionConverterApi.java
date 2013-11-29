package com.epam.tradingsystem.broker.exchange.quotes.generator.archive;

public interface DistributionConverterApi {

	double getRandomLaplas(double location, double scale);

	double getRandomNormal(double location, double scale);

}
