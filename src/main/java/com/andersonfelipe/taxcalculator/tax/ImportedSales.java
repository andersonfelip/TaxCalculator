package com.andersonfelipe.taxcalculator.tax;

import com.andersonfelipe.taxcalculator.product.Product;

public class ImportedSales implements Tax{
	
	@Override
	public boolean isApplicable(Product product) {
		return product.isImported();
	}

	@Override
	public float getRate() {
		return 5;
	}
	
}
