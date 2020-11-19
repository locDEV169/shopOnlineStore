package com.jsp.shopaoquan.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsp.shopaoquan.DAO.TypeDAO;


import com.jsp.shopaoquan.Entity.type;

@Service(value = "productTypeService")
@Transactional
public class TypeService {
	@Autowired
	private TypeDAO TypeDAO;
	public List<type  > findAll(){
		return TypeDAO.findAll();
	}
}
