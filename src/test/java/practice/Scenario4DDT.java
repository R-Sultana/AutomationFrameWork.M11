package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario4DDT {

	public static void main(String[] args) throws IOException {
		//Read data from property file and excel file
		FileInputStream fisp= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p =new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("vendors"); 
		String VENDORNAME = sh.getRow(1).getCell(2).getStringCellValue();
		
		//launch browser and navigate to url
		WebDriver d= new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		d.get(URL);
		
		//Login App with valid credential
		d.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		d.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		d.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//Navigate to More link and clickon vendor link
		Actions act= new Actions(d);
		act.moveToElement(d.findElement(By.xpath("//a[contains(text(),'More')]"))).click(d.findElement(By.xpath("//a[text()='Vendors']"))).perform();
		
		//Click on to create vendor look up image
		d.findElement(By.xpath("//img[contains(@title,'Create Vendor...')]")).click();
		
		//create vendor with mandatory field
		d.findElement(By.xpath("//input[@name='vendorname']")).sendKeys(VENDORNAME);
		d.findElement(By.xpath("//input[@name='button']")).click();
		
		//Verify for vendor
		WebElement actualData=d.findElement(By.className("lvtHeaderText"));
		if(actualData.getText().contains(VENDORNAME))
			System.out.println("PASS"+actualData.getText());
		else
			System.out.println("FAIL");
		
		//Logout of app
		act.moveToElement(d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).click(d.findElement(By.xpath("//a[text()='Sign Out']"))).perform();
		d.quit();

	}

}
