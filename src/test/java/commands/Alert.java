package commands;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.indiehackers.com/sign-in");
		
		//Get the text from the Alert & Accept Alert
		driver.findElement(By.linkText("Reset")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(25));
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert();
		String text=driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();
		
		//Dismiss Alert
		driver.findElement(By.linkText("Reset")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
		
		//Enter data into Alert
		driver.findElement(By.linkText("Reset")).click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().sendKeys("Somthing@nothing.com");
		driver.switchTo().alert().accept();
		
		driver.close();
		
	}

}
