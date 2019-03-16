package com.chris.math;

public class PiCalculatorFactory {
	
	public static PiCalculator getPiCalculator(PiCalculationMethod calculationMethod) {
		switch (calculationMethod) {
			case GREGORYLEIBNIZSERIES:
				return new GregoryLeibnizPiCalculator();
			case NILAKANTHASERIES:
				return new NilakanthaPiCalculator();
			default:
				throw new RuntimeException("Unknown calculation method");
		}
	}
}
