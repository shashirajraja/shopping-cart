import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OrderServiceTest {

    @InjectMocks
    private OrderServiceImpl orderService;

    @Mock
    private OrderRepository orderRepository; // Assuming the existence of an OrderRepository interface or class

    @Mock
    private TransactionRepository transactionRepository; // Assuming the existence of a TransactionRepository interface or class

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPaymentSuccess() {
        String userName = "user123";
        double paidAmount = 100.0;

        when(transactionRepository.addTransaction(any(TransactionBean.class))).thenReturn(true);

        String result = orderService.paymentSuccess(userName, paidAmount);

        assertEquals("Payment successful", result);
    }

    @Test
    public void testAddOrder() {
        OrderBean order = new OrderBean(/* your order details */);

        when(orderRepository.addOrder(order)).thenReturn(true);

        boolean result = orderService.addOrder(order);

        assertTrue(result);
    }

    @Test
    public void testAddTransaction() {
        TransactionBean transaction = new TransactionBean(/* your transaction details */);

        when(transactionRepository.addTransaction(transaction)).thenReturn(true);

        boolean result = orderService.addTransaction(transaction);

        assertTrue(result);
    }

    @Test
    public void testCountSoldItem() {
        String prodId = "prod456";

        when(orderRepository.countSoldItem(prodId)).thenReturn(5);

        int result = orderService.countSoldItem(prodId);

        assertEquals(5, result);
    }

    @Test
    public void testGetAllOrders() {
        List<OrderBean> orders = new ArrayList<>();
        orders.add(new OrderBean(/* order details */));
        orders.add(new OrderBean(/* order details */));

        when(orderRepository.getAllOrders()).thenReturn(orders);

        List<OrderBean> result = orderService.getAllOrders();

        assertEquals(orders, result);
    }

    @Test
    public void testGetOrdersByUserId() {
        String emailId = "user@example.com";

        List<OrderBean> orders = new ArrayList<>();
        orders.add(new OrderBean(/* order details */));
        orders.add(new OrderBean(/* order details */));

        when(orderRepository.getOrdersByUserId(emailId)).thenReturn(orders);

        List<OrderBean> result = orderService.getOrdersByUserId(emailId);

        assertEquals(orders, result);
    }

    @Test
    public void testGetAllOrderDetails() {
        String userEmailId = "user@example.com";

        List<OrderDetails> orderDetailsList = new ArrayList<>();
        orderDetailsList.add(new OrderDetails(/* order details */));
        orderDetailsList.add(new OrderDetails(/* order details */));

        when(orderRepository.getAllOrderDetails(userEmailId)).thenReturn(orderDetailsList);

        List<OrderDetails> result = orderService.getAllOrderDetails(userEmailId);

        assertEquals(orderDetailsList, result);
    }

    @Test
    public void testShipNow() {
        String orderId = "order123";
        String prodId = "prod456";

        when(orderRepository.shipNow(orderId, prodId)).thenReturn("Product shipped successfully");

        String result = orderService.shipNow(orderId, prodId);

        assertEquals("Product shipped successfully", result);
    }
}

