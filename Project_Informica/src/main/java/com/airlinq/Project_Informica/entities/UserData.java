package com.airlinq.Project_Informica.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This class UserData used to store data
 * in the same format present in the databse user_details table. 
 * 
 * @author Mahi Kumawat
 * @version 1.0
 */

@Entity
public class UserData {

	@Id
	private long id;
	private String email;
	private String first_name;
	private String last_name;
	private String password;
	
	public UserData(long id, String email, String first_name, String last_name, String password) {
		super();
		this.id = id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFirst_name() {
		return first_name;
	}
	
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
