package com.enterprise.retail.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id; 
	
	@Column(name="first_name")
	@NotNull
	private String firstName;
	
	@Column(name="last_name")
	@NotNull
	private String lastName;
	
	@Column(name="customer_address")
	@NotNull
	private String address;
	
	@Column(name="birth_date")
	@NotNull
	private String birthDate;
	
	@Column(name="contact_number")
	@NotNull
	private String contactNumber;
	
	@Column(name="email")
	@NotNull
	private String email;
	
	@Column(name="gender")
	@NotNull
	private String gender;
	
	@Transient
	private String name;
	
	public boolean isNew() {
		if(id == null) 
			return true;
		else 
			return false;
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getContactNumber() {
		return contactNumber;
	}
	
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Customer() {
//		String firstName, String lastName, int id, String address, String birthDate, String contactNumber, String email, String gender
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.id = id;
//		this.address = address;
//		this.birthDate = birthDate;
//		this.contactNumber = contactNumber;
//		this.email = email;
//		this.gender = gender;
	}
	
	public String getName() {
		return lastName + ", " + firstName;
	}
	
	public String toString() {
		return getName();
	}


}
