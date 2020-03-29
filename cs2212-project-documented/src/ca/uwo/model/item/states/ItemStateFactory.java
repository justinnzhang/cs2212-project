package ca.uwo.model.item.states;


/**
 * 
 * @author kevincheung, justinzhang, connieyao
 * Factory for ItemState, creates objects of different states depending on quantity
 *
 */
public class ItemStateFactory {
		
	public ItemStateFactory() {
		
	}
	
	public static ItemState Create(int quantity) {
		if (quantity >= 10)
			return new InStockState();
		else if (quantity > 0 && quantity < 10)
			return new LowStockState();
		else
			// Stock is zero
			return new OutOfStockState();

	}
}
