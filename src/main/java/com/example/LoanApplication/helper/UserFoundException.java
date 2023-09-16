package com.example.LoanApplication.helper;

public class UserFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserFoundException() {
		super("User with this username is already exist.. Try another");
	}

	public UserFoundException(String msg) {
		super(msg);
	}
}
