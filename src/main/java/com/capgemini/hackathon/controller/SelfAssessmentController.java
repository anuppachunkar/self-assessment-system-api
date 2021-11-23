package com.capgemini.hackathon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.capgemini.hackathon.model.UserDetails;

@Controller
public class SelfAssessmentController implements SelfAssessmentAPI{

	@Override
	public ResponseEntity<Object> doAssessment(HttpServletRequest request, HttpServletResponse response,
			UserDetails userDetails) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
