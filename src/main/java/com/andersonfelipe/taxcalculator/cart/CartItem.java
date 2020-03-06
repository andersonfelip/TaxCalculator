package com.andersonfelipe.taxcalculator.cart;

import com.andersonfelipe.taxcalculator.product.Product;

public class CartItem {
	private Product product;
	private int quantity;
	private float tax;
	
	public CartItem(Product product) {
		super();
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public float getCost() {
		return quantity * (tax + product.getShelfPrice());
	}

	@Override
	public String toString() {
		return String.format("%x %s: %.2f", quantity, product.getDescription(), getCost());
	}
}
