package com.project.springboot.onlinestore.Service;

import java.util.List;

import com.project.springboot.onlinestore.Entity.Orders;
import com.project.springboot.onlinestore.Entity.Users;
import com.project.springboot.onlinestore.Entity.Vendor;



public interface VendorService {
	
	public List<Users> findAll();
	public List<Vendor> findById(int theId);
	public List<Vendor> findByLicenseNumber(String lNumber);
	public void save(Vendor user);
	public void deleteById(int theId);
	public List<Vendor> findVendor(String licenseNumber,String email);



}
