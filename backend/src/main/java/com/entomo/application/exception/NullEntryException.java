package com.entomo.application.exception;

import com.entomo.application.project.Project;

public class NullEntryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NullEntryException(@SuppressWarnings("rawtypes") Class forClass, Object o) {
		super(NullEntryException.generateMessage(forClass, o));
	}
	
	private static String generateMessage(@SuppressWarnings("rawtypes") Class forClass, Object o) {
		String returnString = "Sent in no entry for the following values: ";
		if(o instanceof Project) {
			Project p = (Project) o;
			if(p.getName() == null) {
				returnString += "name ";
			}
			if(p.getDescription() == null) {
				returnString += "description";
			}
		}
        return returnString.trim();
    }
}
