package ca.uwo.viewer.restock.strategies;

public class RestockStrategy2 implements RestockStrategy {

	@Override
	public int calculateQuantity(String itemName, int quantity, double price) {
		if (itemName.equals("apple"))
			return 100;
		else
			return 25;
	}
	

}
