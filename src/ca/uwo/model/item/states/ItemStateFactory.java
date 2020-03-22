package ca.uwo.model.item.states;


public class ItemStateFactory {
	public static ItemState create(String type) {
		switch(type) {
		case "OutOfStock":
			return new OutOfStockState();
		case "LowStock":
			return new LowStockState();
		default:
			return new InStockState();
		}
		
	}
}
