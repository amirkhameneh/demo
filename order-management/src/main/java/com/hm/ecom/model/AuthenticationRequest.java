package com.hm.ecom.model;

public class AuthenticationRequest {
	private String username;
	public String getUsername() {
		return username;
	}
	
	public AuthenticationRequest() {
		
	}
	
	public AuthenticationRequest(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	private String password;
	
	
}
