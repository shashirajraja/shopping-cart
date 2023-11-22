package com.shashi.service;

import com.shashi.beans.StudentBean;
import com.shashi.beans.UserBean;

public interface UserService {

	/*
	 * private String userName; private Long mobileNo; private String emailId;
	 * private String address; private int pinCode; private String password;
	 */

	public String registerStudentUser(String userName, Long mobileNo, String emailId, String address, int pinCode,
			String password, String firstName, String lastName, String concordiaID);

	public String registerStudentUser(StudentBean user);

	public boolean isRegistered(String emailId, String concordiaId);

	public String isValidCredential(String emailId, String password, String concordiaId);

	public StudentBean getStudentDetails(String emailId, String password);

	public String getFName(String emailId);

	public String getUserAddr(String userId);

}
