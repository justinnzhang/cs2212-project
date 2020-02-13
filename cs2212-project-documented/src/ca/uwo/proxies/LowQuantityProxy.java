package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

public class LowQuantityProxy extends Proxy{
	private Proxy next;
	
	public LowQuantityProxy() {
		next = new HighQuantityProxy();
	}

	@Override
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		if (orderDetails.values().size() > 10) {
			next.placeOrder(orderDetails, buyer);
		}
		else {
			Facade facade = new Facade();
			facade.placeOrder(orderDetails, buyer);	
		}	
	}

	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
	}

}
