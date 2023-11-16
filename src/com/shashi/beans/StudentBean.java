package com.shashi.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class StudentBean extends UserBean implements Serializable{
	
	private String firstName;
	private String lastName;
	private int concordiaID;
	
	public StudentBean() {
	}

	public StudentBean(String userName, Long mobileNo, String emailId, String address, int pinCode, String password, String firstName, String lastName, int concordiaID) {
		super();
		this.name = userName;
		this.mobile = mobileNo;
		this.email = emailId;
		this.address = address;
		this.pinCode = pinCode;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.concordiaID = concordiaID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getConcordiaID() {
		return concordiaID;
	}

	public void setConcordiaID(int concordiaID) {
		this.concordiaID = concordiaID;
	}
	
	
	
	
	
	//private ProductBean[] productCart; //to verify if needed here or in other class
}
