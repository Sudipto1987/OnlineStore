package com.project.springboot.onlinestore.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springboot.onlinestore.Entity.Orders;
import com.project.springboot.onlinestore.Entity.Product;
import com.project.springboot.onlinestore.Entity.Users;
import com.project.springboot.onlinestore.Entity.Vendor;




@Repository
public class ProductDaoImpl implements ProductDao {
	
	private EntityManager entityManager;
	
	
	@Autowired
	public ProductDaoImpl(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	

	@Override
	public List<Product> findAll() {
		Session session=entityManager.unwrap(Session.class);
		System.out.println("TEST3");		
		Query<Product> theQuery=session.createQuery("from Product",Product.class);		
		List<Product> products=theQuery.getResultList();
		//users.get(2).toString();
		
		return products;
	}

	@Override
	public List<Product> findById(int theId) {
		List<Product> products=new ArrayList<Product>();
		Session session=entityManager.unwrap(Session.class);
		Product product=session.get(Product.class, theId);	
		products.add(product);
		return products;
	}

	@Override
	public void save(Product product) {
		
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(product);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}
