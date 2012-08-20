package com.enterprise.retail.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="store")
public class Store {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	@NotNull
	private int id; 
	
	@Column(name="store_code", unique=true)
	@NotNull
	private String storeCode;
	
	@Column(name="store_name", unique=true)
	@NotNull
	private String storeName;
	
	@Column(name="store_address")
	@NotNull
	private String address;
	
	public String getStoreCode() {
		return storeCode;
	}
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	//connected with SaleTransaction
	@OneToMany(mappedBy="store")
	private List<SaleTransaction> st;

	public List<SaleTransaction> getSt() {
		return st;
	}
	public void setSt(List<SaleTransaction> st) {
		this.st = st;
	}
	
	
	
}
