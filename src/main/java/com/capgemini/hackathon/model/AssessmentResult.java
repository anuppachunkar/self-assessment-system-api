package com.capgemini.hackathon.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AssessmentResult extends ResponseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("age")
	private int age;
	
	@JsonProperty("possibleDiseases")
	private List<PossibleDisease> possibleDiseases;

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

	public List<PossibleDisease> getPossibleDiseases() {
		if(null == possibleDiseases) {
			possibleDiseases = new ArrayList<PossibleDisease>();
		}
		return possibleDiseases;
	}

	public void setPossibleDiseases(List<PossibleDisease> possibleDiseases) {
		this.possibleDiseases = possibleDiseases;
	}

	@Override
	public String toString() {
		return "AssessmentResult [name=" + name + ", age=" + age + ", possibleDiseases=" + possibleDiseases + "]";
	}

	
}
