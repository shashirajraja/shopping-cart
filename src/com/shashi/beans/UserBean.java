package com.shashi.beans;

import java.io.Serializable;
import java.util.HashSet;

@SuppressWarnings("serial")
public class UserBean implements Serializable {

	public UserBean() {
	}

	public UserBean(String userName, Long mobileNo, String emailId, String address, int pinCode, String password, UserType userType) {
		super();
		this.name = userName;
		this.mobile = mobileNo;
		this.email = emailId;
		this.address = address;
		this.pinCode = pinCode;
		this.password = password;
		this.userType = userType;
	}

	private String name;
	private Long mobile;
	private String email;
	private String address;
	private int pinCode;
	private String password;
	private UserType userType;
	private HashSet<ProductInterest> userInterests;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	public HashSet<ProductInterest> getUserInterests() {
		return userInterests;
	}
	
	public void setUserInterests(HashSet<ProductInterest> userInterests) {
		this.userInterests = userInterests;
	}
	
	public void clearUserInterests() {
		userInterests.clear();
	}
	
	public void addUserInterest(ProductInterest userInterest) {
		if(!userInterests.contains(userInterest))
			userInterests.add(userInterest);
	}
	
	public void removeUserInterest(ProductInterest userInterest) {
		if(userInterests.contains(userInterest))
			userInterests.remove(userInterest);
	}
}
