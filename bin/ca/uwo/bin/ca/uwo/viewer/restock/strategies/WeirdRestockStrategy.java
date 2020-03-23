package ca.uwo.viewer.restock.strategies;

public class WeirdRestockStrategy implements RestockStrategy {

	@Override
	public int calculateQuantity(String itemName, int quantity, double price) {
		if (itemName.equals("apple")) {
			return 500;
		}
		else {
			return (int) (2*((quantity+1)*price));
		}
	}

}
