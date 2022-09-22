package com.airlinq.Project_Informica.entities;

import javax.persistence.Entity;

import javax.persistence.Id;

/**
 * This class Role_access is an entity class used to store data
 * in the same format present in the database role_access table. 
 * 
 * @author Ankit Sharma
 * @version 1.0
 */

@Entity
public class Role_Access {
	
	@Id
	private int role_id;
	private String query_name;
	private String email;
	
	public Role_Access() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role_Access(int role_id, String query_name, String email) {
		super();
		this.role_id = role_id;
		this.query_name = query_name;
		this.email = email;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getQuery_name() {
		return query_name;
	}

	public void setQuery_name(String query_name) {
		this.query_name = query_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
