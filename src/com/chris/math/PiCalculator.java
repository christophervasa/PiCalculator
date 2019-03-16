package com.chris.math;

/*
 * Definition for Pi calculators.
 */
public interface PiCalculator {
	
	public static final int MIN_STEPS = 500;
	
	public static final int MAX_STEPS = 1000000000;

	public double calculatePiValue();

	public PiCalculationMethod getCalculationMethod();
	
	public void setIterationSteps(int steps);
}
