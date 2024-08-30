package com.prowings.exception;

public class Error {

	private String message;
	private String rootCause;
	private int statusCode;
	
	public Error() {
		super();
	}

	public Error(String message, String rootCause, int statusCode) {
		super();
		this.message = message;
		this.rootCause = rootCause;
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "Error [message=" + message + ", rootCause=" + rootCause + ", statusCode=" + statusCode + "]";
	}
	
	
	
}
