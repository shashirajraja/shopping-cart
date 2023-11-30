import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

public class UserBeanTest {

    private UserBean testUser;

    @Before
    public void setUp() {
        // Create a test user
        testUser = new UserBean("Test User", 1234567890L, "test@example.com", "Test Address", 12345, "testPassword",
                UserType.REGULAR);
        testUser.setUserInterests(new HashSet<>());
    }

    @Test
    public void testGetName() {
        assertEquals("Test User", testUser.getName());
    }

    @Test
    public void testSetName() {
        testUser.setName("New Name");
        assertEquals("New Name", testUser.getName());
    }

    @Test
    public void testGetMobile() {
        assertEquals(Long.valueOf(1234567890L), testUser.getMobile());
    }

    @Test
    public void testSetMobile() {
        testUser.setMobile(9876543210L);
        assertEquals(Long.valueOf(9876543210L), testUser.getMobile());
    }

    @Test
    public void testGetEmail() {
        assertEquals("test@example.com", testUser.getEmail());
    }

    @Test
    public void testSetEmail() {
        testUser.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", testUser.getEmail());
    }

    @Test
    public void testGetAddress() {
        assertEquals("Test Address", testUser.getAddress());
    }

    @Test
    public void testSetAddress() {
        testUser.setAddress("New Address");
        assertEquals("New Address", testUser.getAddress());
    }

    @Test
    public void testGetPinCode() {
        assertEquals(12345, testUser.getPinCode());
    }

    @Test
    public void testSetPinCode() {
        testUser.setPinCode(54321);
        assertEquals(54321, testUser.getPinCode());
    }

    @Test
    public void testGetPassword() {
        assertEquals("testPassword", testUser.getPassword());
    }

    @Test
    public void testSetPassword() {
        testUser.setPassword("newPassword");
        assertEquals("newPassword", testUser.getPassword());
    }

    @Test
    public void testGetUserType() {
        assertEquals(UserType.REGULAR, testUser.getUserType());
    }

    @Test
    public void testSetUserType() {
        testUser.setUserType(UserType.ADMIN);
        assertEquals(UserType.ADMIN, testUser.getUserType());
    }

    @Test
    public void testGetUserInterests() {
        assertNotNull(testUser.getUserInterests());
    }

    @Test
    public void testSetUserInterests() {
        HashSet<String> interests = new HashSet<>();
        interests.add("Interest1");
        interests.add("Interest2");

        testUser.setUserInterests(interests);

        assertEquals(interests, testUser.getUserInterests());
    }

    @Test
    public void testClearUserInterests() {
        testUser.addUserInterest("Interest1");
        testUser.addUserInterest("Interest2");

        testUser.clearUserInterests();

        assertTrue(testUser.getUserInterests().isEmpty());
    }

    @Test
    public void testAddUserInterest() {
        String interest = "Interest1";

        testUser.addUserInterest(interest);

        assertTrue(testUser.getUserInterests().contains(interest));
    }

    @Test
    public void testAddUserInterest_Duplicate() {
        String interest = "Interest1";

        // Adding the same interest twice
        testUser.addUserInterest(interest);
        testUser.addUserInterest(interest);

        assertEquals(1, testUser.getUserInterests().size());
    }

    @Test
    public void testRemoveUserInterest() {
        String interest = "Interest1";

        testUser.addUserInterest(interest);
        testUser.removeUserInterest(interest);

        assertFalse(testUser.getUserInterests().contains(interest));
    }

    @Test
    public void testRemoveUserInterest_NotExists() {
        String interest = "Interest1";

        // Removing an interest that was not added
        testUser.removeUserInterest(interest);

        // Nothing should change
        assertTrue(testUser.getUserInterests().isEmpty());
    }
}


