package ca.uwo.pricingStrategies.individual;

public class TestIndividualPricingStrategy implements IndividualPricingStrategy {

	@Override
	public double calculate(int quantity, double price) {
		System.out.println("Test individual strategy used.");
		return (quantity*price)*0.9;
	}

}
