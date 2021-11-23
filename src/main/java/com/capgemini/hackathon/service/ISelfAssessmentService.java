package com.capgemini.hackathon.service;

import org.springframework.stereotype.Service;

import com.capgemini.hackathon.model.AssessmentResult;
import com.capgemini.hackathon.model.UserDetails;

@Service
public interface ISelfAssessmentService {
	
	public AssessmentResult retrieveAssessmentResult(UserDetails userDetails);

	
	
}
