package com.Adepu.Order.Exceptions;

public class OrderNotFoundException extends RuntimeException{
	public OrderNotFoundException(String message) {
	super(message);
	}
}
