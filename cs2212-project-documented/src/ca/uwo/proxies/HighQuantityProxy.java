package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;
import ca.uwo.model.ItemRepository;

public class HighQuantityProxy extends Proxy {
	
	private static HighQuantityProxy instance = null;
	
	/**
	 * constructor for HighQuantityProxy class.
	 */
	private HighQuantityProxy() {}	
	
	@Override
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		Facade facade = Facade.getInstance();
		facade.placeOrder(orderDetails, buyer);		
	}

	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
		
	}
	
	/**
	 * there should be only one instance of HighQuantityProxy class.
	 * @return the instance of HighQuantityProxy.
	 */
	public static HighQuantityProxy getInstance() {
		if (instance == null)
			instance = new HighQuantityProxy();
		
		return instance;
	}

}
