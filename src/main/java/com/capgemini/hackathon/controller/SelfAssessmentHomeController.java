package com.capgemini.hackathon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class SelfAssessmentHomeController implements SelfAssessmentHomeAPI{

	Logger logger = LoggerFactory.getLogger(SelfAssessmentHomeController.class);
	
	@Value("${appenv}")
	private String appenv;
	
	@Override
	public String getMessage(String message) {
		// TODO Auto-generated method stub
		logger.info("### Application initalized for Environment:{} ###", appenv);
		return "### AtChubb Business Application initalized for Environment:" + appenv + " ###";
	}

}
