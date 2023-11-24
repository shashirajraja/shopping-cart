package test.java;

import com.shashi.beans.OrderBean;
import com.shashi.beans.ProductBean;
import com.shashi.beans.TransactionBean;
import com.shashi.service.OrderService;
import com.shashi.service.ProductService;
import com.shashi.service.impl.OrderServiceImpl;
import com.shashi.service.impl.ProductServiceImpl;
import com.shashi.utility.DBUtil;
import com.shashi.utility.IDUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductServiceImplTest {
    static Connection con;

    private Savepoint savepoint;

    private ProductService productService;

    private List<ProductBean> products;


    @BeforeEach
    void setUp() {
        con = DBUtil.provideConnection();

        try {
            con.setAutoCommit(false);
            savepoint = con.setSavepoint();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        productService = new ProductServiceImpl();

        products = Arrays.asList(
                new ProductBean(IDUtil.generateId() + "1", "Test Prod 1", "mobile", "testInfo 1", 100, 1, null),
                new ProductBean(IDUtil.generateId() + "2", "Test Prod 2", "camera", "testInfo 2", 200, 2, null),
                new ProductBean(IDUtil.generateId() + "3", "Test Prod 3", "tv", "testInfo 3", 300, 3, null),
                new ProductBean(IDUtil.generateId() + "4", "Test Prod 4", "tv", "testInfo 4", 400, 5, null)
        );
        for (ProductBean product : products) {
            productService.addProduct(product);
        }
    }

    @AfterEach
    void tearDown() {
        try {
            con.rollback(savepoint);
            con.setAutoCommit(true);
            DBUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getLowStockProduct_ShouldReturnProductsLowInStock() {
        List<ProductBean> result;
        List<ProductBean> expectedProducts = products.stream()
                .filter(product -> product.getProdQuantity() <= 3)
                .collect(Collectors.toList());

        result = productService.getLowStockProduct();

        assertFalse(result.isEmpty());
        for (ProductBean product : expectedProducts) {
            assertTrue(result.contains(product));
        }
    }

    @Test
    void getLowStockProduct_ShouldReturnProductsLowInStockUsingSalesData() {
        List<ProductBean> result;
        ProductBean expectedProduct = products.stream()
                .filter(product -> product.getProdQuantity() > 3)
                .findFirst()
                .orElse(null);
        generateOrder();

        result = productService.getLowStockProduct();

        assertFalse(result.isEmpty());
        assertTrue(result.contains(expectedProduct));
    }

    /**
     * Generate test orders
     */
    private void generateOrder() {
        OrderService orderService = new OrderServiceImpl();

        TransactionBean transaction = new TransactionBean(
                "guest@gmail.com",
                Timestamp.valueOf(LocalDate.now().minusMonths(1).atStartOfDay()),
                100
        );
        String transactionId = transaction.getTransactionId();

        ProductBean product = products.stream()
                .filter(p -> p.getProdQuantity() > 3)
                .findFirst()
                .orElse(null);

        int quantity = product.getProdQuantity() + 1;
        double amount = new ProductServiceImpl().getProductPrice(product.getProdId()) * quantity;
        OrderBean order = new OrderBean(transactionId, product.getProdId(), quantity, amount);
        boolean ordered = orderService.addOrder(order);
        if (ordered) {
            new OrderServiceImpl().addTransaction(transaction);
        }
    }
}