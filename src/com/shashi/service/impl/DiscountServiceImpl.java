package com.shashi.service.impl;

import com.shashi.beans.ProductBean;
import com.shashi.service.DiscountService;

public class DiscountServiceImpl implements DiscountService {

	@Override
	public void getBestSellingByInterest() {

		//TODO ?
	}

	@Override
	public void checkInStock(ProductBean product) {

		//TODO ?
	}

	@Override
	public void addDiscount(ProductBean product, int discountAmount) {

		product.setCurrentDiscount(discountAmount);
	}

	@Override
	public void removeDiscount(ProductBean product) {

		product.setCurrentDiscount(0);
	}

	@Override
	public void displayDiscount(ProductBean product) {

		//TODO ?
	}

	@Override
	public void displayAdminSuggestions() {

		//TODO ?
	}

}
