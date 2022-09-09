package com.nidservices.admin_registration.model;

import java.util.UUID;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	private UUID id;
	@NonNull
	private int code;
	@NonNull
	private String type;
	
	public User(@JsonProperty("id") UUID id,
			    @JsonProperty("code") int code,
			    @JsonProperty("type") String type) {
		this.id = id;
		this.code = code;
		this.type = type;
	}

	public UUID getId() {
		return id;
	}
	
	public int getCode() {
		return code;
	}

	public String getType() {
		return type;
	}
    
	public void setCode(int code) {
		this.code = code;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	

}
