package com.entomo.application.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiError extends ApiResponse {
	
	/*
	 * Member Variables 
	 * 
	 * status - Property that holds the operation status call (i.e. 400 BAD_REQUEST)
	 * timestamp - Property that holds the date-time instance of when the error occurred
	 * message - Property that holds a user-friendly message about the error
	 * debugMessage - Property that holds a system message describing the error in more detail
	 * subErrors - Property that holds an array of sub-errors that happen. This is used to represent
	 * 			   multiple errors in a single call. 
	 */
	private String debugMessage;
	
	// Constructors
	private ApiError() {
		this.setTimestamp(LocalDateTime.now());
	}
	
	public ApiError(HttpStatus status) {
		this();
		this.setStatus(status); 
	}
	
	public ApiError(HttpStatus status, Throwable ex) {
		this();
		this.setStatus(status);
		this.setMessage("Unexpected error");
		this.debugMessage = ex.getLocalizedMessage();
	}
	
	public ApiError(HttpStatus status, String message, Throwable ex) {
		this();
		this.setStatus(status);
		this.setMessage("Unexpected error");
		this.debugMessage = ex.getLocalizedMessage();
	}

	// Getter debugMessage
	public String getDebugMessage() {
		return debugMessage;
	}

}




















