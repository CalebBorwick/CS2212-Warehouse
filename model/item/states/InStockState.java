package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.model.ItemRepository;
import ca.uwo.utils.ItemResult;
import ca.uwo.utils.OrderItem;
import ca.uwo.utils.ResponseCode;

public class InStockState implements ItemState{

	@Override
	public ItemResult deplete(Item item, int quantity) {
		// Deplete the item with quantity and return the execution result of
		// deplete action.
		ItemResult itemResult;
		int availableQuantity = item.getAvailableQuantity();
		if (availableQuantity < quantity) {
			itemResult = new ItemResult("OUT OF STOCK", ResponseCode.Not_Completed);
		} else {
			availableQuantity -= quantity;
			itemResult = new ItemResult("AVAILABLE", ResponseCode.Completed);
		}

		item.setAvailableQuantity(availableQuantity);
		return itemResult;
	}
	

	@Override
	public ItemResult replenish(Item item, int quantity) {
		int availableQuantity = item.getAvailableQuantity();
		availableQuantity += quantity;
		item.setAvailableQuantity(availableQuantity);
		ItemResult itemResult = new ItemResult("RESTOCKED", ResponseCode.Completed);
		return itemResult;
	}

}