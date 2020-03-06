package com.andersonfelipe.taxcalculator;

import org.junit.Before;
import org.junit.Test;

import com.andersonfelipe.taxcalculator.exceptions.ItemNonstandardException;
import com.andersonfelipe.taxcalculator.parse.StringParser;
import com.andersonfelipe.taxcalculator.product.Product;

public class ItemParserTest {

	Product bookException;
	Product foodException;
	Product otherException;

	@Before
	public void before() {
		bookException = createBookException();
		foodException = createFoodException();
		otherException = createOtherException();
	}

	@Test(expected = ItemNonstandardException.class)
	public void stringParserItemBookExceptionTest() throws ItemNonstandardException {
		StringParser.cartItemParser(createBookException().getDescription());
	}

	@Test(expected = ItemNonstandardException.class)
	public void stringParserItemFoodExceptionTest() throws ItemNonstandardException {
		StringParser.cartItemParser(createFoodException().getDescription());
	}

	@Test(expected = ItemNonstandardException.class)
	public void stringParserItemOtherExceptionTest() throws ItemNonstandardException {
		StringParser.cartItemParser(createOtherException().getDescription());
	}

	public Product createBookException() {
		Product product = new Product();
		product.setDescription("book at 12.49");
		product.setShelfPrice(12.49f);
		return product;
	}

	public Product createFoodException() {
		Product product = new Product();
		product.setDescription("1 at 0.85");
		product.setShelfPrice(0.85f);
		return product;
	}

	public Product createOtherException() {
		Product product = new Product();
		product.setDescription("1 music CD at");
		product.setShelfPrice(14.99f);
		return product;
	}
}
