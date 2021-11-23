package com.capgemini.hackathon.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public interface SelfAssessmentHomeAPI {

	
	@GetMapping(value = "/home" , produces = MediaType.TEXT_PLAIN_VALUE)
	public String getMessage(String message);
}
