package com.epam.tradingsystem.broker.exchange.quotes.generator;

import java.util.List;


public class GeneratorDemo {

	public static void main(String[] args) {
		Generator generator = new Generator();
		List<Tick> list = generator.generateTicks(1, 600, 0, 1 * Math.pow(10, -5));
		for (Tick tick : list) {
			System.out.println(tick.getPrice());
		}

	}

}
