import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DiscountServiceTest {

    @InjectMocks
    private DiscountServiceImpl discountService;

    @Mock
    private DiscountRepository discountRepository; // Assuming the existence of a DiscountRepository interface or class

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetBestSellingByInterest() {
        // Assuming no return value or void method
        discountService.getBestSellingByInterest();
    }

    @Test
    public void testCheckInStock() {
        ProductBean product = new ProductBean(/* your product details */);

        // Assuming no return value or void method
        discountService.checkInStock(product);
    }

    @Test
    public void testAddDiscount() {
        ProductBean product = new ProductBean(/* your product details */);
        int discountAmount = 10;

        // Assuming no return value or void method
        discountService.addDiscount(product, discountAmount);

        // You might want to verify the interaction with the repository, for example:
        verify(discountRepository, times(1)).addDiscount(product, discountAmount);
    }

    @Test
    public void testRemoveDiscount() {
        ProductBean product = new ProductBean(/* your product details */);

        // Assuming no return value or void method
        discountService.removeDiscount(product);

        // You might want to verify the interaction with the repository, for example:
        verify(discountRepository, times(1)).removeDiscount(product);
    }

    @Test
    public void testDisplayDiscount() {
        ProductBean product = new ProductBean(/* your product details */);

        // Assuming no return value or void method
        discountService.displayDiscount(product);

        // You might want to verify the interaction with the repository, for example:
        verify(discountRepository, times(1)).displayDiscount(product);
    }

    @Test
    public void testDisplayAdminSuggestions() {
        // Assuming no return value or void method
        discountService.displayAdminSuggestions();
    }
}

