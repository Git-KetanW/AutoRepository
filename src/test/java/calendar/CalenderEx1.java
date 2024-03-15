package calendar;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderEx1 {
	static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement datepicker = driver.findElement(By.id("datepicker"));
		datepicker.click();
		
		//we add wait till the calendar display
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-datepicker-div")));
		
		selectDate("10","March","2024"); //this is our expected output

	}
	
	// parameterize method
	public static void selectDate(String selectDate,String selectMonth, String selectYear) {
		
		//in the below code we get the Month & Year separated by single space
		String monthyear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		
		//in the below code we split the month & year and store in individual variable
		String month = monthyear.split(" ")[0];
		String year = monthyear.split(" ")[1];
		
		//this condition state:- we traverse in calendar till we get the expected date
		while(!(month.equals(selectMonth) && year.equals(selectYear))) {
			
			//in below code we click on next button in calendar
			driver.findElement(By.xpath("//a[@title='Next']")).click();
			
			//every new month & year will store here & update till we exit from our condition
			monthyear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			
			month = monthyear.split(" ")[0];
			year = monthyear.split(" ")[1];
		}
		
		//this is Dynamic XPath for Expected date
		String xpathText="//td[@data-handler='selectDay']/a[text()=\'"+selectDate+"\']";
		driver.findElement(By.xpath(xpathText)).click();
	}

}

