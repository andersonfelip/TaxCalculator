package com.andersonfelipe.taxcalculator.tax;

import com.andersonfelipe.taxcalculator.product.Product;

public abstract class Tax {
	public abstract boolean isApplicable(Product product);
	abstract float getRate();
	
	public double calculate(Product product) {
		if(isApplicable(product)) {
			
			double tax = (product.getShelfPrice() * getRate()) / 100;
			
			tax = Math.ceil(tax / 0.05) * 0.05;
			
			return tax;
		}
		return 0;
	}
}
