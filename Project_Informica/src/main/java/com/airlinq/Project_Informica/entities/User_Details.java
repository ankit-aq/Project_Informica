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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

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
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.TABLE)
	@ApiModelProperty(notes = "User Id", example = "2", required = true) 
	private long user_id;
	
	@Column(name="first_name")
	@ApiModelProperty(notes = "First Name", example = "Vansh", required = true) 
	private String first_name;

	@Column(name="last_name")
	@ApiModelProperty(notes = "Last Name", example = "Agarwal", required = true) 
	private String last_name;
	
	@Column(name="alias")
	@ApiModelProperty(notes = "Alias", example = "vanshu", required = true) 
	private String alias;
	
	@Column(name="email")
	@ApiModelProperty(notes = "Email", example = "vansh23@gmail.com", required = true) 
	private String email;
	
	@Column(name="password")
	@ApiModelProperty(notes = "Password", example = "apple23", required = true) 
	private String password;

	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName = "user_id", foreignKey = @ForeignKey(name="fk_userID_urmapping"))
	private List<UserRolesMapping> userRolesMapping;
	
	
	public User_Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public User_Details(long user_id, String first_name, String last_name, String alias, String email, String password,
			List<UserRolesMapping> userRolesMapping) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.alias = alias;
		this.email = email;
		this.password = password;
		this.userRolesMapping = userRolesMapping;
	}



	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
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

	public List<UserRolesMapping> getUserRolesMapping() {
		return userRolesMapping;
	}

	public void setUserRolesMapping(List<UserRolesMapping> userRolesMapping) {
		this.userRolesMapping = userRolesMapping;
	}

	
	
}
