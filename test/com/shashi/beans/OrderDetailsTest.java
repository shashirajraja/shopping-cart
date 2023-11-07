package com.shashi.beans;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderDetailsTest {

    private OrderDetails orderDetails;

    @BeforeEach
    public void setUp() {
        orderDetails = new OrderDetails();
    }

    @Test
    public void testGetSetOrderId() {
        orderDetails.setOrderId("testOrderId");
        assertEquals("testOrderId", orderDetails.getOrderId());
    }

    @Test
    public void testGetSetProdName() {
        orderDetails.setProdName("testProdName");
        assertEquals("testProdName", orderDetails.getProdName());
    }

    @Test
    public void testGetSetQty() {
        orderDetails.setQty("2");
        assertEquals("2", orderDetails.getQty());
    }

    @Test
    public void testGetSetAmount() {
        orderDetails.setAmount("20.00");
        assertEquals("20.00", orderDetails.getAmount());
    }

    @Test
    public void testGetSetTime() {
        Timestamp timestamp = Timestamp.valueOf("2023-11-05 14:30:00");
        orderDetails.setTime(timestamp);
        assertEquals(timestamp, orderDetails.getTime());
    }

    @Test
    public void testGetSetProdImage() {
        // Assuming you have an InputStream to set
        InputStream inputStream = null;
        orderDetails.setProdImage(inputStream);
        assertEquals(inputStream, orderDetails.getProdImage());
    }

    @Test
    public void testGetSetProductId() {
        orderDetails.setProductId("testProductId");
        assertEquals("testProductId", orderDetails.getProductId());
    }

    @Test
    public void testGetSetShipped() {
        orderDetails.setShipped(1);
        assertEquals(1, orderDetails.getShipped());
    }
}
