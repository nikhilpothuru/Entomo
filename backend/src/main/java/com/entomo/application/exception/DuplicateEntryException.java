package com.entomo.application.exception;

public class DuplicateEntryException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DuplicateEntryException(@SuppressWarnings("rawtypes") Class forClass) {
		super( DuplicateEntryException.generateMessage(forClass));
	}
	
	private static String generateMessage(@SuppressWarnings("rawtypes") Class forClass) {
		String returnString = "Attempted duplicate entry " + forClass.getSimpleName();
        return returnString;
    }
	
	

}
