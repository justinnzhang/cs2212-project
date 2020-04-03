package ca.uwo.pricingStrategies.individual;

public class IndividualPricingStrategyFactory {

	
	public static IndividualPricingStrategy create(String type) {
		switch(type) {
		case "test":
			return new IndividualPricingStrategy2();
		default:
			return new IndividualPricingStrategy1();
		}
		
//		if (type == "test")
//			return new IndividualPricingStrategy2();
//		else
//			return new IndividualPricingStrategy1();
//		
		
	}
}
