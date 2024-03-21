package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario5DDT {

	public static void main(String[] args) throws IOException {
		
//		Read data from property file and excel file
		FileInputStream fisp= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p =new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("products"); 
		String VENDORNAME = sh.getRow(4).getCell(2).getStringCellValue();
		
//		Launch browser and navigate to url
		WebDriver d= new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		d.get(URL);
		
//		Login App with valid credential
		d.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		d.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		d.findElement(By.xpath("//input[@id='submitButton']")).click();
		
//		Navigate to product link and Click on to create product look up image
		d.findElement(By.xpath("//a[text()='Products']")).click();
		d.findElement(By.xpath("//img[contains(@title,'Create Product...')]")).click();
		
//		click on vendor lookup
		d.findElement(By.xpath("//img[@title='Select']")).click();
		
//		verify created vendor name is displayed 
		String parent = d.getWindowHandle();
		Set<String> w = d.getWindowHandles();
		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		for(String e :w) {
			d.switchTo().window(e);
			if(!d.getWindowHandle().contains(parent)) {
				//if(d.findElement(By.id("3")).getText().contains(VENDORNAME))
				  if(d.findElement(By.xpath("//a[.='"+VENDORNAME+"']")).getText().contains(VENDORNAME))	
					System.out.println("PASS....created vendor name is displayed : "+d.findElement(By.xpath("//a[.='"+VENDORNAME+"']")).getText());
				else
					System.out.println("FAIL");
				d.close();
				d.switchTo().window(parent);
			}
			
		}
		
//		Logout of app
		Actions act= new Actions(d);
		WebElement acc=d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebElement signout=d.findElement(By.xpath("//a[text()='Sign Out']"));
		act.moveToElement(acc).perform();
		//Thread.sleep(1000);
		act.moveToElement(signout).click().perform();
		System.out.println("logout successfully");
		d.quit();
	}

}
