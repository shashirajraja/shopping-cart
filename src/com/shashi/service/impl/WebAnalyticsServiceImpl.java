package com.shashi.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

import com.shashi.beans.InteractionBean;
import com.shashi.beans.ProductBean;
import com.shashi.service.WebAnalyticsService;
import com.shashi.utility.DBUtil;

public class WebAnalyticsServiceImpl implements WebAnalyticsService {

    public static void main(String[] args) {
        WebAnalyticsServiceImpl webAnalyticsService = new WebAnalyticsServiceImpl();
        System.out.println(webAnalyticsService.addInteraction("guest@gmail.com", "P20230423083830",1));

    List<ProductBean> forYouProducts = new ArrayList<ProductBean>();
	List<ProductBean> studentSpecials = new ArrayList<ProductBean>();
	List<String> userCategories = new WebAnalyticsServiceImpl().getUserCategories("guest@gmail.com", 0);
	List<String> userStudentCategories = new ArrayList<String>();


    //DEBUG ADDED   
    ProductServiceImpl prodDao = new ProductServiceImpl();
    System.out.println("User Categories: " + userCategories);
	
	if (!userCategories.contains("textbook")){
		for (String category : userCategories) {
			forYouProducts.addAll(prodDao.getAllProductsByType(category));
		}
	}
	else{
		for (String category : userCategories) {
			forYouProducts.addAll(prodDao.getAllProductsByType(category));
		}
		userStudentCategories = new WebAnalyticsServiceImpl().getUserStudentCategories("guest@gmail.com", 0);
        
        //DEBUG ADDED
        System.out.println("User Student Categories: " + userStudentCategories);
		
        for (String category : userStudentCategories) {
			studentSpecials.addAll(prodDao.getProductsByQuality(category, "used"));
		}
	}
	
	//Truncate the lists to max 6 items
	if (forYouProducts.size() > 6) {
		forYouProducts = forYouProducts.subList(0, 6);
	}
	if (studentSpecials.size() > 6) {
		studentSpecials = studentSpecials.subList(0, 6);
	}
    }

    @Override
    public String addInteraction(String userId, String prodId, int weight) {

        String status = "Failed to Add Interaction";
        
        String checkInteractionStatus = checkInteraction(userId, prodId);

        int interactionCount;

        try {
            interactionCount = Integer.parseInt(checkInteractionStatus);
            status += ": " + checkInteractionStatus;
        }
        catch (NumberFormatException e) {
            status += ": " + e.getMessage();
            
            return status;
        }
        
        Connection con = DBUtil.provideConnection();
        

        PreparedStatement ps = null;
        ResultSet rs = null;

        try{

            if (interactionCount == 0) {
                ps = con.prepareStatement("insert into interactions values(?,?,?)");
                ps.setString(1, userId);
                ps.setString(2, prodId);
                ps.setInt(3, weight);
            }

            else {
                ps = con.prepareStatement("update interactions set interactioncount=? where username=? and prodid=?");
                ps.setInt(1, interactionCount + weight);
                ps.setString(2, userId);
                ps.setString(3, prodId);
            }

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                status = "Interaction Added Successfully";
            }

        } catch (SQLException e) {
            status = "Error: " + e.getMessage();
            e.printStackTrace();
        }

        DBUtil.closeConnection(con);
        DBUtil.closeConnection(ps);
        DBUtil.closeConnection(rs);

