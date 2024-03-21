package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CalenderFutureDate {

	@Test
	public void selectFutureDate() {
		//lauch the browser and navigate to url
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.makemytrip.com/");
		
		// clickon departure calendar and select future date
		driver.findElement(By.xpath("//span[.='Departure']")).click();
		WebElement scroll = driver.findElement(By.xpath("//span[@role='button' and @aria-label='Next Month']"));
		for(int i=1;i<=4;i++) {
			scroll.click();
		}
		try {
		driver.findElement(By.xpath("//div[@aria-label='Fri Aug 09 2024']")).click();
		}catch(Exception e) {
			e.getStackTrace();
		}
	}
}
