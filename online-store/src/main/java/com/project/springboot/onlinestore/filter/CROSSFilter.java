package com.project.springboot.onlinestore.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CROSSFilter implements Filter {

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		
		/*
		 * HttpServletRequest request=(HttpServletRequest) servletRequest;
		 * HttpServletResponse response=(HttpServletResponse) servletResponse;
		 * 
		 * response.addHeader("Access-Control-Allow-Origin", "*");
		 * response.addHeader("Access-Control-Allow-Methods",
		 * "GET,PUT,POST,OPTIONS,PUT,DELETE");
		 * response.addHeader("Access-Control-Allow-Headers",
		 * "Origib, X-Requested-With, Content-Type, Accept, Pragma, If-Modified-Since, Cache-Control, sm_user"
		 * );
		 * 
		 * if("OPTIONS".equals(request.getMethod())) {
		 * response.setStatus(HttpServletResponse.SC_OK); return; }
		 * chain.doFilter(request, servletResponse);
		 */
		
		//This class is omitted as its not required here
	}

}
