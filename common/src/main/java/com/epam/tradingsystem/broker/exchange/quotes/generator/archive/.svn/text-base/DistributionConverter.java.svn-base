package com.epam.tradingsystem.broker.exchange.quotes.generator.archive;



public class DistributionConverter implements DistributionConverterApi {

	public double getRandomLaplas(double location, double scale) {
		double transformedRandomValue = 0;
		double uniformRandom = Math.random() - 0.5;

		transformedRandomValue = location - scale
				* (Math.signum(uniformRandom))
				* Math.log(1 - 2 * Math.abs(uniformRandom));

		return transformedRandomValue;

	}

	public double getRandomNormal(double location, double scale) {
		double transformedRandomValue = 0;
		double u = 0;
		double v = 0;
		double s = 0;

		do {
			u = Math.random() - 0.5;
			v = Math.random() - 0.5;
			s = u * u + v * v;
		} while (s >= 1);

		transformedRandomValue = location + scale * u
				* Math.sqrt(((-2) * Math.log(s)) / s);

		return transformedRandomValue;
	}

}
