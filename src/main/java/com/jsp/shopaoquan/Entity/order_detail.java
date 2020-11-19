package com.jsp.shopaoquan.Entity;

import java.text.DecimalFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class order_detail {
	@Id
	@Column(name = "id_order_detail")
	private int id_order_detail;
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "total")
	private float total;	
	@Column(name = "name_prd")
	private String name_prd;
	
	@Column(name = "image_prd")
	private String image_prd;
	@Column(name = "name_customer")
	private String name_customer;
	public int getId_order_detail() {
		return id_order_detail;
	}
	public void setId_order_detail(int id_order_detail) {
		this.id_order_detail = id_order_detail;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public String getName_prd() {
		return name_prd;
	}
	public void setName_prd(String name_prd) {
		this.name_prd = name_prd;
	}
	public String getImage_prd() {
		return image_prd;
	}
	public void setImage_prd(String image_prd) {
		this.image_prd = image_prd;
	}
	
	public order_detail() {
		// TODO Auto-generated constructor stub
	}
	
	public order_detail(int id_order_detail, int quantity, float total, String name_prd, String image_prd,
			String name_customer) {
		super();
		this.id_order_detail = id_order_detail;
		this.quantity = quantity;
		this.total = total;
		this.name_prd = name_prd;
		this.image_prd = image_prd;
		this.name_customer = name_customer;
	}
	public String getName_customer() {
		return name_customer;
	}
	
	public void setName_customer(String name_customer) {
		this.name_customer = name_customer;
	}
	public float getPrice() {
		return total/quantity;
	}
	
	public String formatVND(float price) {
		DecimalFormat formatPrice = new DecimalFormat("###,###,###");
		return formatPrice.format(price) +" đ";
	}
	
}
