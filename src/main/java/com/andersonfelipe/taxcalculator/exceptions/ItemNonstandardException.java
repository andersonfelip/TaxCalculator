package com.andersonfelipe.taxcalculator.exceptions;

public class ItemNonstandardException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7765694862716779049L;

	public ItemNonstandardException(String errorMessage) {
        super(errorMessage);
    }
}
