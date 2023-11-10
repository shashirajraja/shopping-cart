package com.shashi.beans;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class CartBeanTest {

    @Test
    public void testUserId() {
        CartBean cartBean = new CartBean();
        String userId = "user123";
        cartBean.setUserId(userId);
        assertEquals(userId, cartBean.getUserId());
    }

    @Test
    public void testProdId() {
        CartBean cartBean = new CartBean();
        String prodId = "product123";
        cartBean.setProdId(prodId);
        assertEquals(prodId, cartBean.getProdId());
    }

    @Test
    public void testQuantity() {
        CartBean cartBean = new CartBean();
        int quantity = 5;
        cartBean.setQuantity(quantity);
        assertEquals(quantity, cartBean.getQuantity());
    }

    @Test
    public void testConstructor() {
        String userId = "user123";
        String prodId = "product123";
        int quantity = 5;

        CartBean cartBean = new CartBean(userId, prodId, quantity);

        assertEquals(userId, cartBean.getUserId());
        assertEquals(prodId, cartBean.getProdId());
        assertEquals(quantity, cartBean.getQuantity());
    }

    // Additional tests for edge cases or error conditions can be added
}
