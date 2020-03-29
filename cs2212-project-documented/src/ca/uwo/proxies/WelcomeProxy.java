package ca.uwo.proxies;

import java.util.Map;
import java.util.Scanner;

import ca.uwo.client.Buyer;
import ca.uwo.client.Supplier;
import ca.uwo.frontend.Facade;

/**
 * @author kkontog, ktsiouni, mgrigori
 * This is one concrete implementation of {@link ca.uwo.proxies.Proxy} base class, it is the first proxy
 * the {@link ca.uwo.client.Client} will encounter. If the request of client is not issued by this class, 
 * it is forwarded to the {@link ca.uwo.proxies.SupplierProxy}, then {@link ca.uwo.proxies.LowQuantityProxy}, 
 * lastly {@link ca.uwo.proxies.HighQuantityProxy}. The link between those proxies implements Chain of Responsibility 
 * design pattern.
 */
public class WelcomeProxy extends Proxy {
	
	
	private Proxy next;
	/**
	 * constructor for WelcomeProxy class.
	 */
	public WelcomeProxy() {
		this.next = new SupplierProxy();
	}

	/* (non-Javadoc)
	 * @see ca.uwo.frontend.interfaces.FacadeCommands#placeOrder(java.util.Map, ca.uwo.client.Buyer)
	 */
	@Override
	public void placeOrder(Map<String, Integer> orderDetails, Buyer buyer) {

//		Facade facade = new Facade();
//		facade.placeOrder(orderDetails, buyer);
		
		if (authenticate(buyer) == true) {
			
			// Pass onto the next part of the chain, which is the SupplierProxy()
			// NOTE: the order is not to be placed in this proxy
			next.placeOrder(orderDetails, buyer);
		}
		else {
			System.out.println("Authentication error! Try using just your PIN, or call an agent on the phone.");
		}
		
	}

	/* (non-Javadoc)
	 * @see ca.uwo.frontend.interfaces.FacadeCommands#restock(java.util.Map, ca.uwo.client.Supplier)
	 */
	@Override
	public void restock(Map<String, Integer> restockDetails, Supplier supplier) {
//		Facade facade = new Facade();
//		facade.restock(restockDetails, supplier);
		
		// Pass onto the next part of the chain
		next.restock(restockDetails, supplier);
		
	}
	
	private boolean authenticate(Buyer buyer) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter password for " + buyer.getUserName() + ":");
		
		String enteredPassword = input.nextLine();
		
		if (enteredPassword.equals(buyer.getPassword())) 
			return true;
		else
			return false;
	}

}
