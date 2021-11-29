package EvalJC;

import java.util.HashSet;
import java.util.Set;

public class Cart {
	
	
	private Set<CartItem> cartItems = new HashSet<CartItem>();

	public Cart(Set<CartItem> cartItems) {
		super();
		this.cartItems = cartItems;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	

}
