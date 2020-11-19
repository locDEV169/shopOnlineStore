package com.jsp.shopaoquan.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class customer {
	@Id
	@Column(name =  "name_customer")
	private String name_customer;
	@Column(name =  "address")
	private String address;
	@Column(name =  "email")
	private String email;
	@Column(name =  "phone")
	private int phone;
	@Column(name =  "pass")
	private String pass;
	@Column(name =  "full_name")
	private String full_name;
	
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName_customer() {
		return name_customer;
	}
	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public customer(String name_customer, String address, String email, int phone, String pass, String full_name) {
		super();
		this.name_customer = name_customer;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.pass = pass;
		this.full_name = full_name;
	}
	public customer() {
		// TODO Auto-generated constructor stub
	}
	
}
