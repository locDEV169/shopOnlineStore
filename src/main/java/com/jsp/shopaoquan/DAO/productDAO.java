package com.jsp.shopaoquan.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jsp.shopaoquan.Entity.product;



@Repository(value = "productDAO")
@Transactional(rollbackFor = Exception.class)
@Component
public class productDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public void save(final product prd) {
		Session session = sessionFactory.getCurrentSession();
		session.save(prd);
	}
	public product findbyID(final String id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(product.class, id);
	}
	
	public void update(final product product) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(product);
	}
	public void delete(final product prd) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(prd);
	}
	public List<product> findAll(){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("From product order by price_prd asc", product.class).getResultList();
	}
	public List<product> findFP() {
		Session session = sessionFactory.getCurrentSession();
		List<product> list = session.createQuery("From product", product.class).getResultList();
		List<product> listFP = new ArrayList<product>();
		Random rd = new Random();
		int a = 21, j = 1;
		for (int i = 0; i < 4;i++) {
			
			j = rd.nextInt(20);
			if (j == a) {
				j = rd.nextInt(20);
			}
			listFP.add(list.get(j));
			a = j;
		}
		return listFP;
	}
	public List<product> findLP() {
		Session session = sessionFactory.getCurrentSession();
		List<product> list = session.createQuery("From product", product.class).getResultList();
		List<product> listLP = new ArrayList<product>();
		for (int i = list.size()-8; i < list.size();i++) {			
			listLP.add(list.get(i));
		}
		return listLP;
	}
	public List<product> sortPrice(){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("From product order by price_prd asc", product.class).getResultList();
	}
	public List<product> productType(int name_prd){
		Session session = sessionFactory.getCurrentSession();
		String query = "from product p where p.id_type="+name_prd;
		return session.createQuery(query, product.class).getResultList();
	}
	public List<product> searchProduct(final String name){
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from product where name_Prd like :names");
		query.setParameter("names","%" +name+"%");
		
		List<product> list = query.getResultList();
		return list;
	}
}
