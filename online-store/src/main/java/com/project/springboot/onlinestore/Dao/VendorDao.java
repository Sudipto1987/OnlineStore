package com.project.springboot.onlinestore.Dao;

import java.util.List;

import com.project.springboot.onlinestore.Entity.Orders;
import com.project.springboot.onlinestore.Entity.Users;
import com.project.springboot.onlinestore.Entity.Vendor;



public interface VendorDao {
	
	public List<Users> findAll();
	public List<Vendor> findById(int theId);
	public void save(Vendor vendor);
	public void deleteById(int theId);
	public List<Vendor> findVendor(String licenseNumber,String email) ;
	public List<Vendor> findByLNumber(String theId);
}
