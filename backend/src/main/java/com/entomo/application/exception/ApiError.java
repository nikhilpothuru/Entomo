package com.entomo.application.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

abstract class ApiSubError{
	
}

public class ApiError {
	
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
	private HttpStatus status; 
	private LocalDateTime timestamp;
	private String message;
	private String debugMessage;
	private List<ApiSubError> subErrors;
	
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

	// Getter & Setter for status
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	// Getter & Setter for timestamp
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	// Getter & Setter for message
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// Getter debugMessage
	public String getDebugMessage() {
		return debugMessage;
	}

	// Getter & Setter for subErrors
	public List<ApiSubError> getSubErrors() {
		return subErrors;
	}

	public void setSubErrors(List<ApiSubError> subErrors) {
		this.subErrors = subErrors;
	}
}

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
class ApiValidationError extends ApiSubError{
	@SuppressWarnings("unused")
	private String object;
	@SuppressWarnings("unused")
	private String field;
	@SuppressWarnings("unused")
	private Object rejectedValue;
	@SuppressWarnings("unused")
	private String message; 
	
	public ApiValidationError(String object, String message) {
		this.object = object;
		this.message = message; 
	}
}


















