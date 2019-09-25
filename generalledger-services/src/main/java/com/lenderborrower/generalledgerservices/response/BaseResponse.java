package com.lenderborrower.generalledgerservices.response;

public abstract class BaseResponse {
	
	private Integer httpCode;
	private String message;
	
	public Integer getHttpCode() {
		return httpCode;
	}
	public String getMessage() {
		return message;
	}
	
	public BaseResponse(Integer httpCode, String message) {
		super();
		this.httpCode = httpCode;
		this.message = message;
	}
	
	
	
	
}
