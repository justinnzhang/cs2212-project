package ca.uwo.proxies;

import java.util.Map;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

public class SupplierProxy extends Proxy{
	
	private static SupplierProxy instance = null;
	
	private Proxy next;
	
	public SupplierProxy() {
		next = LowQuantityProxy.getInstance();
	}

	@Override
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {
		next.placeOrder(orderDetails, buyer);
	}

	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
		Facade facade = Facade.getInstance();
		
		//uses the restock method from the facade class
		facade.restock(restockDetails, supplier);
		
	}
	
	/**
	 * there should be only one instance of ItemRepository class.
	 * @return the instance of ItemRepository.
	 */
	public static SupplierProxy getInstance() {
		if (instance == null)
			instance = new SupplierProxy();
		
		return instance;
	}
	
}
