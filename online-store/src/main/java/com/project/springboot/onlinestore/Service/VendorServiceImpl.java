package com.project.springboot.onlinestore.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.onlinestore.Dao.UsersDao;
import com.project.springboot.onlinestore.Dao.UsersDaoImpl;
import com.project.springboot.onlinestore.Dao.VendorDao;
import com.project.springboot.onlinestore.Entity.Orders;
import com.project.springboot.onlinestore.Entity.Users;
import com.project.springboot.onlinestore.Entity.Vendor;

@Service
public class VendorServiceImpl implements VendorService {
	
	private VendorDao vendorDao;	
	

	public VendorServiceImpl(VendorDao vendorDao) {
		this.vendorDao = vendorDao;
	}

	@Override
	@Transactional
	public List<Users> findAll() {
		
		return vendorDao.findAll();
	}

	@Override
	@Transactional
	public List<Vendor> findById(int theId) {
		
		return vendorDao.findById(theId);
	}
	
	
	
	@Override
	@Transactional
	public List<Vendor> findByLicenseNumber(String lNumber) {
		
		return vendorDao.findByLNumber(lNumber);
	}
	
	
	@Override
	@Transactional
	public List<Vendor> findVendor(String licenseNumber,String email) {
		
		return vendorDao.findVendor(licenseNumber,email);
	}

	@Override
	@Transactional
	public void save(Vendor vendor) {
		vendorDao.save(vendor);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}
