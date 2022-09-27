package com.airlinq.Project_Informica.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This class Role_access is an entity class used to store data
 * in the same format present in the database role_access table. 
 * 
 * @author Ankit Sharma
 * @version 1.0
 */

@Entity
@Table(name="roles")
public class Roles {
	
	@Id
	@GeneratedValue
	@Column(name="role_id")
	private int role_id;
	
	@Column(name="role_name")
	private String role_name;
	
	@Column(name="role_description")
	private String role_description;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="role_id", referencedColumnName="role_id", foreignKey = @ForeignKey(name = "fk_role_user"))
	private List<User_Details> user_details;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "roles_api_mapping", 
	  joinColumns = {@JoinColumn(name = "role_id" , referencedColumnName="role_id", foreignKey = @ForeignKey(name = "fk_role_id"))},
	  inverseJoinColumns = {@JoinColumn(name = "api_id", referencedColumnName="api_id", foreignKey = @ForeignKey(name = "fk_api_id"))})
	private List<API> api;
	
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(int role_id, String role_name, String role_description) {
		super();
		this.role_id = role_id;
		this.role_name = role_name;
		this.role_description = role_description;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_description() {
		return role_description;
	}

	public void setRole_description(String role_description) {
		this.role_description = role_description;
	}
	

}
