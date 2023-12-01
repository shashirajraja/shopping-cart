package com.shashi.beans;

import java.io.InputStream;
import java.io.Serializable;

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
	private String prodQuality;
	private int prodSold;
	private int prodDiscount;

	public ProductBean(String prodId, String prodName, String prodType, String prodInfo, double prodPrice,
			int prodQuantity, InputStream prodImage, String prodQuality, int prodDiscount) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.prodType = prodType;
		this.prodInfo = prodInfo;
		this.prodPrice = prodPrice;
		this.prodQuantity = prodQuantity;
		this.prodImage = prodImage;
		this.prodQuality = prodQuality;
		this.prodSold = 0;
		this.prodDiscount = prodDiscount;
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
	
	public String getProdQuality()
	{
		return this.prodQuality;
	}
	
	public int getProdSold()
	{
		return this.prodSold;
	}
	
	public int getProdDiscount()
	{
		return this.prodDiscount;
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
	
	public void setProdQuality(String prodQuality) // either 'new' or 'used;
	{
		this.prodQuality = prodQuality;
	}
	
	public void setProdSold(int sold)
	{
		this.prodSold = sold;
	}
	
	public void setProdDiscount(int discount)
	{
		this.prodDiscount = discount;
	}

}
