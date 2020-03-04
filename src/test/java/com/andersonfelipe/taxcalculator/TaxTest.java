package com.andersonfelipe.taxcalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.andersonfelipe.taxcalculator.product.Product;
import com.andersonfelipe.taxcalculator.tax.BasicSales;
import com.andersonfelipe.taxcalculator.tax.Tax;

public class TaxTest {
	
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
	public void testBasicSaleTaxFood() {
		BasicSales basicSales = new BasicSales();
		assertEquals(Boolean.FALSE,basicSales.isApplicable(food));
	}
	
	@Test
	public void testBasicSaleTaxBook() {
		BasicSales basicSales = new BasicSales();
		assertEquals(Boolean.FALSE,basicSales.isApplicable(book));
	}
	
	@Test
	public void testBasicSaleTaxOther() {
		Tax basicSales = new BasicSales();
		assertEquals(Boolean.TRUE,basicSales.isApplicable(other));
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
