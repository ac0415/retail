package com.enterprise.retail.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	@NotNull
	private int id; 
	
	@Column(name="category_code", unique=true)
	@NotNull
	private String categoryCode;
	
	@Column(name="category_name", unique=true)
	@NotNull
	private String categoryName;
	
	@Column(name="description", columnDefinition="TEXT")
	private String description;
	
	//connected with Product
	@OneToMany(mappedBy="category")
	private List<Product> product;
	
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}


}
