package com.andersonfelipe.taxcalculator.product;

import java.util.HashMap;
import java.util.Map;

public class Product {
	
	private String description;
	
	private float shelfPrice;
	
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

	private static Map<ProductType,String[]> dictionaryTypes = new HashMap<ProductType,String[]>(){
		private static final long serialVersionUID = 1L;

	{
		put(ProductType.Food, new String[] {"chocolate","chocolates"});
		put(ProductType.Medical, new String[] {"pills"});
		put(ProductType.Book, new String[] {"book"});
	}
	};
	
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
