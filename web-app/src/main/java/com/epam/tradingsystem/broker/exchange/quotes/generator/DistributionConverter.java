package com.epam.tradingsystem.broker.exchange.quotes.generator;



public class DistributionConverter {
	
	/**
	 * @param location - location parameter for Laplas distribution
	 * @param variance - square deviation for Laplas distribution
	 * @return converted random value from uniform distribution to Laplas distribution
	 */
	public static double getRandomLaplas(double location, double variance) {
		double transformedRandomValue = 0;
		double uniformRandom = Math.random() - 0.5;

		transformedRandomValue = location - variance
				* (Math.signum(uniformRandom))
				* Math.log(1 - 2 * Math.abs(uniformRandom));

		return transformedRandomValue;

	}

	/**
	 * @param - location parameter for Gaussian distribution
	 * @param variance - square deviation for Gaussian distribution
	 * @return converted random value from uniform distribution to Gaussian distribution
	 */
	public static double getRandomNormal(double location, double scale) {
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
