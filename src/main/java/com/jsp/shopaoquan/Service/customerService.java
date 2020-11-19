package com.jsp.shopaoquan.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsp.shopaoquan.DAO.customerDAO;
import com.jsp.shopaoquan.Entity.customer;
import com.jsp.shopaoquan.Entity.order_detail;

@Service(value = "customerService")
@Transactional
public class customerService {
	@Autowired
	private customerDAO customerDAO;
	public List<customer> findAll(){
		return customerDAO.findAll();
	}
	public customer findByID(String id) {
		return customerDAO.findbyID(id);
	}
	public void save(customer cus) {
		customerDAO.save(cus);
	}
	public void update(customer cus) {
		customerDAO.update(cus);
	}
	public void delete(customer cus) {
		customerDAO.delete(cus);
	}
}
