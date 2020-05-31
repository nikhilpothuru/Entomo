package com.entomo.application.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public abstract class ApiResponse {
	
	private HttpStatus status; 
	private LocalDateTime timestamp;
	private String message;
	
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


}
