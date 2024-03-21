package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario2 {

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
		
		//step3: navigate to lead link
		d.findElement(By.xpath("//a[text()='Leads']")).click();
		
		
		//step4: click on create lead look up image
		d.findElement(By.xpath("//img[contains(@title,'Create Lead...')]")).click();
		
		//step5: create lead with mandatory field and save
		d.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Sarah");
		d.findElement(By.xpath("//input[@name='company']")).sendKeys("Appi");
		d.findElement(By.xpath("//input[@name='button']")).click();
		
		//step6: verify lead
		WebElement contactHeader=d.findElement(By.className("dvHeaderText"));
		if(contactHeader.getText().contains("Sarah"))
			System.out.println("PASS"+contactHeader.getText());
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


