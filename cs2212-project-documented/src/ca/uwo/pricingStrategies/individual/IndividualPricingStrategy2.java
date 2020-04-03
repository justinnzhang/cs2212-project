package ca.uwo.pricingStrategies.individual;

public class IndividualPricingStrategy2 implements IndividualPricingStrategy {

	@Override
	public double calculate(int quantity, double price) {
		System.out.println("IndividualPricingStrategy2 selected...");

		// 10% increase in price
		return (price * 1.10 * quantity); 
	}

}
