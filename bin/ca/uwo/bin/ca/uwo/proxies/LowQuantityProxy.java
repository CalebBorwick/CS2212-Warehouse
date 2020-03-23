
package ca.uwo.proxies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import ca.uwo.client.Buyer;
import ca.uwo.client.Client;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

public class LowQuantityProxy extends Proxy {
	
	private static LowQuantityProxy instance = null;

	public static LowQuantityProxy getInstance() {
		if (instance == null)
			instance = new LowQuantityProxy();
		
		return instance;
	}
	
	/**
	 * constructor for WelcomeProxy class.
	 */
	public LowQuantityProxy() {
	}

	/* (non-Javadoc)
	 * @see ca.uwo.frontend.interfaces.FacadeCommands#placeOrder(java.util.Map, ca.uwo.client.Buyer)
	 */
	@Override
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		
		int quat = getQuantity(orderDetails);
		if (quat<=10) {
			if (authenticate(buyer)==true) {
				Facade facade = Facade.getInstance();
				facade.placeOrder(orderDetails, buyer);
			}
		
			else {
				System.out.println("authentication denied");
			}
		}
		else {
			if (successor != null) {
				successor.placeOrder(orderDetails, buyer);
			}
		}
		
	}

	/* (non-Javadoc)
	 * @see ca.uwo.frontend.interfaces.FacadeCommands#restock(java.util.Map, ca.uwo.client.Supplier)
	 */
	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
		if (successor != null) {
			successor.restock(restockDetails, supplier);
		}
	}
	
	
	private boolean authenticate(Buyer buyer) {
		Map<Integer, Buyer> buyerList = new HashMap<>();
		//Read all the buyers from the file and save them. Each line consists of the ID, name and password of the buyer.
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("buyer_file")));
			String line;
			while ((line = br.readLine()) != null) {
				String[] lineTokens = line.split("\t");
				buyerList.put(Integer.parseInt(lineTokens[0]), new Buyer(lineTokens[1], lineTokens[2]));
			}
			br.close();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
        for (int i=1; i <=buyerList.size(); i++) {
			if(buyerList.get(i).getUserName().equals(buyer.getUserName()) && buyerList.get(i).getPassword().equals(buyer.getPassword())) {
				return true;
			}
		}
		return false;
	}

	private int getQuantity(Map<String, Integer> orderDetails) {
		int quantity=0;
		 Object[] ord = orderDetails.values().toArray();
		 for(int i=0; i <orderDetails.size(); i++)
		   quantity += Integer.valueOf(ord[i].toString());
	
		return quantity;
	}
	
	
}

