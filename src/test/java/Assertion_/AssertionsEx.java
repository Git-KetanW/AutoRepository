package Assertion_;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertionsEx {
	WebDriver driver;
	
	@Test
	public static void launch() {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String str1 = driver.getTitle();
		String str2 = "Your Store";
		
//		Assert.assertEquals(str1, str2); //assertEquals();
		
//		Assert.assertNotEquals(str1, str2); //assertNotEquals();
		
//		Assert.assertTrue(str2.contains("Store")); //assertTrue(); --is case sensitive
		
//		Assert.assertFalse(str2.contains("Store")); // assertFalse();  --is case sensitive
		
//		Assert.assertNull(str2); // assertNull();
		
//		Assert.assertNotNull(str2); //assertNotNull();
		
		if(driver.findElement(By.linkText("MacBook")).isDisplayed()) {
			
			Assert.fail("MacBook  is displaying, hence failed"); //fail();
		}
		
		driver.quit();
	}
}
