package com.project.springboot.onlinestore.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springboot.onlinestore.Entity.Orders;
import com.project.springboot.onlinestore.Entity.UserCredentials;
import com.project.springboot.onlinestore.Entity.Users;
import com.project.springboot.onlinestore.Entity.Vendor;



@Repository
public class UsersDaoImpl implements UsersDao {
	
	private EntityManager entityManager;
	
	
	@Autowired
	public UsersDaoImpl(EntityManager entityManager) {
		
		this.entityManager = entityManager;
	}
	
	

	@Override
	public List<Users> findAll() {
		Session session=entityManager.unwrap(Session.class);
		System.out.println("TEST3");		
		Query<Users> theQuery=session.createQuery("from Users",Users.class);		
		List<Users> users=theQuery.getResultList();
		
		/*
		 * List<Users> users1=new ArrayList<Users>(); users1=users;
		 * System.out.println("User1 order is "+users1.get(0).getOrders());
		 * System.out.println("User order is "+users.get(0).getOrders()); for (Users
		 * user1: users1) { user1.setOrders(null); user1.setUserCredentials(null);
		 * 
		 * } System.out.println("User1 order is "+users1.get(0).getOrders());
		 * System.out.println("User order is "+users.get(0).getOrders());
		 */
		//users.get(0).setOrders(null);
		//users.get(0).setUserCredentials(null);
		
		return users;
	}

	@Override
	public Users findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public UserCredentials findByUserName(String lName) {
		
		System.out.println("Login name is "+lName);
		
		List<UserCredentials> uCred=new ArrayList<UserCredentials>();
		//UserCredentials uCred=new UserCredentials();
		Session session=entityManager.unwrap(Session.class);
		
		Query<UserCredentials> theQuery=session.createQuery("from UserCredentials where loginName= :lName",UserCredentials.class);
		theQuery.setParameter("lName", lName);
		
		uCred=theQuery.getResultList(); 
		System.out.println("User cred name is "+uCred.get(0).getLoginName());
		System.out.println("User cred pass is "+uCred.get(0).getPassword());
		return uCred.get(0);
	}

	@Override
	public void save(Users user) {
		
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);

	}

	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}
