package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Scenario5 {

	public static void main(String[] args) throws InterruptedException {
				//step1: launch browser
				WebDriver d = new ChromeDriver();
				d.manage().window().maximize();
				d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				d.get("http://localhost:8888");
				
				//step2: login app
				d.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
				d.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
				d.findElement(By.xpath("//input[@id='submitButton']")).click();
				System.out.println("login successful");
				
				//step3: navigate to product link
				d.findElement(By.xpath("//a[text()='Products']")).click();
				
				//click on create product loopup icon
				d.findElement(By.xpath("//img[contains(@title,'Create Product...')]")).click();
				
				//step4: fill the vendor field and verify
				
				d.findElement(By.xpath("//img[@title='Select']")).click();
				String parent= d.getWindowHandle();
				WebDriverWait wait= new WebDriverWait(d, Duration.ofSeconds(15));
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				Set<String> w= d.getWindowHandles();
				for(String e :w) {
					d.switchTo().window(e);
					if(!d.getWindowHandle().contains(parent)) {
//						if(d.findElement(By.xpath("//a[text()='Raju']")).isDisplayed()) {	
//						d.findElement(By.xpath("//a[text()='Raju']")).click();
						String vname=d.findElement(By.xpath("//a[@href='javascript:window.close();']")).getText();
						if(vname.contains("Rubesh")) {
							System.out.println("created vendor name is displayed");
						}
//						}
						
						d.close();
					}
					d.switchTo().window(parent);
				}
				
				//step5: log out app
				WebElement acc=d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act= new Actions(d);
				WebElement signout=d.findElement(By.xpath("//a[text()='Sign Out']"));
				act.moveToElement(acc).perform();
				Thread.sleep(1000);
				act.moveToElement(signout).click().perform();
				System.out.println("logout successfully");
				
				//step6: close the browser
				d.quit();

	}

}
