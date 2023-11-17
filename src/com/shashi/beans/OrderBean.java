package com.shashi.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class OrderBean implements Serializable {

	private String transactionId;
	private String productId;
	private int quantity;
	private Double amount;
	private int shipped;
	private String sellerId;
	private String studentId;
	//productsBought <Array> will be in order service
	private String status;

	public OrderBean() {
		super();
	}

	public OrderBean(String transactionId, String productId, int quantity, Double amount, String sellerId, String studentId, String status) {
		super();
		this.transactionId = transactionId;
		this.productId = productId;
		this.quantity = quantity;
		this.amount = amount;
		this.shipped = 0;
		this.sellerId = sellerId;
		this.studentId = studentId;
		this.status = status;
	}

	public OrderBean(String transactionId, String productId, int quantity, Double amount, int shipped, String sellerId, String studentId, String status) {
		super();
		this.transactionId = transactionId;
		this.productId = productId;
		this.quantity = quantity;
		this.amount = amount;
		this.shipped = shipped;
		this.sellerId = sellerId;
		this.studentId = studentId;
		this.status = status;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getShipped() {
		return shipped;
	}

	public void setShipped(int shipped) {
		this.shipped = shipped;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String StudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
