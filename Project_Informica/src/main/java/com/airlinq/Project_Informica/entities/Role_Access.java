package com.airlinq.Project_Informica.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role_Access {
	
	@Id
	private String user_email;
	private String query_name;
	
	public Role_Access() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role_Access(String user_email, String query_name) {
		super();
		this.user_email = user_email;
		this.query_name = query_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getQuery_name() {
		return query_name;
	}

	public void setQuery_name(String query_name) {
		this.query_name = query_name;
	}
	
	
	
	

}
