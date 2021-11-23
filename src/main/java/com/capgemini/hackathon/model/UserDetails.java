package com.capgemini.hackathon.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("age")
	private int age;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("symptoms")
	private List<String> symptoms;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<String> symptoms) {
		if(null == symptoms) {
			symptoms = new ArrayList<String>();
		}
		this.symptoms = symptoms;
	}

	@Override
	public String toString() {
		return "UserDetails [name=" + name + ", age=" + age + ", gender=" + gender + ", symptoms=" + symptoms + "]";
	}

	
	
	
}
