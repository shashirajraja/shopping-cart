package com.shashi.beans;

import java.io.InputStream;
import java.io.Serializable;
import java.util.HashSet;

@SuppressWarnings("serial")
public class ProductBean implements Serializable {

	public ProductBean() {
	}

	private String prodId;
	private String prodName;
	private String prodType;
	private String prodInfo;
	private double prodPrice;
	private int prodQuantity;
	private InputStream prodImage;
	private Boolean prodUsed;
	private HashSet<ProductInterest> prodInterests;
	private int currentDiscount;
	
	public ProductBean(String prodId, String prodName, String prodType, String prodInfo, double prodPrice,
			int prodQuantity, InputStream prodImage, Boolean prodUsed, HashSet<ProductInterest> prodInterests) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodType = prodType;
		this.prodInfo = prodInfo;
		this.prodPrice = prodPrice;
		this.prodQuantity = prodQuantity;
		this.prodImage = prodImage;
		this.prodUsed = prodUsed;
		this.prodInterests = prodInterests;
		this.currentDiscount = 0;
	}

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public String getProdInfo() {
		return prodInfo;
	}

	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public InputStream getProdImage() {
		return prodImage;
	}

	public void setProdImage(InputStream prodImage) {
		this.prodImage = prodImage;
	}
	
	public Boolean getProdUsed() {
		return prodUsed;
	}
	
	public void setProdUsed(Boolean prodUsed) {
		this.prodUsed = prodUsed;
	}
	
	public HashSet<ProductInterest> getProdInterests() {
		return prodInterests;
	}
	
	public void setProdInterests(HashSet<ProductInterest> prodInterests) {
		this.prodInterests = prodInterests;
	}
	
	public Boolean hasProdInterest(ProductInterest prodInterest) {
		return prodInterests.contains(prodInterest);
	}
	
	public void setCurrentDiscount(int discountAmount) {
		
		//Clamp discount amount between 0 and 100
		this.currentDiscount = discountAmount > 100? 100 : discountAmount < 0 ? 0 : discountAmount;
	}
	
	public int getCurrentDiscount() {
		return currentDiscount;
	}
	
	public double getCurrentPrice() {
		return (prodPrice * ((100 - currentDiscount) / 100));
	}
	
	public Boolean isDiscounted() {
		return currentDiscount > 0;
	}
}
