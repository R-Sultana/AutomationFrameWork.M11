package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class Scenario3WithDDTAndGU {

	public static void main(String[] args) throws IOException {
		// creating objects for all utility classes
		PropertyFileUtility pu= new PropertyFileUtility();
		ExcelFileUtility eu= new ExcelFileUtility();
		SeleniumUtility su= new SeleniumUtility();
		
		// read data from property file
		String URL=pu.readDataFromPropertyFile("url");
		String PASSWORD = pu.readDataFromPropertyFile("password");
		String USERNAME= pu.readDataFromPropertyFile("username");
		
		// read data from excel file
		String CAMPAIGNNAME=eu.readDataFromExcelFile("campaigns", 1, 2);
		
		// navigate to url
		WebDriver d= new ChromeDriver();
		su.maximizeWindow(d);
		su.addImplicitWait(d);
		d.get(URL);
		
		//login to app
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		d.findElement(By.id("submitButton")).click();
		
		// navigate to campaign link
		su.mouseOverAction(d, d.findElement(By.xpath("//a[.='More']")));
		su.clickOnAction(d, d.findElement(By.xpath("//a[@id='more' and @name='Campaigns']")));
		
		// click on campaign icon
		su.clickOnAction(d, d.findElement(By.xpath("//img[@alt='Create Campaign...']")));
		
		// fill details and clickon save button 
		d.findElement(By.name("campaignname")).sendKeys(CAMPAIGNNAME);
		d.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		// verification of campaign
		if(d.findElement(By.className("dvHeaderText")).getText().contains(CAMPAIGNNAME))
			System.out.println("PASS");
		else
			System.out.println("FAIL");
		
		// logout app and close browser
		su.mouseOverAction(d, d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		su.clickOnAction(d, d.findElement(By.linkText("Sign Out")));
		d.close();
	}

}
