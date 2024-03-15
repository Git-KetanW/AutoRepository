package commands;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameEx1 {
	
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/iframe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.switchTo().frame("mce_0_ifr"); //by id/name
		driver.switchTo().frame(0); //by index
		By text= By.xpath("//body[@id='tinymce']/p");
		
		driver.findElement(text).clear();
		driver.findElement(text).sendKeys("Ketan Walde Rana");

	}

}
