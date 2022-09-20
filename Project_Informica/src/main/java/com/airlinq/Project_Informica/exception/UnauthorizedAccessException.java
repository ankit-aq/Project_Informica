package com.airlinq.Project_Informica.exception;

/**
 * The UnauthorizedAccessException class defines the UnauthorizedAccess exception.
 * 
 * @author Ankit Sharma
 * @version 1.0
 *
 */

public class UnauthorizedAccessException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UnauthorizedAccessException(String message) {
		super(message);
	}
}
