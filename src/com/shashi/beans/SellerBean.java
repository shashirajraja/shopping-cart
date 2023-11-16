package com.shashi.beans;


import java.io.Serializable;

@SuppressWarnings("serial")

public class SellerBean extends UserBean implements Serializable{
	
	private String companyName;
	private int companyID;
	
	//the list are going to be in seller service

	public SellerBean() {
	}

	public SellerBean(String userName, Long mobileNo, String emailId, String address, 
			int pinCode, String password, String companyName, int companyID) {
		super();
		this.name = userName;
		this.mobile = mobileNo;
		this.email = emailId;
		this.address = address;
		this.pinCode = pinCode;
		this.password = password;
		this.companyName = companyName;
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCompanyID() {
		return companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	
}
