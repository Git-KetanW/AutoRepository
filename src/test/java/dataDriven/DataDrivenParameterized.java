package dataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenParameterized {
	WebDriver driver;
	@Test(dataProvider="DataSet", dataProviderClass=DataSupplier.class) 
	//here we link data method with Login method
	public void Login(String email, String password) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		
		driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
		driver.quit();
	}
	
	/* 
	 here we comment out our dataProvider because of we create new class for
	 dataProvider & we calling dataProvider class file into this class
	 file by using cmd 'dataProviderClass=DataSupplier.class'
	 */
	
//	@DataProvider(name="DataSet") // we can rename of our DataProvider
//	public String[][] Data_provider() { //this is our set of data
//		
//		String [][] data = {{"johnmac@somthing.com","Johnmac@123"},
//				{"johnmac@somthing.com","Johnmac@123"},
//				{"johnmac@somthing.com","Johnmac@123"}};
//		
//		return data;
//		
//	}

}
