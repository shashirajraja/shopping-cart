import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class CartServiceTest {

    @InjectMocks
    private CartServiceImpl cartService;

    @Mock
    private CartRepository cartRepository; // Assuming the existence of a CartRepository interface or class

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProductToCart() {
        String userId = "user123";
        String prodId = "prod456";
        int prodQty = 2;

        when(cartRepository.addProductToCart(userId, prodId, prodQty)).thenReturn("Product added successfully");

        String result = cartService.addProductToCart(userId, prodId, prodQty);

        assertEquals("Product added successfully", result);
    }

    @Test
    public void testUpdateProductToCart() {
        String userId = "user123";
        String prodId = "prod456";
        int prodQty = 3;

        when(cartRepository.updateProductToCart(userId, prodId, prodQty)).thenReturn("Product updated successfully");

        String result = cartService.updateProductToCart(userId, prodId, prodQty);

        assertEquals("Product updated successfully", result);
    }

    @Test
    public void testGetAllCartItems() {
        String userId = "user123";

        List<CartBean> cartItems = new ArrayList<>();
        cartItems.add(new CartBean("prod123", 2));
        cartItems.add(new CartBean("prod456", 3));

        when(cartRepository.getAllCartItems(userId)).thenReturn(cartItems);

        List<CartBean> result = cartService.getAllCartItems(userId);

        assertEquals(cartItems, result);
    }

    @Test
    public void testGetCartCount() {
        String userId = "user123";

        when(cartRepository.getCartCount(userId)).thenReturn(5);

        int result = cartService.getCartCount(userId);

        assertEquals(5, result);
    }

    @Test
    public void testGetCartItemCount() {
        String userId = "user123";
        String itemId = "prod456";

        when(cartRepository.getCartItemCount(userId, itemId)).thenReturn(3);

        int result = cartService.getCartItemCount(userId, itemId);

        assertEquals(3, result);
    }

    @Test
    public void testRemoveProductFromCart() {
        String userId = "user123";
        String prodId = "prod456";

        when(cartRepository.removeProductFromCart(userId, prodId)).thenReturn("Product removed successfully");

        String result = cartService.removeProductFromCart(userId, prodId);

        assertEquals("Product removed successfully", result);
    }

    @Test
    public void testRemoveAProduct() {
        String userId = "user123";
        String prodId = "prod456";

        when(cartRepository.removeAProduct(userId, prodId)).thenReturn(true);

        boolean result = cartService.removeAProduct(userId, prodId);

        assertTrue(result);
    }
}

