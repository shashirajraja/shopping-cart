package com.shashi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shashi.utility.DBUtil;

public class TransDaoImpl implements TransDao{

	@Override
	public String getUserId(String transId) {
		String userId = "";
		
		Connection con = DBUtil.provideConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement("select username from transactions where transid=?");
			
			ps.setString(1, transId);
			
			rs = ps.executeQuery();
			
			if(rs.next())
				userId = rs.getString(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
		
		return userId;
	}

}
