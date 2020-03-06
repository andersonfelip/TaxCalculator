package com.andersonfelipe.taxcalculator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.andersonfelipe.taxcalculator.cart.Cart;
import com.andersonfelipe.taxcalculator.cart.CartItem;
import com.andersonfelipe.taxcalculator.cart.CartProcess;
import com.andersonfelipe.taxcalculator.product.Product;
import com.andersonfelipe.taxcalculator.tax.BasicSales;
import com.andersonfelipe.taxcalculator.tax.ImportedSales;
import com.andersonfelipe.taxcalculator.tax.Tax;

public class TaxTest {
	
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
	public void testBasicSaleTaxFood() {
		Tax basicSales = new BasicSales();
		assertEquals(Boolean.FALSE,basicSales.isApplicable(food));
	}
	
	@Test
	public void testBasicSaleTaxBook() {
		Tax basicSales = new BasicSales();
		assertEquals(Boolean.FALSE,basicSales.isApplicable(book));
	}
	
	@Test
	public void testBasicSaleTaxOther() {
		Tax basicSales = new BasicSales();
		assertEquals(Boolean.TRUE,basicSales.isApplicable(other));
	}
	
	@Test
	public void testImportedTaxFood() {
		Tax importedSale = new ImportedSales();
		assertEquals(Boolean.TRUE,importedSale.isApplicable(importedFood));
	}
	
	@Test
	public void testImportedTaxOther() {
		Tax importedSale = new ImportedSales();
		assertEquals(Boolean.TRUE,importedSale.isApplicable(importedOther));
	}
	
	@Test
	public void testNotImportedTaxOther() {
		Tax importedSale = new ImportedSales();
		assertEquals(Boolean.FALSE,importedSale.isApplicable(other));
	}
	
	@Test
	public void calculateBasicSaleTaxFood() {
		Tax basicSales = new BasicSales();
		assertEquals(Float.valueOf(0),basicSales.calculate(food),0);
	}
	
	@Test
	public void calculateBasicSaleTaxOther() {
		Tax basicSales = new BasicSales();
		assertEquals(Float.valueOf(1.5F),basicSales.calculate(other),0);
	}
	
	@Test
	public void verifyRateTaxes() {
		Tax basicSales = new BasicSales();
		assertEquals(Float.valueOf(10F),basicSales.getRate(),0);
		Tax importedSales = new ImportedSales();
		assertEquals(Float.valueOf(5F),importedSales.getRate(),0);
		
	}
	
	@Test
	public void cartProcess() {
		CartProcess.processCart(cart);
		assertEquals(29.83f, cart.getTotalCost(),0);
		assertEquals(1.5f, cart.getTotalTax(),0);
	}
	
	@Test
	public void importedCartPrinter() {
		CartProcess.processCart(importedCart);
		assertEquals(65.15f, importedCart.getTotalCost(),0);
		assertEquals(7.65f, importedCart.getTotalTax(),0);
	}

	@Test
	public void mixedCartPrinter() {
		CartProcess.processCart(mixedCart);
		assertEquals(74.68f, mixedCart.getTotalCost(),0);
		assertEquals(6.70f, mixedCart.getTotalTax(),0);
	}
	
	private Product createBook() {
		Product product = new Product("1 book at 12.49");
		product.setShelfPrice(12.49f);
		return product;
	}
	
	private Product createFood() {
		Product product = new Product("1 chocolate bar at 0.85");
		product.setShelfPrice(0.85f);
		return product;
	}
	
	private Product createOther() {
		Product product = new Product("1 music CD at 14.99");
		product.setShelfPrice(14.99f);
		return product;
	}
	
	private Product createImportedFood() {
		Product product = new Product("1 imported box of chocolates at 10.00");
		product.setShelfPrice(10.00f);
		return product;
	}
	
	private Product createImportedOther() {
		Product product = new Product("1 imported bottle of perfume at 47.50");
		product.setShelfPrice(47.50f);
		return product;
	}
	
	private Cart createCart() {
		return new Cart(createItems1());
	}
	private List<CartItem> createItems1() {
		List<CartItem> items = new ArrayList<CartItem>();
		items.add(createCartItem(book));
		items.add(createCartItem(food));
		items.add(createCartItem(other));
		return items;
	}
	
	private CartItem createCartItem(Product product) {
		return new CartItem(product);
	}
	
	private Cart createCartWithImportedItems() {
		return new Cart(createItems2());
	}

	private Cart createMixedCartItems() {
		return new Cart(createItems3());
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
	
	private Product createImportedBottlePerfume() {
		return new Product("1 imported bottle of perfume at 27.99");
	}

	private Product createBottlePerfume() {
		return new Product("1 bottle of perfume at 18.99");
	}

	private Product createPacketHeadachePills() {
		return new Product("1 packet of headache pills at 9.75");
	}

	private Product createImportedChocolate() {
		return new Product("1 imported box of chocolates at 11.25");
	}

}
