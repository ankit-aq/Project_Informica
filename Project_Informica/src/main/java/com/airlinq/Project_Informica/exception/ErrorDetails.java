package com.airlinq.Project_Informica.exception;

import java.util.Date;



/**
 * The ErrorDetails entity class stores the error details when the exception occurs.
 * 
 * @author Ankit Sharma
 * @version 1.0
 */

public class ErrorDetails {
	
	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

}
