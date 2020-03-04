package com.andersonfelipe.taxcalculator.tax;

import com.andersonfelipe.taxcalculator.cart.Cart;
import com.andersonfelipe.taxcalculator.cart.CartItem;

public class TaxCalculator {
	
	private Tax[] taxes = new Tax[] {new BasicSales(),new ImportedSales()};
	
	public void CalculateCartTax(Cart cart) {
		for (CartItem item : cart.getCartItems()) {
			for (Tax tax : taxes) {
				item.setTax(item.getTax() + tax.calculate(item.getProduct()));
			}
		}
	}
}
