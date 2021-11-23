package com.capgemini.hackathon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.capgemini.hackathon.filter.AuthorizationFilter;
import com.capgemini.hackathon.model.AssessmentResult;
import com.capgemini.hackathon.model.UserDetails;
import com.capgemini.hackathon.service.ISelfAssessmentService;

@Controller
public class SelfAssessmentController implements SelfAssessmentAPI{
	
	@Autowired
	private ISelfAssessmentService service;

	private static Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class);
	@Override
	public ResponseEntity<Object> doAssessment(HttpServletRequest request, HttpServletResponse response,
			UserDetails userDetails) {
		// TODO Auto-generated method stub
		
		logger.info("Into SelfAssessmentController, calling service ");
		
		AssessmentResult result =  service.retrieveAssessmentResult(userDetails);
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	}

}
