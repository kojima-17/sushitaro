package model;

public class CartItem {
	private Sushi sushi;
	private int quantity;
	
	public CartItem(Sushi sushi) {
		this.sushi = sushi;
		quantity = 1;
	}
	
	public void incrementQuantity() {
		quantity++;
	}
	
	public int getTotalPrice() {
		return sushi.getPrice() * quantity;
	}
	
	public Sushi getSushi() {
		return sushi;
	}

	public void setSushi(Sushi sushi) {
		this.sushi = sushi;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
