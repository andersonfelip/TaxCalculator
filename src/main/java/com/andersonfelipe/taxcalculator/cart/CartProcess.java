package com.andersonfelipe.taxcalculator.cart;

import com.andersonfelipe.taxcalculator.parse.StringParser;
import com.andersonfelipe.taxcalculator.tax.TaxCalculator;

public class CartProcess {
	
	private CartProcess() {
	    throw new IllegalStateException("Static class");
	}

	public static void processCart(Cart cart)  {
		StringParser.cartParser(cart);
		TaxCalculator.calculateCartTax(cart);
	}
}
