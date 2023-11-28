package tests.unit;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Test;

public class GetLowStockProducts {
	
	static WebDriver driver;
	
	@BeforeClass
	public static void initDriver() {
		// Create the web driver that will be used for testing, and set it to wait 500ms on page load, just in case
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
	}
	
	@Test
	public void testNoLowStockMesssageWhenLoggedOut() {
		// Navigate to the home page
		driver.get("http://localhost:8080/shopping-cart/index.jsp");
		
		// Get the number of LOW STOCK elements
		List<WebElement> lowStockList = driver.findElements(By.id("low-stock"));
		
		// There should be none of them
		assertTrue(lowStockList.isEmpty());
	}
	
	@Test
	public void testNoLowStockMesssageAsCustomer() {
		// Navigate to Login page
		driver.get("http://localhost:8080/shopping-cart/login.jsp");
		
		// Get the various Login elements to manipulate
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		WebElement button = driver.findElement(By.id("login"));
		
		// Fill in the required values to log in as CUSTOMER, and select CUSTOMER from the dropdown
		email.sendKeys("guest@gmail.com");
		password.sendKeys("guest");
		dropdown.selectByValue("customer");
		
		// Actually log in
		button.click();
		
		// Get a list of all LOW-STOCK elements.
		List<WebElement> lowStockList = driver.findElements(By.id("low-stock"));
		
		// There should be none of them 
		assertTrue(lowStockList.size() == 0);
		
		// Logout
		WebElement logoutButton = driver.findElement(By.linkText("Logout"));
		logoutButton.click();
	}
	
	@Test
	public void testTwoItemsAreLowStockAsAdmin() {
		// Navigate to Login page
		driver.get("http://localhost:8080/shopping-cart/login.jsp");
		
		// Get the various Login elements to manipulate
		WebElement email = driver.findElement(By.id("email"));
		WebElement password = driver.findElement(By.id("password"));
		Select dropdown = new Select(driver.findElement(By.id("dropdown")));
		WebElement button = driver.findElement(By.id("login"));
		
		// Fill in the required values to log in as ADMIN, and select ADMIN from the dropdown
		email.sendKeys("admin@gmail.com");
		password.sendKeys("admin");
		dropdown.selectByValue("admin");
		
		// Actually log in
		button.click();
		
		// Get a list of all LOW-STOCK elements.
		List<WebElement> lowStockList = driver.findElements(By.id("low-stock"));
		
		// There should be 2 of them 
		assertTrue(lowStockList.size() == 2);
		
		// Navigate to the Stock page by clicking the link
		WebElement stockButton = driver.findElement(By.linkText("Stock"));
		stockButton.click();
		
		// Again, get the list of LOW STOCK elements.
		lowStockList = driver.findElements(By.id("low-stock"));
		
		// There should still be 2 of them
		assertTrue(lowStockList.size() == 2);
		
		// Logout
		WebElement logoutButton = driver.findElement(By.linkText("Logout"));
		logoutButton.click();
	}
	
	@AfterClass
	public static void closeDriver() {
		driver.quit();
	}
}
