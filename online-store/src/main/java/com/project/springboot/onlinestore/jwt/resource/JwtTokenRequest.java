package com.project.springboot.onlinestore.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {
  
  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
    private String password;
    
    
	/*
	 * { "token":
	 * "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdWRpcHRvIiwiZXhwIjoxNTkwNjgyMzI3LCJpYXQiOjE1OTAwNzc1Mjd9.c_xmTpFCzqFMR8op_6OI_7XbI2rz1vnCQQgWbpCa-IfzdAJ9Sdqq-AhjU-dl2QrlSqzS16-mE2Z-YQ8FejKXhw"
	 * }
	 */
    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
    	
    	
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
    	
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

