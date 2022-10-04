package com.airlinq.Project_Informica.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * This class Products is an entity class used to store data
 * in the same format present in the database products table. 
 * 
 * @author Adarsh kumar jha
 * @version 1.0
 */

@Entity
@Table(name="Products")
public class Products {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="ProductID")
	@ApiModelProperty(notes = "Product ID", example = "1", required = true) 
	private Integer productId;
	
	@Column(name="ProductName")
	@ApiModelProperty(notes = "ProductName", example = "Chai", required = true) 
	private String productName;
	
	@Column(name="SupplierID")
	@ApiModelProperty(notes = "SupplierID", example = "1", required = true) 
	private Integer supplierId;
	
	@Column(name="CategoryID")
	@ApiModelProperty(notes = "CategoryID", example = "1", required = true) 
	private Integer categoryId;
	
	@Column(name="QuantityPerUnit")
	@ApiModelProperty(notes = "Quantity Per Unit", example = "24 - 12 oz bottles", required = true) 
	private String quantityPerUnit;
	
	@Column(name="UnitPrice")
	@ApiModelProperty(notes = "Unit Price", example = "10", required = true) 
	private double unitPrice;
	
	@Column(name="UnitsInStock")
	@ApiModelProperty(notes = "Units In Stock", example = "10", required = true) 
	private short unitsInStock;
	
	@Column(name="UnitsOnOrder")
	@ApiModelProperty(notes = "Units On Order", example = "17", required = true) 
	private short unitsOnOrder;
	
	@Column(name="ReorderLevel")
	@ApiModelProperty(notes = "ReorderLevel", example = "7", required = true) 
	private short reorderLevel;
	
	@Column(name="Discontinued")
	@ApiModelProperty(notes = "Discontinued", example = "0", required = true) 
	private boolean discontinued;
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Products(Integer productId, String productName, Integer supplierId, Integer categoryId,
			String quantityPerUnit, double unitPrice, short unitsInStock, short unitsOnOrder, short reorderLevel,
			boolean discontinued) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.reorderLevel = reorderLevel;
		this.discontinued = discontinued;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public short getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(short unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public short getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(short unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	public short getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(short reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}
	
	
	

}