package com.capgemini.hackathon.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.hackathon.model.UserDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController("/selfassessment")
public interface SelfAssessmentAPI {
	
	@PostMapping(value = "/diagnose" , produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> doAssessment(HttpServletRequest request, HttpServletResponse response,
			@RequestBody UserDetails userDetails);	
}
