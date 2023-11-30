import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository; // Assuming the existence of a ProductRepository interface or class

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProductWithStringParameters() {
        String prodName = "Product 1";
        String prodType = "Type A";
        String prodInfo = "Product information";
        double prodPrice = 50.0;
        int prodQuantity = 100;
        InputStream prodImage = /* mock InputStream */;
        Boolean productUsed = false;
        HashSet<ProductInterest> relatedInterests = new HashSet<>();

        when(productRepository.addProduct(prodName, prodType, prodInfo, prodPrice, prodQuantity, prodImage,
                productUsed, relatedInterests)).thenReturn("Product added successfully");

        String result = productService.addProduct(prodName, prodType, prodInfo, prodPrice, prodQuantity, prodImage,
                productUsed, relatedInterests);

        assertEquals("Product added successfully", result);
    }

    @Test
    public void testAddProductWithProductBean() {
        ProductBean product = new ProductBean(/* your product details */);

        when(productRepository.addProduct(product)).thenReturn("Product added successfully");

        String result = productService.addProduct(product);

        assertEquals("Product added successfully", result);
    }

    @Test
    public void testRemoveProduct() {
        String prodId = "prod123";

        when(productRepository.removeProduct(prodId)).thenReturn("Product removed successfully");

        String result = productService.removeProduct(prodId);

        assertEquals("Product removed successfully", result);
    }

    @Test
    public void testUpdateProduct() {
        ProductBean prevProduct = new ProductBean(/* previous product details */);
        ProductBean updatedProduct = new ProductBean(/* updated product details */);

        when(productRepository.updateProduct(prevProduct, updatedProduct)).thenReturn("Product updated successfully");

        String result = productService.updateProduct(prevProduct, updatedProduct);

        assertEquals("Product updated successfully", result);
    }

    @Test
    public void testUpdateProductPrice() {
        String prodId = "prod123";
        double updatedPrice = 60.0;

        when(productRepository.updateProductPrice(prodId, updatedPrice)).thenReturn("Product price updated successfully");

        String result = productService.updateProductPrice(prodId, updatedPrice);

        assertEquals("Product price updated successfully", result);
    }

    @Test
    public void testGetAllProducts() {
        List<ProductBean> products = new ArrayList<>();
        products.add(new ProductBean(/* product details */));
        products.add(new ProductBean(/* product details */));

        when(productRepository.getAllProducts()).thenReturn(products);

        List<ProductBean> result = productService.getAllProducts();

        assertEquals(products, result);
    }

    @Test
    public void testGetAllProductsByType() {
        String type = "Type A";

        List<ProductBean> products = new ArrayList<>();
        products.add(new ProductBean(/* product details with Type A */));
        products.add(new ProductBean(/* product details with Type A */));

        when(productRepository.getAllProductsByType(type)).thenReturn(products);

        List<ProductBean> result = productService.getAllProductsByType(type);

        assertEquals(products, result);
    }

    @Test
    public void testSearchAllProducts() {
        String search = "Product";

        List<ProductBean> products = new ArrayList<>();
        products.add(new ProductBean(/* product details with matching search */));
        products.add(new ProductBean(/* product details with matching search */));

        when(productRepository.searchAllProducts(search)).thenReturn(products);

        List<ProductBean> result = productService.searchAllProducts(search);

        assertEquals(products, result);
    }

    @Test
    public void testGetImage() {
        String prodId = "prod123";

        byte[] imageBytes = /* mock image bytes */;

        when(productRepository.getImage(prodId)).thenReturn(imageBytes);

        byte[] result = productService.getImage(prodId);

        assertArrayEquals(imageBytes, result);
    }

    @Test
    public void testGetProductDetails() {
        String prodId = "prod123";

        ProductBean product = new ProductBean(/* product details */);

        when(productRepository.getProductDetails(prodId)).thenReturn(product);

        ProductBean result = productService.getProductDetails(prodId);

        assertEquals(product, result);
    }

    @Test
    public void testUpdateProductWithoutImage() {
        String prevProductId = "prevProd123";
        ProductBean updatedProduct = new ProductBean(/* updated product details */);

        when(productRepository.updateProductWithoutImage(prevProductId, updatedProduct))
                .thenReturn("Product updated successfully without image");

        String result = productService.updateProductWithoutImage(prevProductId, updatedProduct);

        assertEquals("Product updated successfully without image", result);
    }

    @Test
    public void testGetProductPrice() {
        String prodId = "prod123";

        when(productRepository.getProductPrice(prodId)).thenReturn(50.0);

        double result = productService.getProductPrice(prodId);

        assertEquals(50.0, result, 0.01); // 0.01 is the delta for double comparison
    }

    @Test
    public void testSellNProduct() {
        String prodId = "prod123";
        int n = 5;

        when(productRepository.sellNProduct(prodId, n)).thenReturn(true);

        boolean result = productService.sellNProduct(prodId, n);

        assertTrue(result);
    }

    @Test
    public void testGetProductQuantity() {
        String prodId = "prod123";

        when(productRepository.getProductQuantity(prodId)).thenReturn(10);

        int result = productService.getProductQuantity(prodId);

        assertEquals(10, result);
    }
}

