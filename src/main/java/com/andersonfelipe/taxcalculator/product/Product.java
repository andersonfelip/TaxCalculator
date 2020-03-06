package com.andersonfelipe.taxcalculator.product;

import java.util.EnumMap;

public class Product {
	
	private String description;
	
	private float shelfPrice;
	
	public Product(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getShelfPrice() {
		return shelfPrice;
	}

	public void setShelfPrice(float shelfPrice) {
		this.shelfPrice = shelfPrice;
	}

	private static EnumMap<ProductType,String[]> dictionaryTypes = new EnumMap<>(ProductType.class);
	
	static {
		dictionaryTypes.put(ProductType.FOOD, new String[] {"chocolate","chocolates"});
		dictionaryTypes.put(ProductType.MEDICAL, new String[] {"pills"});
		dictionaryTypes.put(ProductType.BOOK, new String[] {"book"});
	}
	
	public boolean isProductTypeOf(ProductType productType) {
		for (String word : dictionaryTypes.get(productType)) {
			if(description.contains(word)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isImported() {
		return description.contains("imported ");
	}
}
