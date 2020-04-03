package ca.uwo.viewer.restock.strategies;

public class RestockStrategyFactory {
	
	public static RestockStrategy create(String type) {
		
//		if (type == "test")
//			return new RestockStrategy2();
//		else
//			return new RestockStrategy1();
//
		
		switch(type) {
		case "test":
			return new RestockStrategy2();
		default:
			return new RestockStrategy1();
		}
	}

}
