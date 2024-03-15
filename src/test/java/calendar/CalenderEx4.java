package calendar;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderEx4 {
	static WebDriver driver;

	public static void main(String[] args) {
		
		String eDate="28-03-2024";
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		LocalDate expectedLD = LocalDate.parse(eDate, dateFormat);
		
		int eDay = expectedLD.getDayOfMonth();
		int eMonth = expectedLD.getMonthValue();
		int eYear = expectedLD.getYear();
		
		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement calendarField = driver.findElement(By.id("datepicker"));
		calendarField.click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-datepicker-div")));
		
		String monthText = driver.findElement(By.className("ui-datepicker-month")).getText();
		int iMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(monthText).get(ChronoField.MONTH_OF_YEAR);
		
		String yearText = driver.findElement(By.className("ui-datepicker-year")).getText();
		int iYear = Integer.parseInt(yearText);
		
	


	//this is for Past Date
	while(eMonth<iMonth || eYear<iYear) {
		
		driver.findElement(By.xpath("//a[@title='Prev']")).click();
		
		monthText = driver.findElement(By.className("ui-datepicker-month")).getText();
		iMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(monthText).get(ChronoField.MONTH_OF_YEAR);
		
		yearText = driver.findElement(By.className("ui-datepicker-year")).getText();
		iYear = Integer.parseInt(yearText);
	}
	
	//this is for Future Date
	while(eMonth>iMonth || eYear>iYear) {
		
		driver.findElement(By.xpath("//a[@title='Next']")).click();
		
		monthText = driver.findElement(By.className("ui-datepicker-month")).getText();
		iMonth = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(monthText).get(ChronoField.MONTH_OF_YEAR);
		
		yearText = driver.findElement(By.className("ui-datepicker-year")).getText();
		iYear = Integer.parseInt(yearText);
	}
	
	String xpathText="//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']/a[text()=\\'\"+eDay+\"\\']";
	driver.findElement(By.xpath(xpathText));

	}
}
