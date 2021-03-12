package com.project.springboot.onlinestore.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.springboot.onlinestore.Entity.UserCredentials;
import com.project.springboot.onlinestore.Entity.Users;
import com.project.springboot.onlinestore.Service.UsersService;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
  
  
/*
  static {
    //inMemoryUserList.add(new JwtUserDetails(1L, "sudipto",
    		//"$2a$10$wi1pib42l/tx9Bb018kKOu7VxGLR9eeH1eps4a1/sCatluoIS8HFy", "ROLE_USER_2"));
        //"$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
	inMemoryUserList.add(new JwtUserDetails(1L, "PRXY1234",
		"$2a$10$6xIcGk1JR8kuoeschGOA5uwkfou75l6klmDxH797.ggpAgHJTKTQa", "ROLE_USER_2"));
    
    
  }
 */ 
  
  @Autowired
  private UsersService userService;

	/*
	  @Override 
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		  
		  Optional<JwtUserDetails> findFirst = inMemoryUserList.stream() .filter(user ->user.getUsername().equals(username)).findFirst();
	  
	  if (!findFirst.isPresent()) { 
		  
		  throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username)); 
		  
	  }
	  
	  Users user=userService.findByUserName(username);
	  
	  
	  if (user == null) { 
		  
		  throw new UsernameNotFoundException("User not found with username: " + username); 
		  
	  }
	  System.out.println("Username "+user.getUserCredentials().getLoginName());
	  System.out.println("pass "+user.getUserCredentials().getPassword());
	  
	  return new org.springframework.security.core.userdetails.User(user.getUserCredentials().getLoginName(), user.getUserCredentials().getPassword(), new ArrayList<>());
	  
	  }
	  */
	  
	 
  
	
	  @Override public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		  
		  	System.out.println("TESTING 222");
		    System.out.println("User name is "+username);
	
		  
		  UserCredentials uCred=userService.findByUserName(username);
		  BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		  String encodedPassword=encoder.encode(uCred.getPassword());
		  
		  inMemoryUserList.add(new JwtUserDetails(1L, uCred.getLoginName(),
				  encodedPassword, "ROLE_USER_2"));
		  
		  Optional<JwtUserDetails> findFirst =inMemoryUserList.stream().filter(user ->user.getUsername().equals(username)).findFirst();
	  
	  if (!findFirst.isPresent()) { 
		  
		  throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username)); }
	  
	  return findFirst.get(); 
	  
	  }
	 

}


