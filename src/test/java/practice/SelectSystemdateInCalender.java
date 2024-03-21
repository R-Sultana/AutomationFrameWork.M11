package practice;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectSystemdateInCalender {

	@Test
	public void systemDateInCalender() throws InterruptedException {
		
	// Capture current system date time and convert to calender format 	
	LocalDateTime now = LocalDateTime.now();
	String today= now.format(DateTimeFormatter.ofPattern("EEE MMM dd uuuu", Locale.ENGLISH));
	
	// launch the browser and navigate to url
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.makemytrip.com/");
	
	// clickon departure calender and select current date
	driver.findElement(By.xpath("//span[.='Departure']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@aria-label='"+today+"']")).click();
	
}
}