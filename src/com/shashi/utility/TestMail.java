package com.shashi.utility;

import jakarta.mail.MessagingException;

public class TestMail {
	public static void main(String[] args) {
		try {
			String recipient = "ellison.alumni@gmail.com";
			String subject = "Mail Configuration Successfull";
			String htmlTextMessage = "" + "<html>"
					+ "<head><title>Java Mail Configuration Test</title><style>.greenText{color:green;} p{font-size:14;}</style></head><body>"
					+ "<h2 style='color:red;'>Welcome to Ellison Electronics</h2>" + "<p>Hey,<br>"
					+ "Thanks for singing up with Ellison Electronics.<br>"
					+ "We are glad that you choose <bold>us. We invite you to check out our latest collection of new electonics appliances."
					+ "<br>We are providing upto 60% OFF on most of the electronic gadgets. So please visit our site and explore the collections. <br>"
					+ " <br>Our Online electronics is growing in a larger amount these days and we are in high demand so we thanks all of you for "
					+ "making us up to that level. We Deliver Product to your house with no extra delivery charges and we also have collection of most of the"
					+ "branded items. As a Welcome gift for our New Customers we are providing additional 10% OFF Upto 500 Rs for the first product purchase. To avail this offer you only have "
					+ "to enter the promo code given below.<br><br> PROMO CODE: "
					+ "<span class='greenText'>ELLISON500</span><br><br>" + "Have a good day!<br>" + "</p>" + "</body>"
					+ "</html>";
			JavaMailUtil.sendMail(recipient, subject, htmlTextMessage);
			System.out.println("Mail Sent Successfully!");

		} catch (MessagingException e) {
			System.out.println("Mail Sending Failed With Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
