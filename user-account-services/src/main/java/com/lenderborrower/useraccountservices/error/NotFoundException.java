package com.lenderborrower.useraccountservices.error;

public class NotFoundException extends RuntimeException {
	public NotFoundException(String exception) {
	    super(exception + " Not Found.");
	  }
}