        return status;
    }


    @Override
    public String checkInteraction(String userId, String prodId) {
        String status = "Failed to Check Interaction";
        
        Connection con = DBUtil.provideConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement("select * from interactions where username=? and prodid=?");

            ps.setString(1, userId);
            ps.setString(2, prodId);

            rs = ps.executeQuery();

            String interactionCount = "0";

            if (rs.next()) {
                
                interactionCount = Integer.toString(rs.getInt("interactioncount"));
                
            }

            status = interactionCount;

        } catch (SQLException e) {
            status = " Error: " + e.getMessage();
            e.printStackTrace();
        }

        DBUtil.closeConnection(con);
        DBUtil.closeConnection(ps);
        DBUtil.closeConnection(rs);
        
        return status;
    }

    @Override
    public List<InteractionBean> getUserInteractions(String userId, int cutoff) {
        String status = "Get User Interactions Failed";

        Connection con = DBUtil.provideConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        List<InteractionBean> interactionList = new ArrayList<InteractionBean>();

        try {

            ps = con.prepareStatement("select * from interactions where username=?");

            ps.setString(1, userId);

            rs = ps.executeQuery();

            if (cutoff == 0) {
                cutoff = Integer.MAX_VALUE;
            }

            int currentResult = 0;
            
            while (rs.next() && currentResult < cutoff) {
                String prodId = rs.getString("prodid");
                int interactionCount = rs.getInt("interactioncount");
                InteractionBean interaction = new InteractionBean(userId, prodId, interactionCount);
                
                interactionList.add(interaction);
                currentResult++;
            }

            if (interactionList.size() > 0){
                status = "Get User Interactions Successful";
            }
            else {
                status = "No Interactions Found";
            }

        } catch (SQLException e) {
            status = "Error: " + e.getMessage();
            e.printStackTrace();
        }

        DBUtil.closeConnection(con);
        DBUtil.closeConnection(ps);
        DBUtil.closeConnection(rs);

        return interactionList;
    }    


    @Override
    public List<String> getUserCategories(String userId, int cutoff) {
        String status = "Get User Interactions Failed";

        Connection con = DBUtil.provideConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        List<String> catagoryList = new ArrayList<String>();

        try {

            ps = con.prepareStatement(
                "SELECT p.ptype, SUM(i.interactioncount) AS totalinteractions " +
                    "FROM `shopping-cart`.`interactions` AS i " + 
                    "JOIN `shopping-cart`.`product` AS p ON i.prodid = p.pid " +
                    "WHERE i.username=? " + 
                    "GROUP BY p.ptype " +
                    "ORDER BY SUM(i.interactioncount) DESC");

            ps.setString(1, userId);

            rs = ps.executeQuery();

            if (cutoff == 0) {
                cutoff = Integer.MAX_VALUE;
            }

            int currentResult = 0;
            
            while (rs.next() && currentResult < cutoff) {
                catagoryList.add(rs.getString("ptype"));
                currentResult++;
            }

            if (catagoryList.size() > 0){
                status = "Get User Catagories Successful";
            }
            else {
                status = "No Catagories Found";
            }

        } catch (SQLException e) {
            status = "Error: " + e.getMessage();
            e.printStackTrace();
        }

        DBUtil.closeConnection(con);
        DBUtil.closeConnection(ps);
        DBUtil.closeConnection(rs);

        return catagoryList;
    }

    @Override
    public List<String> getUserStudentCategories(String userId, int cutoff) {
        String status = "Get User Interactions Failed";

        Connection con = DBUtil.provideConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;

        List<String> catagoryList = new ArrayList<String>();

        try {

            ps = con.prepareStatement(
                "SELECT p.ptype, SUM(i.interactioncount) AS totalinteractions " +
                    "FROM `shopping-cart`.`interactions` AS i " + 
                    "JOIN `shopping-cart`.`product` AS p ON i.prodid = p.pid " +
                    "WHERE i.username=? AND p.ptype IN ('mobile','textbook','tablet') " +
                    "GROUP BY p.ptype " +
                    "ORDER BY SUM(i.interactioncount) DESC");

            ps.setString(1, userId);

            rs = ps.executeQuery();

            if (cutoff == 0) {
                cutoff = Integer.MAX_VALUE;
            }

            int currentResult = 0;
            
            while (rs.next() && currentResult < cutoff) {
                catagoryList.add(rs.getString("ptype"));
                currentResult++;
            }

            if (catagoryList.size() > 0){
                status = "Get User Student Catagories Successful";
            }
            else {
                status = "No Student Catagories Found";
            }

        } catch (SQLException e) {
            status = "Error: " + e.getMessage();
            e.printStackTrace();
        }

        DBUtil.closeConnection(con);
        DBUtil.closeConnection(ps);
        DBUtil.closeConnection(rs);

        return catagoryList;
    }

}
