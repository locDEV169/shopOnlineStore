package com.jsp.shopaoquan.DAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import javax.persistence.Query;

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
	public List<orderr> findAll(int month){
		Session session = sessionFactory.getCurrentSession();
		Query query =session.createQuery("From orderr o where month(o.date_of_sale)=:month order   by date(o.date_of_sale) asc"); 
		query.setParameter("month", month);
		return query.getResultList();
	}
	public LocalDate getDay() {
		LocalDate day = LocalDate.now();
		return day;
	}
	public List<orderr> findQA(int quarter){
		Session session = sessionFactory.getCurrentSession();
		if (quarter == 1) {
			quarter = 4;
		} else if (quarter == 2) {
			quarter = 7;
		} else if ( quarter == 3) {
			quarter = 10;
		} else {
			quarter = 13;
		}
		Query query =session.createQuery("From orderr o where month(o.date_of_sale)<:quarter order   by date(o.date_of_sale) asc"); 
		query.setParameter("quarter", quarter);
		return  query.getResultList();
	}
}
