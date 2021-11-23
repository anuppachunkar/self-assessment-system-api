package com.capgemini.hackathon.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class ResponseMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum StatusEnum{
		
		INFO("I"),
		
		ERROR("E"),
		
		SUCCESS("S"),
		
		WARN("W");
		
		private String value;

		private StatusEnum(String value) {
			this.value = value;
		}
		
		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String text) {
			for (StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
		
	}
}
