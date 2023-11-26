package com.shashi.service;

import com.shashi.beans.ProductBean;

public interface DiscountService {
	
	public void getBestSellingByInterest();
	
	public void checkInStock(ProductBean product);
	
	public void addDiscount(ProductBean product, int discountAmount);
	
	public void removeDiscount(ProductBean product);
	
	public void displayDiscount(ProductBean product);
	
	public void displayAdminSuggestions();
}
