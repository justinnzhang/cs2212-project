package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.ResponseCode;

/**
 * 
 * @author kevincheung, justinzhang, connieyao
 * Class for OutOfStockState, with deplete and replenish methods
 * quantity == 0
 */

public class OutOfStockState implements ItemState {

	@Override
	public ItemResult deplete(Item item, int quantity) {

		// Don't need to update state, already out of stock
		
		item.notifyViewers();
		
		return new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);

	}

	@Override
	public ItemResult replenish(Item item, int quantity) {
		// Replenish the item with quantity and return the execution result of
		// replenish action.
		int availableQuantity = item.getAvailableQuantity();
		availableQuantity += quantity;
		item.setAvailableQuantity(availableQuantity);
		ItemResult itemResult = new ItemResult("RESTOCKED", ResponseCode.Completed);
		
		// Change state if needed
		item.setState(availableQuantity);
		
		return itemResult;
	}

}
