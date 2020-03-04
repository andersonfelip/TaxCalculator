package com.andersonfelipe.taxcalculator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.andersonfelipe.taxcalculator.cart.Cart;
import com.andersonfelipe.taxcalculator.cart.CartItem;
import com.andersonfelipe.taxcalculator.cart.CartPrinter;
import com.andersonfelipe.taxcalculator.cart.CartProcess;
import com.andersonfelipe.taxcalculator.product.Product;

public class CartTest {

	Product book;
	Product food;
	Product other;
	Product importedFood;
	Product importedOther;

	Product importedBottlePerfume;
	Product bottlePerfume;
	Product packetHeadachePills;
	Product importedChocolate;

	Cart cart;
	Cart importedCart;
	Cart mixedCart;

	@Before
	public void before() {
		book = createBook();
		food = createFood();
		other = createOther();

		importedFood = createImportedFood();
		importedOther = createImportedOther();

		importedBottlePerfume = createImportedBottlePerfume();
		bottlePerfume = createBottlePerfume();
		packetHeadachePills = createPacketHeadachePills();
		importedChocolate = createImportedChocolate();

		cart = createCart();
		importedCart = createCartWithImportedItems();
		mixedCart = createMixedCartItems();
	}

	@Test
	public void cartPrinter() {
		CartProcess.processCart(cart);
		CartPrinter.print(cart);
	}

	@Test
	public void importedCartPrinter() {
		CartProcess.processCart(importedCart);
		CartPrinter.print(importedCart);
	}

	@Test
	public void mixedCartPrinter() {
		CartProcess.processCart(mixedCart);
		CartPrinter.print(mixedCart);
	}

	private Cart createCart() {
		Cart cart = new Cart();
		cart.setCartItems(createItems1());
		return cart;
	}

	private Cart createCartWithImportedItems() {
		Cart cart = new Cart();
		cart.setCartItems(createItems2());
		return cart;
	}

	private Cart createMixedCartItems() {
		Cart cart = new Cart();
		cart.setCartItems(createItems3());
		return cart;
	}

	private List<CartItem> createItems1() {
		List<CartItem> items = new ArrayList<CartItem>();
		items.add(createCartItem(book));
		items.add(createCartItem(food));
		items.add(createCartItem(other));
		return items;
	}

	private List<CartItem> createItems2() {
		List<CartItem> items = new ArrayList<CartItem>();
		items.add(createCartItem(importedFood));
		items.add(createCartItem(importedOther));
		return items;
	}

	private List<CartItem> createItems3() {
		List<CartItem> items = new ArrayList<CartItem>();
		items.add(createCartItem(importedBottlePerfume));
		items.add(createCartItem(bottlePerfume));
		items.add(createCartItem(packetHeadachePills));
		items.add(createCartItem(importedChocolate));

		return items;
	}

	private CartItem createCartItem(Product product) {
		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		return cartItem;
	}

	public Product createBook() {
		Product product = new Product();
		product.setDescription("1 book at 12.49");
		product.setShelfPrice(12.49f);
		return product;
	}

	public Product createFood() {
		Product product = new Product();
		product.setDescription("1 chocolate bar at 0.85");
		product.setShelfPrice(0.85f);
		return product;
	}

	public Product createOther() {
		Product product = new Product();
		product.setDescription("1 music CD at 14.99");
		product.setShelfPrice(14.99f);
		return product;
	}

	public Product createImportedFood() {
		Product product = new Product();
		product.setDescription("1 imported box of chocolates at 10.00");
		product.setShelfPrice(10.00f);
		return product;
	}

	public Product createImportedOther() {
		Product product = new Product();
		product.setDescription("1 imported bottle of perfume at 47.50");
		product.setShelfPrice(47.50f);
		return product;
	}

	private Product createImportedBottlePerfume() {
		Product product = new Product();
		product.setDescription("1 imported bottle of perfume at 27.99");
		return product;
	}

	private Product createBottlePerfume() {
		Product product = new Product();
		product.setDescription("1 bottle of perfume at 18.99");
		return product;
	}

	private Product createPacketHeadachePills() {
		Product product = new Product();
		product.setDescription("1 packet of headache pills at 9.75");
		return product;
	}

	private Product createImportedChocolate() {
		Product product = new Product();
		product.setDescription("1 imported box of chocolates at 11.25");
		return product;
	}

}
