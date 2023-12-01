package com.shashi.service.impl;

import com.shashi.utility.DBUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DemandServiceImplTest {

    @Test
    void addProduct() {
        Connection con = DBUtil.provideConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        DemandServiceImpl demandService = new DemandServiceImpl();
        demandService.addProduct("1111", "1111", 2);
        try{
            ps = con.prepareStatement("select * from user_demand where username=? and prodid=?");

            ps.setString(1, "1111");
            ps.setString(2, "1111");
            rs = ps.executeQuery();
            if(rs.next()){
                assertEquals("1111", rs.getString("username"));
                assertEquals("1111", rs.getString("prodid"));
                assertEquals(2, rs.getInt("demandQty"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(con);
        DBUtil.closeConnection(ps);
        DBUtil.closeConnection(rs);
    }

    @Test
    void removeProduct() {
        Connection con = DBUtil.provideConnection();

        PreparedStatement ps = null;
        ResultSet rs = null;
        DemandServiceImpl demandService = new DemandServiceImpl();
        demandService.addProduct("1111", "1111", 2);
        try{
            ps = con.prepareStatement("select * from user_demand where username=? and prodid=?");

            ps.setString(1, "1111");
            ps.setString(2, "1111");
            rs = ps.executeQuery();

            //no result of the query
            assertNotEquals(true, rs.next());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.closeConnection(con);
        DBUtil.closeConnection(ps);
        DBUtil.closeConnection(rs);
    }

}