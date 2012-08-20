package com.enterprise.retail.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	@NotNull
	private Integer id; 
	
	@Column(name="product_code", unique=true)
	@NotNull
	private String productCode;
	
	@Column(name="product_name", unique=true)
	@NotNull
	private String productName;
	
	@Column(name="description", columnDefinition="TEXT")
	private String description;
	
	@Column(name="product_cost")
	@NotNull
	private double cost;
	
	//connected with Category
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	//connected with SaleTransaction!
	@ManyToOne
	@JoinColumn(name="transaction_id")
	private SaleTransaction saleTransaction;
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SaleTransaction getSaleTransaction() {
		return saleTransaction;
	}
	public void setSaleTransaction(SaleTransaction saleTransaction) {
		this.saleTransaction = saleTransaction;
	}

	public boolean isNew() {
		if(id == null) 
			return true;
		else 
			return false;
	}
}
