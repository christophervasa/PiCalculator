package com.chris.math;

/**
 * This is a an implementation of Pi Calculator using Gregory-Leibniz series
 */
public class GregoryLeibnizPiCalculator implements PiCalculator {

    private int steps;
    
    /**
     * Default constructor. Uses the limit of 500.
     */
    public GregoryLeibnizPiCalculator() {
    	this.steps = MIN_STEPS;
    }

    /**
     * Constructor for the GregoryLeibnizPiCalculator. 
     * @param limit - The number of iterations to perform while calculating the value.
     */
    public GregoryLeibnizPiCalculator(int limit) {
	    if(limit<MIN_STEPS) {
	        throw new RuntimeException("Cannot calculate reasonably accurate Pi value in less than "+MIN_STEPS+" steps");
	    }
	    if(limit>MAX_STEPS){
	    	throw new RuntimeException("The number of steps provided is > "+MAX_STEPS);
	    }
        this.steps = limit;
    }

    /**
     * Calculates the PiValue using the Gregory-Leibniz series.
     * @return - The Pi value.
     */
    @Override
    public double calculatePiValue() {
        double variable = 0;
        double value = 0;
        for (int step =1;step<=steps; step++) {
            variable = step*2+1;
            if(step % 2 == 0) {
                value = value + ( (double)1 / variable);
            } else {
                value = value - ( (double)1 / variable);
            }
        }
        value = (1 + value)* 4;
        return value;
    }

	@Override
	public PiCalculationMethod getCalculationMethod() {
		return PiCalculationMethod.GREGORYLEIBNIZSERIES;
	}
	

	@Override
	public void setIterationSteps(int steps) {
		this.steps = steps;
	}
	
	public static void main(String[] ar) {
		GregoryLeibnizPiCalculator calculator = new GregoryLeibnizPiCalculator(10000);
        double piValue = calculator.calculatePiValue();
    }

}

