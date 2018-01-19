package com.ztech.vignesh.beans;

public class UserBean {
	private String firstName, lastName, phone, email, password;
	
	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastname(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password= password;
	}
	
	public String getFirstname() {
		return this.firstName;
	}
	
	public String getLastname() {
		return this.lastName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassword() {
		return this.password;
	}
}
