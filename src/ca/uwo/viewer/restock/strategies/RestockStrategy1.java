package ca.uwo.viewer.restock.strategies;

import java.util.HashMap;
import java.util.Map;

import ca.uwo.viewer.StockManager;

public class RestockStrategy1 implements RestockStrategy {

	@Override
	public int calculateQuantity(String itemName, int quantity, double price) {

		return 50;
	}

}
