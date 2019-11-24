package com.shashi.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shashi.beans.CartBean;
import com.shashi.beans.OrderBean;
import com.shashi.beans.TransactionBean;
import com.shashi.beans.UserBean;
import com.shashi.utility.DBUtil;
import com.shashi.utility.MailMessage;

public class OrderDaoImpl implements OrderDao{

	@Override
	public String paymentSuccess(String userName,double paidAmount) {
		String status = "Order Placement Failed!";
		
		
		List<CartBean> cartItems = new ArrayList<CartBean>();
		cartItems = new CartDaoImpl().getAllCartItems(userName);
		
		if(cartItems.size()==0)
				return status;
		
		
		TransactionBean transaction = new TransactionBean(userName,paidAmount) ;
		
		
		PreparedStatement ps1 = null;
		//PreparedStatement ps2 = null;
		int p=0,q=0,k=0;
		boolean flag = false;
		
		String transactionId = transaction.getTransactionId();
		
		if(transaction != null) {
			//System.out.println("Transaction: "+transaction.getTransactionId()+" "+transaction.getTransAmount()+" "+transaction.getUserName()+" "+transaction.getTransDateTime());
			
			for(CartBean item : cartItems) {
				
				double amount = new ProductDaoImpl().getProductPrice(item.getProdId()) * item.getQuantity(); 
				
				OrderBean order = new OrderBean(transactionId, item.getProdId(), item.getQuantity(), amount);
				
				flag = new OrderDaoImpl().addOrder(order);
				if(!flag)
					break;
				else {
					flag = new CartDaoImpl().removeAProduct(item.getUserId(), item.getProdId());
				}
				
				if(!flag)
					break;
				else
					flag = new ProductDaoImpl().sellNProduct(item.getProdId(), item.getQuantity());
				
				if(!flag)
					break;
			}
			
			if(flag) {
				flag = new OrderDaoImpl().addTransaction(transaction);
				if(flag) {
					
					MailMessage.transactionSuccess(userName, new UserDaoImpl().getFName(userName), transaction.getTransactionId(), transaction.getTransAmount());
					
					status = "Order Placed Successfully!";
				}
			}
			
		}
		
		
		return status;
	}

	@Override
	public boolean addOrder(OrderBean order) {
		boolean flag= false;
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("insert into orders values(?,?,?,?)");
			
			ps.setString(1, order.getTransactionId());
			ps.setString(2, order.getProductId());
			ps.setInt(3, order.getQuantity());
			ps.setDouble(4, order.getAmount());
			
			int k = ps.executeUpdate();
			
			if(k>0)
				flag = true;
			
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		
		
		
		return flag;
	}

	@Override
	public boolean addTransaction(TransactionBean transaction) {
		boolean flag = false;
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("insert into transactions values(?,?,?,?)");
			
			ps.setString(1, transaction.getTransactionId());
			ps.setString(2, transaction.getUserName());
			ps.setTimestamp(3, transaction.getTransDateTime());
			ps.setDouble(4, transaction.getTransAmount());
			
			int k = ps.executeUpdate();
			
			if(k>0)
				flag = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}

}
