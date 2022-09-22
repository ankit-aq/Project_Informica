package com.airlinq.Project_Informica.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="email", referencedColumnName="user_email", foreignKey = @ForeignKey(name = "fk_user_role"))
	private List<Role_Access> roles_access;

	public User_Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User_Details(long id, String user_email, String first_name, String last_name, String password, String roles,
			List<Role_Access> roles_access) {
		super();
		this.id = id;
		this.user_email = user_email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.roles = roles;
		this.roles_access = roles_access;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
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

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public List<Role_Access> getRoles_access() {
		return roles_access;
	}

	public void setRoles_access(List<Role_Access> roles_access) {
		this.roles_access = roles_access;
	}

	
	
}
