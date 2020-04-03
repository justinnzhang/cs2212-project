package ca.uwo.pricingStrategies.individual;

public class IndividualPricingStrategy1 implements IndividualPricingStrategy {

	@Override
	public double calculate(int quantity, double price) {
		System.out.println("IndividualPricingStrategy1 selected...");
		
		
		// Calculate the product of price and quantity, as given
		return (price * quantity);
		
	}

}
