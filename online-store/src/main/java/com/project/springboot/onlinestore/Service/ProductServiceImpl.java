package com.project.springboot.onlinestore.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.onlinestore.Dao.ProductDao;
import com.project.springboot.onlinestore.Dao.UsersDao;
import com.project.springboot.onlinestore.Dao.UsersDaoImpl;
import com.project.springboot.onlinestore.Dao.VendorDao;
import com.project.springboot.onlinestore.Entity.Orders;
import com.project.springboot.onlinestore.Entity.Product;
import com.project.springboot.onlinestore.Entity.Users;
import com.project.springboot.onlinestore.Entity.Vendor;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDao productDao;	
	

	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	@Transactional
	public List<Product> findAll() {
		
		return productDao.findAll();
	}

	@Override
	@Transactional
	public List<Product> findById(int theId) {
		
		return productDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Product product) {
		productDao.save(product);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}

}
