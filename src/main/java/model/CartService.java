package model;

import java.util.List;
import java.util.Optional;

import dao.SushiDAO;

public class CartService {
	private Cart cart;
	private SushiDAO dao;
	
	public CartService(Cart cart) {
		this.cart = cart;
		this.dao = new SushiDAO(new Menu());
	}
	
	public void addCart(String name) {
		Optional<CartItem> optionalCartItem =  getSameNameCartItem(name);
		optionalCartItem.ifPresentOrElse(cartItem -> {
			cartItem.incrementQuantity();
		}
		, () -> {
			Sushi sushi = getSushiByName(name).get();
			cart.addCartItem(new CartItem(sushi));
		}
		);
	}
	
	public void updateQuantity(String name, int quantity) {
		Optional<CartItem> optionalCartItem =  getSameNameCartItem(name);
		optionalCartItem.ifPresent(cartItem -> {
			cartItem.setQuantity(quantity);
		});
	}
	
	public void removeCartItem(String name) {
		Optional<CartItem> optionalCartItem =  getSameNameCartItem(name);
		optionalCartItem.ifPresent(cartItem -> {
			cart.removeCartList(cartItem);
		});
	}
	
	private Optional<CartItem> getSameNameCartItem(String name){
		List<CartItem> list = cart.getCartItemList();
		for(CartItem cartItem : list) {
			if(cartItem.getSushi().getName().equals(name)) {
				return Optional.of(cartItem);
			}
		}
		return Optional.empty();

	}
	
	private Optional<Sushi> getSushiByName(String name) {
		return dao.findByName(name);
	}
}
