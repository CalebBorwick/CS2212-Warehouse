package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.client.Client;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

public class SupplierProxy extends Proxy {
	/**
	 * constructor for WelcomeProxy class.
	 */
	public SupplierProxy() {}
	
	/* (non-Javadoc)
	 * @see ca.uwo.frontend.interfaces.FacadeCommands#placeOrder(java.util.Map, ca.uwo.client.Buyer)
	 */
	@Override
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		if (successor != null) {
			successor.placeOrder(orderDetails, buyer);
		}
	}

	/* (non-Javadoc)
	 * @see ca.uwo.frontend.interfaces.FacadeCommands#restock(java.util.Map, ca.uwo.client.Supplier)
	 */
	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
		Facade facade =Facade.getInstance();
		facade.restock(restockDetails, supplier);
	}

	
	
}