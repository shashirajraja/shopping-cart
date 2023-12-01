package com.shashi.service.impl;

import com.shashi.utility.DBUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CartServiceImplTest {

    @Test
    void addProductToCart() {
        Connection con = DBUtil.provideConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        CartServiceImpl cartService = new CartServiceImpl();
        cartService.addProductToCart("1111", "1111", 1);
        try{
            ps = con.prepareStatement("select * from usercart where username=? and prodid=?");

            ps.setString(1, "1111");
            ps.setString(2, "1111");
            rs = ps.executeQuery();
            if(rs.next()){
                assertEquals("1111", rs.getString("username"));
                assertEquals("1111", rs.getString("prodid"));
                assertEquals(cartService.getCartItemCount("1111","1111")+1, rs.getInt("quantity"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(con);
        DBUtil.closeConnection(ps);
        DBUtil.closeConnection(rs);

    }

    @Test
    void removeProductFromCart() {
        Connection con = DBUtil.provideConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        CartServiceImpl cartService = new CartServiceImpl();
        cartService.removeProductFromCart("1111", "1111");
        try{
            ps = con.prepareStatement("select * from usercart where username=? and prodid=?");

            ps.setString(1, "1111");
            ps.setString(2, "1111");
            rs = ps.executeQuery();
            if(rs.next()){
                assertEquals("1111", rs.getString("username"));
                assertEquals("1111", rs.getString("prodid"));
                assertEquals(cartService.getProductCount("1111","1111")-1, rs.getInt("quantity"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(con);
        DBUtil.closeConnection(ps);
        DBUtil.closeConnection(rs);
    }

    @Test
    void updateProductToCart() {
        Connection con = DBUtil.provideConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        CartServiceImpl cartService = new CartServiceImpl();
        cartService.updateProductToCart("1111", "1111", 2);
        try{
            ps = con.prepareStatement("select * from usercart where username=? and prodid=?");

            ps.setString(1, "1111");
            ps.setString(2, "1111");
            rs = ps.executeQuery();
            if(rs.next()){
                assertEquals("1111", rs.getString("username"));
                assertEquals("1111", rs.getString("prodid"));
                assertEquals(2, rs.getInt("quantity"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(con);
        DBUtil.closeConnection(ps);
        DBUtil.closeConnection(rs);

    }
}