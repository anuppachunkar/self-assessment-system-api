package com.capgemini.hackathon.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.capgemini.hackathon.config.ApplicationProperties;

@Order(1)
@Component
public class AuthorizationFilter implements Filter{
	
	@Autowired
	private ApplicationProperties applicationProperties;
	
	private static Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String METHOD_NAME = "doFilter";
		logger.info(METHOD_NAME + " Application Environment:{}", applicationProperties.getProperty("appenv"));
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String path = httpRequest.getRequestURI();
		if(path.contains("/selfassessment/")) {
			// TODO: setting session
		}
		
		chain.doFilter(httpRequest, httpResponse);
	}
	
	
	

}
