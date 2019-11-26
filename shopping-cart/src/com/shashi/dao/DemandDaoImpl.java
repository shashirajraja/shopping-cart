package com.shashi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shashi.beans.DemandBean;
import com.shashi.utility.DBUtil;

public class DemandDaoImpl implements DemandDao{

	@Override
	public boolean addProduct(String userId, String prodId, int demandQty) {
		boolean flag = false;
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("select * from user_demand where username=? and prodid=?");
			
			ps.setString(1, userId);
			ps.setString(2, prodId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				flag = true;
			}
			else {
				ps2 = con.prepareStatement("insert into  user_demand values(?,?,?)");
				
				ps2.setString(1, userId);
				
				ps2.setString(2, prodId);
				
				ps2.setInt(3, demandQty);
				
				int k = ps2.executeUpdate();
				
				if(k>0)
					flag = true;
			}
			
			
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		
		
		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(ps2);
		DBUtil.closeConnection(rs);
		
		return flag;
	}

	@Override
	public boolean removeProduct(String userId, String prodId) {
		boolean flag = false;
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("select * from user_demand where username=? and prodid=?");
			
			ps.setString(1, userId);
			ps.setString(2, prodId);
			
			rs = ps.executeQuery();
			
			//System.out.println("userId "+userId+"\nprodId: "+prodId);
			
			if(rs.next()) {
				
				//System.out.println("userId "+userId+"\nprodId: "+prodId);
				ps2 = con.prepareStatement("delete from  user_demand where username=? and prodid=?");
				
				ps2.setString(1, userId);
				
				ps2.setString(2, prodId);
							
				int k = ps2.executeUpdate();
				
				if(k>0)
					flag = true;
				
			}
			else {
				flag = true;
			}
			
			
		} catch (SQLException e) {
			flag = false;
			e.printStackTrace();
		}
		
		
		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(ps2);
		DBUtil.closeConnection(rs);
		
		return flag;
	}

	@Override
	public boolean addProduct(DemandBean userDemandBean) {
		
		return addProduct(userDemandBean.getUserName(),userDemandBean.getProdId(),userDemandBean.getDemandQty());
	}

	@Override
	public List<DemandBean> haveDemanded(String prodId) {
		List<DemandBean> demandList = new ArrayList<DemandBean>();
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			ps = con.prepareStatement("select * from user_demand where prodid=?");
			ps.setString(1, prodId);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				DemandBean demand = new DemandBean(rs.getString("username"),rs.getString("prodid"),rs.getInt("quantity"));
				
				demandList.add(demand);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return demandList;
	}

}
