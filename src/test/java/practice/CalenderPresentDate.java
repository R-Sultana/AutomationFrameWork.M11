package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CalenderPresentDate {

	@Test
	public void selectPresentDate() throws InterruptedException {
		//launch the browser and navigate to url
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.makemytrip.com/");
		
		//clickon departure calender and select any date in current month
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@aria-label='Wed Mar 06 2024']")).click();
	}
}
