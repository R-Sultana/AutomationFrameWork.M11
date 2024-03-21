package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class Scenario2WithDDTAndGU {

	public static void main(String[] args) throws IOException  {
		// object creation for generic utility
		ExcelFileUtility eu= new ExcelFileUtility();
		PropertyFileUtility pu= new PropertyFileUtility();
		SeleniumUtility su = new SeleniumUtility();
		
		// read data from property file and excel file
		String URL = pu.readDataFromPropertyFile("url");
		String USERNAME = pu.readDataFromPropertyFile("username");
		String PASSWORD = pu.readDataFromPropertyFile("password");
		
		String LEADNAME= eu.readDataFromExcelFile("leads", 4, 2);
		String COMPANY= eu.readDataFromExcelFile("leads", 4, 3);
		
		// launch browser and navigate to url
		WebDriver driver= new ChromeDriver();
		su.maximizeWindow(driver);
		su.addImplicitWait(driver);
		driver.get(URL);
		
		// login App
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		// navigate lead link and create lead with mandatory field
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LEADNAME);
		driver.findElement(By.name("company")).sendKeys(COMPANY);
		driver.findElement(By.xpath("//input[contains(@class,'save')]")).click();
		
		//Validation 
		if(driver.findElement(By.className("dvHeaderText")).getText().contains(LEADNAME))
			System.out.println("PASS");
		else
			System.out.println("FAIL");
		
		//logout app
		su.mouseOverAction(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		su.clickOnAction(driver, driver.findElement(By.xpath("//a[.='Sign Out']")));
		
		//close browser
		driver.quit();
	}

}
