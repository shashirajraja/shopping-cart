package tests.unit;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import com.shashi.beans.ProductBean;
import com.shashi.service.impl.ProductServiceImpl;

public class ProductServiceImplTest {

	@Test
	public void testSearchAllLowStockProducts() {
		
		ProductServiceImpl service = new ProductServiceImpl();
    		int threshold = 5; // Example threshold
    		List<ProductBean> lowStockProducts = service.searchAllLowStockProducts(threshold);

	        // Assert that all returned products have a stock less than or equal to the threshold
	        for (ProductBean product : lowStockProducts) {
	            assertTrue(product.getProdQuantity() <= threshold);
	        }
	}

	@Test
	public void testGetAllLowStockProductsByType() {

		ProductServiceImpl service = new ProductServiceImpl();
        int threshold = 10; // Example threshold
        String type = "fan"; // Example product type

        List<ProductBean> lowStockProducts = service.getAllLowStockProductsByType(threshold, type);

        // Assert that all returned products are of the specified type and below the threshold
        for (ProductBean product : lowStockProducts) {
            assertEquals(type, product.getProdType());
            assertTrue(product.getProdQuantity() <= threshold);
        }
	}

	@Test
	public void testGetUsedLowCostProducts() {
		
		ProductServiceImpl service = new ProductServiceImpl();
        double maxCost = 1300.00; // Example max cost

        List<ProductBean> products = service.getUsedLowCostProducts(maxCost);

        for (ProductBean product : products) {
            assertTrue(product.getUsed()); // Assuming you have an isUsed() method
            assertTrue(product.getProdPrice() <= maxCost);
        }
	}

}
