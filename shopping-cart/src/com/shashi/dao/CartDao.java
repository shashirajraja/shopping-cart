package com.shashi.dao;

import java.util.List;

import com.shashi.beans.CartBean;

public interface CartDao{
		
	public String addProductToCart(String userId, String prodId);
	
	public List<CartBean> getAllCartItems(String userId);
	
	public int getCartCount(String userId);
}
