package com.shashi.beans;

import java.io.Serializable;

public class UserBean implements Serializable{
	
	public UserBean(){}
	
	public UserBean(String userName, Long mobileNo, String emailId, String address, int pinCode, String password) {
		super();
		this.userName = userName;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.address = address;
		this.pinCode = pinCode;
		this.password = password;
	}

	private String userName;
	private Long mobileNo;
	private String emailId;
	private String address;
	private int pinCode;
	private String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
