package com.jsp.shopaoquan.DAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jsp.shopaoquan.Entity.orderr;



@Repository(value = "orderDAO")
@Component
@Transactional(rollbackFor = Exception.class)
public class orderDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public void save(final orderr order) {
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
	}
	public orderr findbyID(final int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(orderr.class, id);
	}
	
	public void update(final orderr ord) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(ord);
	}
	public void delete(final orderr ord) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(ord);
	}
	public List<orderr> findAll(){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("From orderr", orderr.class).getResultList();
	}
	public LocalDate getDay() {
		LocalDate day = LocalDate.now();
		return day;
	}
}
