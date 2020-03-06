package com.andersonfelipe.taxcalculator.cart;

import java.util.List;

public class Cart {
	
	public Cart(List<CartItem> cartItems) {
		super();
		this.cartItems = cartItems;
	}
	
	private List<CartItem> cartItems;
	private float totalTax;
	private float totalCost;
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public float getTotalTax() {
		for (CartItem cartItem : cartItems) {
			totalTax += cartItem.getTax();
		}
		return totalTax;
	}
	public float getTotalCost() {
		for (CartItem cartItem : cartItems) {
			totalCost += cartItem.getCost();
		}
		return totalCost;
	}
}
