package com.thmub.shop.bean;

public class UserBean {
	private String validUserName;

	private String validUserPassword;

	public String getValidUserName() {

		return validUserName;

	}



	public void setValidUserName(String validUserName) {

		this.validUserName = validUserName;

	}



	public String getValidUserPassword() {

		return validUserPassword;

	}



	public void setValidUserPassword(String validUserPassword) {

		this.validUserPassword = validUserPassword;

	}



	public boolean isValidUser(String name, String password) {

		boolean result = false;

		if (validUserName.equals(name) && validUserPassword.equals(password)) {

			result = true;

		}

		return result;

	}


}
