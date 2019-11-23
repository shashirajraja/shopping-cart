package com.shashi.utility;

import javax.mail.MessagingException;

public class MailMessage {
	public static void registrationSuccess(String emailId,String name){
		String recipient = emailId;
		String subject = "Registration Successfull";
		String htmlTextMessage = ""
				+ "<html>"
				+ "<body>"
				+ "<h2 style='color:red;'>Welcome to Ellison Electronics</h2>"
				+ ""
				+ "Hi "+name+","
				+ "<br><br>Thanks for singing up with Ellison Electronics.<br>"
				+ "We are glad that you choose us. We invite you to check out our latest collection of new electonics appliances."
				+ "<br>We are providing upto 60% OFF on most of the electronic gadgets. So please visit our site and explore the collections."
				+ "<br><br>Our Online electronics is growing in a larger amount these days and we are in high demand so we thanks all of you for "
				+ "making us up to that level. We Deliver Product to your house with no extra delivery charges and we also have collection of most of the"
				+ "branded items.<br><br>As a Welcome gift for our New Customers we are providing additional 10% OFF Upto 500 Rs for the first product purchase. "
				+ "<br>To avail this offer you only have "
				+ "to enter the promo code given below.<br><br><br> PROMO CODE: "
				+ "ELLISON500<br><br><br>"
				+ "Have a good day!<br>"
				+ ""
				+ "</body>"
				+ "</html>";
				try {
					JavaMailUtil.sendMail(recipient,subject,htmlTextMessage);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
