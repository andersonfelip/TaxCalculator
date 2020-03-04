package com.andersonfelipe.taxcalculator.tax;

import com.andersonfelipe.taxcalculator.product.Product;

public interface Tax {
	public boolean isApplicable(Product product);
	public float getRate();
	
	public default float calculate(Product product) {
		if(isApplicable(product)) {
			
			float tax = (product.getShelfPrice() * getRate()) / 100;
			
			tax = (float) (Math.ceil(tax / 0.05) * 0.05);
			
			return tax;
		}
		return 0;
	}
}
