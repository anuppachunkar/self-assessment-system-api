package com.capgemini.hackathon.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PossibleDisease implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("disease")
	private String disease;

	@JsonProperty("causes")
	List<String> causes; 
	

	@JsonProperty("prevention")
	List<String> prevention;
	
	@JsonProperty("moreInformationUrl")
	private String moreInformationUrl;
	

	public String getMoreInformationUrl() {
		return moreInformationUrl;
	}

	public void setMoreInformationUrl(String moreInformationUrl) {
		this.moreInformationUrl = moreInformationUrl;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public List<String> getCauses() {
		return causes;
	}

	public void setCauses(List<String> causes) {
		this.causes = causes;
	}

	public List<String> getPrevention() {
		return prevention;
	}

	public void setPrevention(List<String> prevention) {
		this.prevention = prevention;
	}

	@Override
	public String toString() {
		return "PossibleDisease [disease=" + disease + ", causes=" + causes + ", prevention=" + prevention
				+ ", moreInformationUrl=" + moreInformationUrl + "]";
	}

}
