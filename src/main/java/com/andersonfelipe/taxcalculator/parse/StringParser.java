package com.andersonfelipe.taxcalculator.parse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.andersonfelipe.taxcalculator.cart.Cart;
import com.andersonfelipe.taxcalculator.cart.CartItem;
import com.andersonfelipe.taxcalculator.exceptions.ItemNonstandardException;
import com.andersonfelipe.taxcalculator.product.Product;

public class StringParser {
	
	private StringParser() {
	    throw new IllegalStateException("Static class");
	}
	
	private static String itemRegex = "(\\d+) ([\\w\\s]* )at (\\d+[\\.\\,]\\d{2})";
	
	public static Cart cartParser(Cart cart)  {
		if(!cart.getCartItems().isEmpty()) {
			List<String> productDescription = new ArrayList<>(); 
			for (CartItem item : cart.getCartItems()) {
				if(item.getProduct() != null) {
					productDescription.add(item.getProduct().getDescription());	
				}
			}
			
			cart.setCartItems(new ArrayList<CartItem>());
			for (String item : productDescription) {
				try {
					cart.getCartItems().add(cartItemParser(item));
				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println();
				}
			}
		}
			
		return cart;
	}
	
	public static CartItem cartItemParser(String description) throws ItemNonstandardException {
		
		Pattern pattern = Pattern.compile(itemRegex);
        Matcher matcher = pattern.matcher(description);
        
        if(matcher.find()) {
        	Integer quantity = Integer.parseInt(matcher.group(1));
        	String productName = matcher.group(2).trim();
        	Float price = Float.parseFloat(matcher.group(3));
        	
        	Product product = new Product(productName);
        	product.setShelfPrice(price);
        	
        	CartItem cartItem = new CartItem(product);
        	cartItem.setQuantity(quantity);
        	
        	return cartItem;
        }
        throw new ItemNonstandardException("The item reported could not be converted!");
		
	}
}
