package com.airlinq.Project_Informica.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="first_name")
	private String first_name;

	@Column(name="last_name")
	private String last_name;
	
	@Column(name="alias")
	private String alias;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role_id")
	private String role_id;
	
	public User_Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User_Details(long id, String first_name, String last_name, String alias, String email, String password,
			String role_id) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.alias = alias;
		this.email = email;
		this.password = password;
		this.role_id = role_id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	
	
}
