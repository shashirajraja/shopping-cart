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
	public static void transactionSuccess(String recipientEmail,String name,String transId,double transAmount) {
		String recipient = recipientEmail;
		String subject = "Order Placed at Ellison Electronics";
		String htmlTextMessage = 
				"<html>" + 
				"  <body>" + 
				"    <p>" + 
				"      Hey "+name+",<br/><br/>" + 
				"      We are glad that you shop with Ellison Electronics!" + 
				"      <br/><br/>" + 
				"      Your order has been placed successfully and under process to be shipped."
				+ 		"<br/><h6>Please Note that this is a demo projet Email and you have not made any real transaction with us till now!</h6>" + 
				"      <br/>" + 
				"      Here is Your Transaction Details:<br/>" + 
				"      <br/>" + 
				"      <font style=\"color:red;font-weight:bold;\">Order Id:</font>" + 
				"      <font style=\"color:green;font-weight:bold;\">"+transId+"</font><br/>" + 
				"      <br/>" + 
				"      <font style=\"color:red;font-weight:bold;\">Amount Paid:</font> <font style=\"color:green;font-weight:bold;\">"+transAmount+"</font>" + 
				"      <br/><br/>" + 
				"      Thanks for shopping with us!<br/><br/>" + 
				"      Come Shop Again! <br/<br/> <font style=\"color:green;font-weight:bold;\">Ellison Electronics.</font>" + 
				"    </p>" + 
				"    " + 
				"  </body>" + 
				"</html>";
		
		try {
			JavaMailUtil.sendMail(recipient,subject,htmlTextMessage);
		}
		catch(MessagingException e) {
			e.printStackTrace();
		}
	}
	
	public static void productAvailableNow(String recipientEmail,String name,String prodName, String prodId) {
		String recipient = recipientEmail;
		String subject = "Product "+prodName+" is Now Available at Ellison Electronics";
		String htmlTextMessage = 
				"<html>" + 
				"  <body>" + 
				"    <p>" + 
				"      Hey "+name+",<br/><br/>" + 
				"      We are glad that you shop with Ellison Electronics!" + 
				"      <br/><br/>" + 
				"      As per your recent browsing history, we seen that you were searching for an item that was not available in sufficient amount"
				+ " at that time. <br/><br/>"
				+ "We are glad to say that the product named <font style=\"color:green;font-weight:bold;\">"+prodName+"</font> with "
						+ "product Id <font style=\"color:green;font-weight:bold;\">"+prodId+"</font> is now available to shop in our store!"
				+ 		"<br/><h6>Please Note that this is a demo projet Email and you have not made any real transaction with us and not ordered anything till now!</h6>" + 
				"      <br/>" + 
				"      Here is The product detail which is now available to shop:<br/>" + 
				"      <br/>" + 
				"      <font style=\"color:red;font-weight:bold;\">Product Id: </font><font style=\"color:green;font-weight:bold;\">" +prodId+" "+
				"      </font><br/>" + 
				"      <br/>" + 
				"      <font style=\"color:red;font-weight:bold;\">Product Name: </font> <font style=\"color:green;font-weight:bold;\">"+prodName+"</font>" + 
				"      <br/><br/>" + 
				"      Thanks for shopping with us!<br/><br/>" + 
				"      Come Shop Again! <br/<br/><br/> <font style=\"color:green;font-weight:bold;\">Ellison Electronics.</font>" + 
				"    </p>" + 
				"    " + 
				"  </body>" + 
				"</html>";
		
		try {
			JavaMailUtil.sendMail(recipient,subject,htmlTextMessage);
		}
		catch(MessagingException e) {
			e.printStackTrace();
		}
	}
	
	
}
