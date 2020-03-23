package ca.uwo.viewer.restock.strategies;

public class RestockStrategyFactory {

	public static RestockStrategy create(String type) {
		switch(type) {
		case "weird":
			return new WeirdRestockStrategy();
		default:
			return new Units50RestockStrategy();
		}
	}

}
