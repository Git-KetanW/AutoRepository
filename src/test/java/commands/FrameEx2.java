package commands;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class FrameEx2 {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://letcode.in/frame");
		driver.manage().window().maximize();
		
		//here we demonstrate nested frame practical
		
		//this is parent frame
		driver.switchTo().frame("firstFr");
		driver.findElement(By.name("fname")).sendKeys("Ketan");
		driver.findElement(By.name("lname")).sendKeys("Rana");
		
		//this is child frame
		WebElement frame=driver.findElement(By.xpath("//iframe[@src='innerFrame']"));
		driver.switchTo().frame(frame); //located by WebElement
		driver.findElement(By.name("email")).sendKeys("something@nothing.com");

	}

}
