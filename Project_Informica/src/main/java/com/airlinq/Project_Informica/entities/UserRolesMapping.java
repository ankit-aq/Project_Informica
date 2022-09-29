package com.airlinq.Project_Informica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_roles_mapping")
public class UserRolesMapping {

	@Id
	@Column(name="user_roles_mapping_id")
	private int user_roles_mapping_id;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="role_id")
	private int role_id;

	
	
	public UserRolesMapping() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserRolesMapping(int user_roles_mapping_id, int user_id, int role_id) {
		super();
		this.user_roles_mapping_id = user_roles_mapping_id;
		this.user_id = user_id;
		this.role_id = role_id;
	}

	public int getUser_roles_mapping_id() {
		return user_roles_mapping_id;
	}


	public void setUser_roles_mapping_id(int user_roles_mapping_id) {
		this.user_roles_mapping_id = user_roles_mapping_id;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	
	
	
	
	
}
