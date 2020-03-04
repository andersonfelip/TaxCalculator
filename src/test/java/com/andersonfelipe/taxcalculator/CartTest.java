package com.andersonfelipe.taxcalculator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.andersonfelipe.taxcalculator.cart.Cart;
import com.andersonfelipe.taxcalculator.cart.CartItem;
import com.andersonfelipe.taxcalculator.cart.CartProcess;
import com.andersonfelipe.taxcalculator.product.Product;

public class CartTest {
	
	Cart cart;
	Product book;
	Product food;
	Product other;
	
	@Before
	public void before() {
		book = createBook();
		food = createFood();
		other = createOther();
		cart = createCart();
	}
	
	@Test
	public void cartPrinter() {
		CartProcess.processCart(cart);
	}
	
	private Cart createCart() {
		Cart cart = new Cart();
		cart.setCartItems(createItems());
		return cart;
	}
	private List<CartItem> createItems(){
		List<CartItem> items = new ArrayList<CartItem>();
		items.add(createCartItem(book));
		items.add(createCartItem(food));
		items.add(createCartItem(other));
		return items;
	}
	
	private CartItem createCartItem(Product product) {
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		return cartItem;
	}
	
	private Product createBook() {
		Product product = new Product();
		product.setDescription("1 book at 12.49");
		return product;
	}
	
	private Product createFood() {
		Product product = new Product();
		product.setDescription("1 chocolate bar at 0.85");
		return product;
	}
	
	private Product createOther() {
		Product product = new Product();
		product.setDescription("1 music CD at 14.99");
		return product;
	}
	
}
