package com.shashi.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shashi.beans.ProductBean;
import com.shashi.utility.DBUtil;
import com.shashi.utility.IDUtil;

public class ProductDaoImpl implements ProductDao{

	@Override
	public String addProduct(String prodName, String prodType, String prodInfo, double prodPrice, int prodQuantity,
			InputStream prodImage) {
		String status = null;
		String prodId = IDUtil.generateId();
		
		ProductBean product = new ProductBean(prodId, prodName, prodType, prodInfo, prodPrice, prodQuantity, prodImage);
		
		
		status = addProduct(product);
		
		return status;
	}

	@Override
	public String addProduct(ProductBean product) {
		String status = "Product Registration Failed!";
		
		if(product.getProdId()==null)
			product.setProdId(IDUtil.generateId());
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("insert into product values(?,?,?,?,?,?,?);");
			ps.setString(1, product.getProdId());
			ps.setString(2, product.getProdName());
			ps.setString(3, product.getProdType());
			ps.setString(4, product.getProdInfo());
			ps.setDouble(5, product.getProdPrice());
			ps.setInt(6,product.getProdQuantity());
			ps.setBlob(7, product.getProdImage());
			
			int k = ps.executeUpdate();
			
			if(k>0) {
			
				status = "Product Added Successfully with Product Id: "+product.getProdId(); 

			}
			else {
				
				status = "Product Updation Failed!";
			}
			
		} catch (SQLException e) {
			status = "Error: "+e.getMessage();
			e.printStackTrace();
		}
		
		
		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		
		return status;
	}

	@Override
	public String removeProduct(String prodId) {
		String status = "Product Removal Failed!";
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("delete from product where pid=?");
			ps.setString(1, prodId);
			
			int k = ps.executeUpdate();
			
			if(k>0)
				status = "Product Removed Successfully!";
			
		} catch (SQLException e) {
			status = "Error: "+e.getMessage();
			e.printStackTrace();
		}
	
		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		
		return status;
	}

	@Override
	public String updateProduct(ProductBean prevProduct, ProductBean updatedProduct) {
		String status = "Product Updation Failed!";
		
		if(!prevProduct.getProdId().equals(updatedProduct.getProdId())) {
			
			status = "Both Products are Different, Updation Failed!";
			
			return status;
		}
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("update product set pname=?,ptype=?,pinfo=?,pprice=?,pquantity=?,image=? where pid=?");
			
			ps.setString(1, updatedProduct.getProdName());
			ps.setString(2, updatedProduct.getProdType());
			ps.setString(3, updatedProduct.getProdInfo());
			ps.setDouble(4, updatedProduct.getProdPrice());
			ps.setInt(5, updatedProduct.getProdQuantity());
			ps.setBlob(6, updatedProduct.getProdImage());
			ps.setString(7, prevProduct.getProdId());
			
			int k = ps.executeUpdate();
			
			if(k>0)
				status = "Product Updated Successfully!";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		
		return status;
	}

	@Override
	public String updateProductPrice(String prodId, double updatedPrice) {
		String status = "Price Updation Failed!";
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		
		try {
			ps = con.prepareStatement("update product set pprice=? where pid=?");
			
			ps.setDouble(1, updatedPrice);
			ps.setString(2, prodId);
			
			int k = ps.executeUpdate();
			
			if(k>0)
				status = "Price Updated Successfully!";
		} catch (SQLException e) {
			status = "Error: "+e.getMessage();
			e.printStackTrace();
		}
		
		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		
		return status;
	}

	@Override
	public List<ProductBean> getAllProducts() {
		List<ProductBean> products = new ArrayList<ProductBean>();
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("select * from product");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ProductBean product = new ProductBean();
				
				product.setProdId(rs.getString(1));
				product.setProdName(rs.getString(2));
				product.setProdType(rs.getString(3));
				product.setProdInfo(rs.getString(4));
				product.setProdPrice(rs.getDouble(5));
				product.setProdQuantity(rs.getInt(6));
				product.setProdImage(rs.getAsciiStream(7));
				
				products.add(product);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);
		
		return products;
	}

	@Override
	public byte[] getImage(String prodId) {
		byte[] image = null;
		
		Connection con = DBUtil.provideConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = con.prepareStatement("select image from product where  pid=?");
			
			ps.setString(1, prodId);
			
			rs = ps.executeQuery();
			
			if(rs.next())
				image = rs.getBytes("image");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DBUtil.closeConnection(con);
		DBUtil.closeConnection(ps);
		DBUtil.closeConnection(rs);
		
		return image;
	}

}
