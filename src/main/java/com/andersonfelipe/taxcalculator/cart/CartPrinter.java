package com.andersonfelipe.taxcalculator.cart;

public class CartPrinter {
	
	private CartPrinter() {
		throw new IllegalStateException("Static class");
	}

	public static void print(Cart cart) {
		for (CartItem item : cart.getCartItems()) {
			System.out.println(item);
		}
		
		System.out.println(String.format("Taxes: %.2f", cart.getTotalTax()));
		System.out.println(String.format("Total: %.2f", cart.getTotalCost()));
		System.out.println();
	}
}
