package com.project.springboot.onlinestore.Service;

import java.util.List;

import com.project.springboot.onlinestore.Entity.Orders;
import com.project.springboot.onlinestore.Entity.UserCredentials;
import com.project.springboot.onlinestore.Entity.Users;



public interface UsersService {
	
	public List<Users> findAll();
	public Users findById(int theId);
	public void save(Users user);
	public void deleteById(int theId);
	public UserCredentials findByUserName(String loginName) ;


}
