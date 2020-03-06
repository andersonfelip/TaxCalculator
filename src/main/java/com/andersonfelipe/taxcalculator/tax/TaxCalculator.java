package com.andersonfelipe.taxcalculator.tax;

import com.andersonfelipe.taxcalculator.cart.Cart;
import com.andersonfelipe.taxcalculator.cart.CartItem;

public class TaxCalculator {
	
	private TaxCalculator() {
	    throw new IllegalStateException("Static class");
	}
	
	private static Tax[] taxes = new Tax[] {(Tax) new BasicSales(),(Tax) new ImportedSales()};
	
	public static void calculateCartTax(Cart cart) {
		for (CartItem item : cart.getCartItems()) {
			for (Tax tax : taxes) {
				item.setTax(item.getTax() + tax.calculate(item.getProduct()));
			}
		}
	}
}
