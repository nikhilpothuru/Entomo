package com.entomo.application.response;



@SuppressWarnings("serial")
public class EntityNotFoundException extends RuntimeException {
	
	 public EntityNotFoundException(@SuppressWarnings("rawtypes") Class forClass, int id) {
	        super(EntityNotFoundException.generateMessage("Cannot find a " + forClass.getSimpleName() + " with id " + id));
	    }

    private static String generateMessage(String entity) {
        return entity;
    }
	
}
