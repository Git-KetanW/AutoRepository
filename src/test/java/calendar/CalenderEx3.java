package calendar;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderEx3 {
	static WebDriver driver;
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.holidaylettings.co.uk/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		
		WebElement datepicker = driver.findElement(By.id("arriveDate"));
		datepicker.click();
	
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-datepicker-div")));
		
		selectDate("24","December","2024");
	}
	public static void selectDate(String selectDay, String selectMonth, String selectYear) {
	    String monthyear = driver.findElement(By.xpath("//div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-right']"))
	                        .getText();

	    String[] splitMonthYear = monthyear.split(" ");
	    String month = "";
	    String year = "";

	    if (splitMonthYear.length == 2) {
	        // Both month and year are present
	        month = splitMonthYear[0];
	        year = splitMonthYear[1];
	    } else if (splitMonthYear.length == 1) {
	        // Only one part is present, handle it accordingly
	        // For example, handle if only year is present
	        year = splitMonthYear[0];
	    }

	    while (!(month.equals(selectMonth) && year.equals(selectYear))) {
	        driver.findElement(By.xpath("//a[@title='Next']")).click();
	        monthyear = driver.findElement(By.xpath("//a[@title='Next']")).getText();

	        splitMonthYear = monthyear.split(" ");
	        if (splitMonthYear.length == 2) {
	            month = splitMonthYear[0];
	            year = splitMonthYear[1];
	        } else if (splitMonthYear.length == 1) {
	            year = splitMonthYear[0];
	        }
	    }

	    String xpathText = "(//td[@data-handler='selectDay']/a[text()='" + selectDay + "'])[1]";
	    driver.findElement(By.xpath(xpathText)).click();
	}
}
