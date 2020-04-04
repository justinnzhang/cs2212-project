package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;
import ca.uwo.model.ItemRepository;

public class LowQuantityProxy extends Proxy{
	private Proxy next;
	
	private static LowQuantityProxy instance = null;

	
	private LowQuantityProxy() {
		next = HighQuantityProxy.getInstance();
	}
	

	@Override
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		if (orderDetails.values().size() > 10) {
			next.placeOrder(orderDetails, buyer);
		}
		else {
			
			// Uses placeOrder method from Facade class
			Facade facade = Facade.getInstance();
			facade.placeOrder(orderDetails, buyer);	
		}	
	}

	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
	}

	/**
	 * there should be only one instance of LowQuantityProxy class.
	 * @return the instance of LowQuantityProxy.
	 */
	public static LowQuantityProxy getInstance() {
		if (instance == null)
			instance = new LowQuantityProxy();
		
		return instance;
	}
	
}
