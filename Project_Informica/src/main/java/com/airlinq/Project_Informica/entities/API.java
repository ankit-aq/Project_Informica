package com.airlinq.Project_Informica.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * This class API is an entity class used to store data
 * in the same format present in the database API table. 
 * Its an entity class.
 * 
 * @author Mahi Kumawat
 * @version 1.0
 */

@Entity
@Table(name="api")
public class API {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="api_id")
	@ApiModelProperty(notes = "API ID", example = "1", required = true) 
	private int api_id;
	
	@Column(name="api_name")
	@ApiModelProperty(notes = "API Name", example = "getAllRolesDetails", required = true) 
	private String api_name;
	
	@Column(name="api_description")
	@ApiModelProperty(notes = "API Description", example = "Fetches all roles details", required = true) 
	private String api_description;
	
	@Column(name="swagger_link")
	@ApiModelProperty(notes = "Swagger Link", example = "http://localhost:9192/swagger-ui/index.html#/roles-details-controller/getAllRolesDetailsUsingGET", required = true) 
	private String swagger_link;
	
	/**
	 * Adds one to many mapping.
	 */
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="api_id", referencedColumnName = "api_id", foreignKey = @ForeignKey(name="fk_apiID_ramapping"))
	private List<RolesAPIMapping> rolesApiMapping;

	public API() {
		super();
		// TODO Auto-generated constructor stub
	}

	public API(int api_id, String api_name, String api_description, String swagger_link) {
		super();
		this.api_id = api_id;
		this.api_name = api_name;
		this.api_description = api_description;
		this.swagger_link = swagger_link;
	}

	
	
	public String getSwagger_link() {
		return swagger_link;
	}

	public void setSwagger_link(String swagger_link) {
		this.swagger_link = swagger_link;
	}

	public int getApi_id() {
		return api_id;
	}

	public void setApi_id(int api_id) {
		this.api_id = api_id;
	}

	public String getApi_name() {
		return api_name;
	}

	public void setApi_name(String api_name) {
		this.api_name = api_name;
	}

	public String getApi_description() {
		return api_description;
	}

	public void setApi_description(String api_description) {
		this.api_description = api_description;
	}

	
	
	
	

}
