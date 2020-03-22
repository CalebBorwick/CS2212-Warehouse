package ca.uwo.model.item.states;

import ca.uwo.model.Item;
import ca.uwo.utils.ItemResult;

public class OutOfStockState implements ItemState{

	@Override
	public ItemResult deplete(Item item, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemResult replenish(Item item, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

}
