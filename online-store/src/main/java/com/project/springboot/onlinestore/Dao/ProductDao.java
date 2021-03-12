package com.project.springboot.onlinestore.Dao;

import java.util.List;

import com.project.springboot.onlinestore.Entity.Orders;
import com.project.springboot.onlinestore.Entity.Product;
import com.project.springboot.onlinestore.Entity.Users;
import com.project.springboot.onlinestore.Entity.Vendor;



public interface ProductDao {
	
	public List<Product> findAll();
	public List<Product> findById(int theId);
	public void save(Product product);
	public void deleteById(int theId);
	//test

}
