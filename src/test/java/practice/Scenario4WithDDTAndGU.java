package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class Scenario4WithDDTAndGU {

	public static void main(String[] args) throws IOException {
		//creating object for all utility classes
		PropertyFileUtility pu= new PropertyFileUtility();
		ExcelFileUtility eu= new ExcelFileUtility();
		SeleniumUtility su= new SeleniumUtility();
		
		// read data from property file
		String URL=pu.readDataFromPropertyFile("url");
		String PASSWORD=pu.readDataFromPropertyFile("password");
		String USERNAME=pu.readDataFromPropertyFile("username");
		
		//read data from excel file 
		String VENDORNAME=eu.readDataFromExcelFile("vendors", 1, 2);
		
		// navigate to url
		WebDriver driver= new ChromeDriver();
		su.maximizeWindow(driver);
		su.addImplicitWait(driver);
		driver.get(URL);
		
		// login to app
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//navigate to vendor link
		su.mouseOverAction(driver, driver.findElement(By.xpath("//a[.='More']")));
		su.clickOnAction(driver, driver.findElement(By.xpath("//a[.='Vendors']")));
		
		// clickon create vendor icon
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		
		// fill details and click on save
		driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys(VENDORNAME);
		driver.findElement(By.xpath("//input[@name='button' and @type='submit']")).click();
		
		//validation for vendors
		if(driver.findElement(By.className("lvtHeaderText")).getText().contains(VENDORNAME))
			System.out.println("PASS");
		else
			System.out.println("FAIL");
		
		//logout app and close browser
		su.mouseOverAction(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		su.clickOnAction(driver, driver.findElement(By.linkText("Sign Out")));
		driver.close();

	}

}
