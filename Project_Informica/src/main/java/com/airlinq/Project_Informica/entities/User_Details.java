package com.airlinq.Project_Informica.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class User_Details is an entity class used to store data
 * in the same format present in the database user_details table. 
 * 
 * @author Mahi Kumawat
 * @version 1.0
 */

@Entity
@Table(name="user_details")
public class User_Details {

	private long id;
	@Id
	private String user_email;
	private String first_name;
	private String last_name;
	private String password;
	private String roles;
	
	
	public User_Details(long id, String user_email, String first_name, String last_name, String password, String roles) {
		super();
		this.id = id;
		this.user_email = user_email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.roles = roles;
	}
	public User_Details() {
		
		super();
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getuser_email() {
		return user_email;
	}
	
	public void setuser_email(String user_email) {
		this.user_email = user_email;
	}
	

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
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
