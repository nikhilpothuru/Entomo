package com.entomo.application.exception;



@SuppressWarnings("serial")
public class EntityNotFoundException extends RuntimeException {
	
	 public EntityNotFoundException(@SuppressWarnings("rawtypes") Class clazz) {
	        super(EntityNotFoundException.generateMessage(clazz.getSimpleName() + " cannot find a value for the parameter."));
	    }

    private static String generateMessage(String entity) {
        return entity;
    }
	
}
