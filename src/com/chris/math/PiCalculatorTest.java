package com.chris.math;

public class PiCalculatorTest {
	
	public static void main(String[] ar) {
		PiCalculator piCalculator = PiCalculatorFactory.getPiCalculator(PiCalculationMethod.GREGORYLEIBNIZSERIES);
		piCalculator.setIterationSteps(1000000000);
        print("Pi Value using "+piCalculator.getCalculationMethod()+"=", piCalculator.calculatePiValue() +"");
        piCalculator = PiCalculatorFactory.getPiCalculator(PiCalculationMethod.NILAKANTHASERIES);
        print("Pi Value using "+piCalculator.getCalculationMethod()+"=", piCalculator.calculatePiValue() +"");
	}
	
    private static void print(String identifier, String value) {
        System.out.println(identifier +""+value);
    }

}
