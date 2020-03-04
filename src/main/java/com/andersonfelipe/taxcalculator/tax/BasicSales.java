package com.andersonfelipe.taxcalculator.tax;

import com.andersonfelipe.taxcalculator.product.Product;
import com.andersonfelipe.taxcalculator.product.ProductType;

public class BasicSales implements Tax {

	private ProductType[] excemptionsTax = { ProductType.BOOK, ProductType.FOOD, ProductType.MEDICAL };

	@Override
	public boolean isApplicable(Product product) {
		for (int i = 0; i < excemptionsTax.length; i++) {
			if(product.isProductTypeOf(excemptionsTax[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public float getRate() {
		return 10;
	}
}
