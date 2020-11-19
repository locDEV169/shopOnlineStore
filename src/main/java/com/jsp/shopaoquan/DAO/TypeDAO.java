package com.jsp.shopaoquan.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.jsp.shopaoquan.Entity.type;

@Repository(value = "productTypeDAO")
@Transactional(rollbackFor = Exception.class)
@Component
public class TypeDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public void save(final type prd) {
		Session session = sessionFactory.getCurrentSession();
		session.save(prd);
	}
	public type findbyID(final int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(type.class, id);
	}
	
	public void update(final type type) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(type);
	}
	public void delete(final type type) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(type);
	}
	public List<type> findAll(){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("From type", type.class).getResultList();
	}
}
