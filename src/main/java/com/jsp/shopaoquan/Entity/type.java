package com.jsp.shopaoquan.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type")
public class type {
	@Id
	@Column(name = "id_prd_type")
	private int id_prd_type;
	@Column(name = "name_prd_type", unique = true)
	private String name_prd_type;
	public int getId_prd_type() {
		return id_prd_type;
	}
	public void setId_prd_type(int id_prd_type) {
		this.id_prd_type = id_prd_type;
	}
	public String getName_prd_type() {
		return name_prd_type;
	}
	public void setName_prd_type(String name_prd_type) {
		this.name_prd_type = name_prd_type;
	}
	public type() {
	}
	public type(int id_prd_type, String name_prd_type) {		
		this.id_prd_type = id_prd_type;
		this.name_prd_type = name_prd_type;
	}
	
	
}
