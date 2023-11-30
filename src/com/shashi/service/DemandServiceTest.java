import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DemandServiceTest {

    @InjectMocks
    private DemandServiceImpl demandService;

    @Mock
    private DemandRepository demandRepository; // Assuming the existence of a DemandRepository interface or class

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddProduct() {
        String userId = "user123";
        String prodId = "prod456";
        int demandQty = 5;

        when(demandRepository.addProduct(userId, prodId, demandQty)).thenReturn(true);

        boolean result = demandService.addProduct(userId, prodId, demandQty);

        assertTrue(result);
    }

    @Test
    public void testAddProductWithDemandBean() {
        DemandBean demandBean = new DemandBean("user123", "prod456", 5);

        when(demandRepository.addProduct(demandBean)).thenReturn(true);

        boolean result = demandService.addProduct(demandBean);

        assertTrue(result);
    }

    @Test
    public void testRemoveProduct() {
        String userId = "user123";
        String prodId = "prod456";

        when(demandRepository.removeProduct(userId, prodId)).thenReturn(true);

        boolean result = demandService.removeProduct(userId, prodId);

        assertTrue(result);
    }

    @Test
    public void testHaveDemanded() {
        String prodId = "prod456";

        List<DemandBean> demandList = new ArrayList<>();
        demandList.add(new DemandBean("user123", "prod456", 3));
        demandList.add(new DemandBean("user456", "prod456", 2));

        when(demandRepository.haveDemanded(prodId)).thenReturn(demandList);

        List<DemandBean> result = demandService.haveDemanded(prodId);

        assertEquals(demandList, result);
    }
}

