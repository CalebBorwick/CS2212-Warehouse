package ca.uwo.model.item.states;


public class ItemStateFactory {
	public static ItemState create(int quant) {
		switch(quant) {
		case (0):
			return new OutOfStockState();
		case (1):
			return new LowStockState();
		case (2):
			return new LowStockState();
		case (3):
			return new LowStockState();
		case (4):
			return new LowStockState();
		case (5):
			return new LowStockState();
		case (6):
			return new LowStockState();
		case (7):
			return new LowStockState();
		case (8):
			return new LowStockState();
		case (9):
			return new LowStockState();
		default:
			return new InStockState();
		}
		
	}
}
