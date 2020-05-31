package com.entomo.application.response;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError){
		return new ResponseEntity<>(apiError, apiError.getStatus()); 
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = "Malformed JSON request";
		return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex)); 
	}
	
	@ExceptionHandler(value = EntityNotFoundException.class)
	protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex){
		
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND); 
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError); 
		
	}
	
	@ExceptionHandler(value = DuplicateEntryException.class)
	protected ResponseEntity<Object> handleDuplicateEntryException(DuplicateEntryException ex){
		
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST); 
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError); 
		
	}
	
	@ExceptionHandler(value = NullEntryException.class)
	protected ResponseEntity<Object> handleNullEntryException(NullEntryException ex){
		
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST); 
		apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError); 
		
	}
}
