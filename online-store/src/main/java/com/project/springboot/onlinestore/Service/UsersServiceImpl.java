package com.project.springboot.onlinestore.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springboot.onlinestore.Dao.UsersDao;
import com.project.springboot.onlinestore.Dao.UsersDaoImpl;
import com.project.springboot.onlinestore.Entity.Orders;
import com.project.springboot.onlinestore.Entity.UserCredentials;
import com.project.springboot.onlinestore.Entity.Users;

@Service
public class UsersServiceImpl implements UsersService {
	
	private UsersDao userDao;	
	

	public UsersServiceImpl(UsersDao userDao) {
		this.userDao = userDao;
	}

	@Override
	@Transactional
	public List<Users> findAll() {
		
		return userDao.findAll();
	}

	@Override
	@Transactional
	public Users findById(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void save(Users user) {
		userDao.save(user);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub

	}
	
	@Override
	@Transactional
	public UserCredentials findByUserName(String loginName) {
		
		return userDao.findByUserName(loginName);
	}

}
