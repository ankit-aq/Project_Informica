package com.airlinq.Project_Informica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name="roles_api_mapping")
public class RolesAPIMapping {
	
	@javax.persistence.Id
	@GeneratedValue
	@Column(name="roles_api_mapping_id")
	private int roles_api_mapping_id;
	
	@Column(name="role_id")
	private int role_id;
	
	@Column(name="api_id")
	private int api_id;

	public RolesAPIMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RolesAPIMapping(int roles_api_mapping_id, int role_id, int api_id) {
		super();
		this.roles_api_mapping_id = roles_api_mapping_id;
		this.role_id = role_id;
		this.api_id = api_id;
	}

	public int getRoles_api_mapping_id() {
		return roles_api_mapping_id;
	}

	public void setRoles_api_mapping_id(int roles_api_mapping_id) {
		this.roles_api_mapping_id = roles_api_mapping_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getApi_id() {
		return api_id;
	}

	public void setApi_id(int api_id) {
		this.api_id = api_id;
	}
	
	
	
}
