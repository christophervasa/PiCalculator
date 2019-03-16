package com.chris.math;

/**
 * This is a an implementation of Pi Calculator using Nilakantha series
 */
public class NilakanthaPiCalculator implements PiCalculator {

	private int steps;
	
	/**
	 * Default constructor. Uses the limit of 500.
	 */
	public NilakanthaPiCalculator(){
		this.steps = MIN_STEPS;
	}
	
    /**
     * Constructor for the NilakanthaPiCalculator. 
     * @param limit - The number of iterations to perform while calculating the value.
     */
	public NilakanthaPiCalculator(int limit){
		if(limit<MIN_STEPS) {
			throw new RuntimeException("Cannot calculate reasonably accurate Pi value in less than "+MIN_STEPS+" steps");
        }
        if(limit>MAX_STEPS){
        	throw new RuntimeException("The number of steps provided is > "+MAX_STEPS);
        }
		this.steps = limit;
	}
	
    /**
     * Calculates the PiValue using the Nilakantha series.
     * @return - The calculated Pi value.
     */
	@Override
	public double calculatePiValue() {
        double value = 0;
        double numerator = 4;
        int start;
        for (int step =1;step<=steps; step++) {
        	start =step*2;
        	if(step % 2 == 0) {
                value = value - ( numerator / (start*(start+1)*(start+2) ));
            } else {
                value = value + ( numerator / (start*(start+1)*(start+2) ));
            }
        }
		return 3 + value;
	}

	@Override
	public PiCalculationMethod getCalculationMethod() {
		return PiCalculationMethod.NILAKANTHASERIES;
	}

	@Override
	public void setIterationSteps(int steps) {
		this.steps = steps;
	}

}
