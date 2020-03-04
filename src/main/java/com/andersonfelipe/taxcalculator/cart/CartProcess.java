package com.andersonfelipe.taxcalculator.cart;

import com.andersonfelipe.taxcalculator.parse.StringParser;
import com.andersonfelipe.taxcalculator.tax.TaxCalculator;

public class CartProcess {

	public static void processCart(Cart cart) {
		String[] productDescriptions = new String[cart.getCartItems().size()];
		
		for (int i = 0; i < productDescriptions.length; i++) {
			productDescriptions[i] = cart.getCartItems().get(i).getProduct().getDescription();
		}
		
		Cart parsedCart = StringParser.cartParser(productDescriptions);
		TaxCalculator taxCalc = new TaxCalculator();
		taxCalc.CalculateCartTax(parsedCart);
		
		CartPrinter.print(parsedCart);
	}
}
