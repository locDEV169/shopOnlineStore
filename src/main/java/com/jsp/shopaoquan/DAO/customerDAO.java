package com.jsp.shopaoquan.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jsp.shopaoquan.Entity.customer;

@Repository(value = "customerDAO")
@Transactional
@Component
public class customerDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public void save(final customer cus) {
		Session session = sessionFactory.getCurrentSession();
		session.save(cus);
	}
	public customer findbyID(final String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(customer.class, id);
	}

	public void update(final customer cus) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(cus);
	}
	public void delete(final customer cus) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(cus);
	}
	public List<customer> findAll(){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("From customer", customer.class).getResultList();
	}
}
