import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository; // Assuming the existence of a UserRepository interface or class

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUserWithStringParameters() {
        String userName = "John Doe";
        Long mobileNo = 1234567890L;
        String emailId = "john@example.com";
        String address = "123 Main St";
        int pinCode = 12345;
        String password = "password123";
        UserType userType = UserType.REGULAR;

        when(userRepository.registerUser(userName, mobileNo, emailId, address, pinCode, password, userType))
                .thenReturn("User registered successfully");

        String result = userService.registerUser(userName, mobileNo, emailId, address, pinCode, password, userType);

        assertEquals("User registered successfully", result);
    }

    @Test
    public void testRegisterUserWithUserBean() {
        UserBean user = new UserBean(/* your user details */);

        when(userRepository.registerUser(user)).thenReturn("User registered successfully");

        String result = userService.registerUser(user);

        assertEquals("User registered successfully", result);
    }

    @Test
    public void testIsRegistered() {
        String emailId = "john@example.com";

        when(userRepository.isRegistered(emailId)).thenReturn(true);

        boolean result = userService.isRegistered(emailId);

        assertTrue(result);
    }

    @Test
    public void testIsValidCredential() {
        String emailId = "john@example.com";
        String password = "password123";

        when(userRepository.isValidCredential(emailId, password)).thenReturn(true);

        String result = userService.isValidCredential(emailId, password);

        assertEquals("Valid credentials", result);
    }

    @Test
    public void testIsValidCredential_Invalid() {
        String emailId = "john@example.com";
        String password = "invalidpassword";

        when(userRepository.isValidCredential(emailId, password)).thenReturn(false);

        String result = userService.isValidCredential(emailId, password);

        assertEquals("Invalid credentials", result);
    }

    @Test
    public void testGetUserDetails() {
        String emailId = "john@example.com";
        String password = "password123";

        UserBean user = new UserBean(/* user details */);

        when(userRepository.getUserDetails(emailId, password)).thenReturn(user);

        UserBean result = userService.getUserDetails(emailId, password);

        assertEquals(user, result);
    }

    @Test
    public void testGetFName() {
        String emailId = "john@example.com";

        when(userRepository.getFName(emailId)).thenReturn("John");

        String result = userService.getFName(emailId);

        assertEquals("John", result);
    }

    @Test
    public void testGetUserAddr() {
        String userId = "user123";

        when(userRepository.getUserAddr(userId)).thenReturn("123 Main St");

        String result = userService.getUserAddr(userId);

        assertEquals("123 Main St", result);
    }
}

