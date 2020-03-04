package com.andersonfelipe.taxcalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.andersonfelipe.taxcalculator.product.Product;
import com.andersonfelipe.taxcalculator.product.ProductType;

public class ProductTest {
	
	Product book;
	Product food;
	Product other;
	
	@Before
	public void before() {
		book = createBook();
		food = createFood();
		other = createOther();
	}
	
	@Test
	public void createProductBook() {
		Product product = book;
		assertEquals(Boolean.TRUE, product.isProductTypeOf(ProductType.Book));
		assertEquals(Boolean.FALSE, product.isProductTypeOf(ProductType.Food));
		assertEquals(Boolean.FALSE, product.isProductTypeOf(ProductType.Medical));
	}
	
	@Test
	public void createProductFood() {
		Product product = food;
		assertEquals(Boolean.TRUE, product.isProductTypeOf(ProductType.Food));
		assertEquals(Boolean.FALSE, product.isProductTypeOf(ProductType.Book));
		assertEquals(Boolean.FALSE, product.isProductTypeOf(ProductType.Medical));
	}
	
	@Test
	public void createProductOther() {
		Product product = other;
		assertEquals(Boolean.FALSE, product.isProductTypeOf(ProductType.Book));
		assertEquals(Boolean.FALSE, product.isProductTypeOf(ProductType.Medical));
		assertEquals(Boolean.FALSE, product.isProductTypeOf(ProductType.Food));
	}
	
	@Test
	public void createVerifyProductImported() {
		Product product = new Product();
		product.setDescription("1 imported box of chocolates at 10.00");
		assertEquals(Boolean.TRUE, product.isImported());
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
