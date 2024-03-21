package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario3 {

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
				
				//step3: navigate to campaign link
				Actions ac = new Actions(d);
				WebElement moreTab=d.findElement(By.xpath("//a[contains(text(),'More')]"));
				ac.moveToElement(moreTab).moveToElement(d.findElement(By.xpath("//a[text()='Campaigns']"))).click().perform();
				
				
				//step4: click on create campaign look up image
				d.findElement(By.xpath("//img[contains(@title,'Create Campaign...')]")).click();
				
				//step5: create campaign with mandatory field
				d.findElement(By.xpath("//input[@name='campaignname']")).sendKeys("Camp1");
				//d.findElement(By.xpath("//img[contains(@id,'jscal_trigger_closingdate')]")).click();
				//d.findElement(By.xpath("//td[text()='14']")).click();
				d.findElement(By.xpath("//input[@name='button']")).click();
				//step6: verify campaign
				WebElement contactHeader=d.findElement(By.className("dvHeaderText"));
				if(contactHeader.getText().contains("Camp1"))
					System.out.println("PASS");
				else
					System.out.println("FAIL");
				
				//step7: log out app
				WebElement acc=d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act= new Actions(d);
				WebElement signout=d.findElement(By.xpath("//a[text()='Sign Out']"));
				act.moveToElement(acc).perform();
				Thread.sleep(1000);
				act.moveToElement(signout).click().perform();
				System.out.println("logout successfully");
			}

	}


