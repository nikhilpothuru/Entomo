package com.entomo.application.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ApiSuccess extends ApiResponse {
	
	private Object data; 
	
	public ApiSuccess() {
		this.setTimestamp(LocalDateTime.now());
		this.setStatus(HttpStatus.OK);
		this.setMessage("Success");
	}

	public Object getData() {
		return data;
	}

	public void setData(Object content) {
		this.data = content;
	}

}
