package com.shashi.service.impl;

import com.shashi.beans.OrderBean;
import com.shashi.beans.OrderDetails;
import com.shashi.beans.TransactionBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceImplTest {

    private OrderServiceImpl orderService;

    @BeforeEach
    public void setUp() {
        orderService = new OrderServiceImpl();
    }

    @Test
    public void testAddTransaction() {
        TransactionBean transaction = new TransactionBean("testTransactionId", "testUser", new Timestamp(System.currentTimeMillis()), 100.0);
        assertTrue(orderService.addTransaction(transaction));
    }

    @Test
    public void testCountSoldItem() {
        int count = orderService.countSoldItem("testProductId");
        assertEquals(0, count);
    }

    @Test
    public void testGetAllOrders() {
        List<OrderBean> orderList = orderService.getAllOrders();
        assertNotNull(orderList);
    }

    @Test
    public void testGetOrdersByUserId() {
        List<OrderBean> orderList = orderService.getOrdersByUserId("testUser");
        assertNotNull(orderList);
    }

    @Test
    public void testGetAllOrderDetails() {
        List<OrderDetails> orderList = orderService.getAllOrderDetails("testUser");
        assertNotNull(orderList);
    }

    @Test
    public void testShipNow() {
        String status = orderService.shipNow("testOrderId", "testProductId");
        assertEquals("FAILURE", status);
    }
}
