package com.andersonfelipe.taxcalculator.tax;

import com.andersonfelipe.taxcalculator.product.Product;
import com.andersonfelipe.taxcalculator.product.ProductType;

public class BasicSales extends Tax {

	public BasicSales() {
	}

	private ProductType[] excemptionsTax = { ProductType.Book, ProductType.Food, ProductType.Medical };

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
	float getRate() {
		return 10;
	}
}
