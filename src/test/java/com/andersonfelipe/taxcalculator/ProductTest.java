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
		assertEquals(Boolean.TRUE, product.isProductTypeOf(ProductType.BOOK));
		assertEquals(Boolean.FALSE, product.isProductTypeOf(ProductType.FOOD));
		assertEquals(Boolean.FALSE, product.isProductTypeOf(ProductType.MEDICAL));
	}
	
	@Test
	public void createProductFood() {
		Product product = food;
		assertEquals(Boolean.TRUE, product.isProductTypeOf(ProductType.FOOD));
		assertEquals(Boolean.FALSE, product.isProductTypeOf(ProductType.BOOK));
		assertEquals(Boolean.FALSE, product.isProductTypeOf(ProductType.MEDICAL));
	}
	
	@Test
	public void createProductOther() {
		Product product = other;
		assertEquals(Boolean.FALSE, product.isProductTypeOf(ProductType.BOOK));
		assertEquals(Boolean.FALSE, product.isProductTypeOf(ProductType.MEDICAL));
		assertEquals(Boolean.FALSE, product.isProductTypeOf(ProductType.FOOD));
	}
	
	@Test
	public void createVerifyProductImported() {
		Product product = new Product("1 imported box of chocolates at 10.00");
		assertEquals(Boolean.TRUE, product.isImported());
	}
	
	private Product createBook() {
		return new Product("1 book at 12.49");
	}
	
	private Product createFood() {
		return new Product("1 chocolate bar at 0.85");
	}
	
	private Product createOther() {
		return new Product("1 music CD at 14.99");
	}
}
