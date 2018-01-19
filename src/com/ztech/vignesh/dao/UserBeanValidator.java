package com.ztech.vignesh.dao;

public class UserBeanValidator {

	public boolean setFirstName(String firstName) {
		if(firstName.matches("[a-zA-Z]{1,20}")) {
			return true;
		}
		return false;
	}
	
	public boolean setLastName(String lastName) {
		if(lastName.matches("[a-zA-Z]{1,20}")) {
			return true;
		}
		return false;
	}
	
	public boolean setPassword(String password) {
		if(password.matches(".+")) {
			return true;
		}
		return false;
	}
	
	public boolean setPhone(String phone) {
		if(phone.matches("[0-9]{10}")) {
			return true;
		}
		return false;
	}
	
	public boolean setEmail(String email) {
		if(email.matches("[a-zA-Z\\@\\/\\.\\?\\#]{1,20}")) {
			return true;
		}
		return false;
	}
}
