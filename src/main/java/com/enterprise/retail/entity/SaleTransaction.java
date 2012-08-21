package com.enterprise.retail.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="sale_transaction")
public class SaleTransaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	@NotNull
	private Integer id; 
	
	@Column(name="transaction_code", unique=true)
	@NotNull
	private String transactionCode;
	
	@Column(name="transaction_date")
	@NotNull
	private String transactionDate;
	
	//connected with Store
	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store;
	
	//connected with Product
	@OneToMany(mappedBy="saleTransaction")
	private List<Product> product;
	
	@Column(name="transaction_cost")
	private double cost;
	
	public String getTransactionCode() {
		return transactionCode;
	}
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}

	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public List<Product> getProduct() {
		return product;	
	}
	
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	
	public boolean isNew() {
		if(id == null) 
			return true;
		else 
			return false;
	}
	
}
