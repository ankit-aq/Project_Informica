package com.airlinq.Project_Informica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This class RolesAPIMapping is an entity class used to store data
 * in the same format present in the database RolesAPIMapping table. 
 * Its an entity class.
 * 
 * @author Mahi Kumawat
 * @version 1.0
 */

@Entity
@Table(name="roles_api_mapping")
public class RolesAPIMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
