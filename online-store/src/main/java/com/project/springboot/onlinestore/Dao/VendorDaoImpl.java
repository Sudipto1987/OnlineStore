package com.project.springboot.onlinestore.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springboot.onlinestore.Entity.Orders;
import com.project.springboot.onlinestore.Entity.Users;
import com.project.springboot.onlinestore.Entity.Vendor;




@Repository
public class VendorDaoImpl implements VendorDao {
	
	private EntityManager entityManager;
	
	
	@Autowired
	public VendorDaoImpl(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	

	@Override
	public List<Users> findAll() {
		Session session=entityManager.unwrap(Session.class);
		System.out.println("TEST3");		
		Query<Users> theQuery=session.createQuery("from Users",Users.class);		
		List<Users> users=theQuery.getResultList();
		for (Users user:users) {
			
			user.setOrders(null);
			
			
			
		}
		//users.get(2).toString();
		
		return users;
	}

	@Override
	public List<Vendor> findById(int theId) {
		List<Vendor> vendors=new ArrayList<Vendor>();
		Session session=entityManager.unwrap(Session.class);
		Vendor vendor=session.get(Vendor.class, theId);	
		if (vendor == null) {
			
			System.out.println("No vendor with this id ");
		}
		vendors.add(vendor);
		return vendors;
	}
	
	
	@Override
	public List<Vendor> findByLNumber(String lNumber) {
		List<Vendor> vendors=new ArrayList<Vendor>();
		Session session=entityManager.unwrap(Session.class);
		
		Query<Vendor> theQuery=session.createQuery("from Vendor where licenseNumber= :lNumber",Vendor.class);
		theQuery.setParameter("lNumber", lNumber);
		
		 vendors=theQuery.getResultList(); 
		
		return vendors;
	}
	
	
	@Override
	public List<Vendor> findVendor(String lNumber,String eMail) {
		List<Vendor> vendors=new ArrayList<Vendor>();
		Session session=entityManager.unwrap(Session.class);
		System.out.println("license "+lNumber);
		System.out.println("eMail "+eMail);
		
		Query<Vendor> theQuery=session.createQuery("from Vendor where licenseNumber= :lNumber and email= :eMail",Vendor.class);
		  
		 theQuery.setParameter("lNumber", lNumber);
		 theQuery.setParameter("eMail", eMail);
		 vendors=theQuery.getResultList(); 
		 return vendors;
		 
		
		
		
	}

	@Override
	public void save(Vendor vendor) {
		
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(vendor);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}
