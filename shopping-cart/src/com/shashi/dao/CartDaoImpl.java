package com.shashi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shashi.beans.CartBean;
import com.shashi.utility.DBUtil;

public class CartDaoImpl implements CartDao{

	@Override
	public String addProductToCart(String userId, String prodId) {
		String status= "Failed to Add into Cart";
		
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement("select * from usercart where username=? and prodid=?");
			
			ps.setString(1, userId);
			ps.setString(2, prodId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int prodQuantity = rs.getInt("quantity");
				
				prodQuantity += 1;
				
				ps2 = con.prepareStatement("update usercart set quantity=? where username=? and prodid=?");
				
				ps2.setInt(1, prodQuantity);
				
				ps2.setString(2, userId);
				
				ps2.setString(3, prodId);
				
				int k = ps2.executeUpdate();
				
				if(k>0) 
					status  = "Product Successfully Added to Cart!";
				
			}
			else {
				
				ps2 = con.prepareStatement("insert into usercart values(?,?,?)");
				
				ps2.setString(1, userId);
				
				ps2.setString(2, prodId);
				
				ps2.setInt(3, 1);
				
				int k = ps2.executeUpdate();
				
				if(k>0)
					status = "Product Successfully Added to Cart!";
				
			}
			
		} catch (SQLException e) {
				status = "Error: "+ e.getMessage();
			e.printStackTrace();
		}
		
		
		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);
		DBUtil.closeConnection(ps2);
		
		return status;
	}

	@Override
	public List<CartBean> getAllCartItems(String userId) {
		List<CartBean> items = new ArrayList<CartBean>();
		
		Connection con  = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement("select * from usercart where username=?");
			
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CartBean cart = new CartBean();
				
				cart.setUserId(rs.getString("username"));
				cart.setProdId(rs.getString("prodid"));
				cart.setQuantity(Integer.parseInt(rs.getString("quantity")));
				
				items.add(cart);
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);
		
		
		return items;
	}

	@Override
	public int getCartCount(String userId) {
		int count = 0;
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("select sum(quantity) from usercart where username=?");
			
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) 
				count = rs.getInt(1);
			
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);
		
		return count;
	}

	@Override
	public String removeProductFromCart(String userId, String prodId) {
		String status = "Product Removal Failed";
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement("select * from usercart where username=? and prodid=?");
			
			ps.setString(1, userId);
			ps.setString(2, prodId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				int prodQuantity = rs.getInt("quantity");
				
				prodQuantity -= 1;
				
				if(prodQuantity>0) {
					ps2 = con.prepareStatement("update usercart set quantity=? where username=? and prodid=?");
					
					ps2.setInt(1, prodQuantity);
					
					ps2.setString(2, userId);
					
					ps2.setString(3, prodId);
					
					int k = ps2.executeUpdate();
					
					if(k>0) 
						status  = "Product Successfully Added to Cart!";
				}
				else if(prodQuantity <=0) {
					
					ps2 = con.prepareStatement("delete from usercart where username=? and prodid=?");
					
					ps2.setString(1, userId);
					
					ps2.setString(2, prodId);
					
					int k = ps2.executeUpdate();
					
					if(k>0) 
						status  = "Product Successfully Added to Cart!";
				}

			}
			else {
				
					status = "Product Not Available in the cart!";
				
			}
			
		} catch (SQLException e) {
				status = "Error: "+ e.getMessage();
			e.printStackTrace();
		}
		
		
		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);
		DBUtil.closeConnection(ps2);
		
		
		return status;
	}
}
