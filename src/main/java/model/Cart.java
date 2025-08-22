package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cart {
	private List<CartItem> cartItemList;

	public Cart() {
		cartItemList = new ArrayList<CartItem>();
	}

	public int getTotalPrice() {
		return cartItemList.stream().collect(Collectors.summingInt(CartItem::getTotalPrice));
	}

	public int getTotalQuantity() {
		return cartItemList.stream().collect(Collectors.summingInt(CartItem::getQuantity));
	}

	public void addCartItem(CartItem cartItem) {
		cartItemList.add(cartItem);
	}

	public void removeCartList(CartItem cartItem) {
		cartItemList.remove(cartItem);
	}

	public void removeAll() {
		cartItemList.clear();
	}

	public List<CartItem> getCartItemList() {
		return cartItemList;
	}

	public void setCartItemList(List<CartItem> cartItemList) {
		this.cartItemList = cartItemList;
	}

}
