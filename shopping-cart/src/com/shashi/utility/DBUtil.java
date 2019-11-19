package com.shashi.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBUtil {
	private static Connection  conn;
	
	static ResourceBundle rb = ResourceBundle.getBundle("com.shashi.utility.database");
	
	public  DBUtil() {}
	
	public static Connection provideConnection() {
		
		
		try {
			if(conn== null || conn.isClosed()) {
				
				try {
					Class.forName(rb.getString("driverName"));
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				conn = DriverManager.getConnection(rb.getString("connectionString"),rb.getString("username"),rb.getString("password"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return conn;
	}
	
	
	
	public static void closeConnection(Connection con) {
		try {
			if(con!=null && !con.isClosed()) {
				
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void closeConnection(ResultSet rs) {
		try {
			if(rs!=null && !rs.isClosed()) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void closeConnection(PreparedStatement ps) {
		try {
			if(ps != null &&  !ps.isClosed()) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
