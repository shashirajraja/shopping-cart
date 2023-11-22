package com.shashi.beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CartBean implements Serializable {

	public CartBean() {
	}

	public String studentId;

	public String prodId;

	public int quantity;

	public String getUserId() {
		return studentId;
	}

	public void setUserId(String userId) {
		this.studentId = userId;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public CartBean(String userId, String prodId, int quantity) {
		super();
		this.studentId = userId;
		this.prodId = prodId;
		this.quantity = quantity;
	}

}
