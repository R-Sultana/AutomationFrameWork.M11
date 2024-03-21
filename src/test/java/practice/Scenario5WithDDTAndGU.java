package practice;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;

public class Scenario5WithDDTAndGU {

	public static void main(String[] args) throws IOException {
		
		// create objects of all utility classes
		PropertyFileUtility pu= new PropertyFileUtility();
		ExcelFileUtility eu= new ExcelFileUtility();
		SeleniumUtility su= new SeleniumUtility();
		
		// read data from property file and excel file
		String VENDORNAME = eu.readDataFromExcelFile("products", 4, 2);
		
		// open browser and login app
		WebDriver d= new ChromeDriver();
		su.maximizeWindow(d);
		su.addImplicitWait(d);
		d.get(pu.readDataFromPropertyFile("url"));
		d.findElement(By.xpath("//input[@name='user_name']")).sendKeys(pu.readDataFromPropertyFile("username"));
		d.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pu.readDataFromPropertyFile("password"));
		d.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//navigate to product link
		d.findElement(By.linkText("Products")).click();
		d.findElement(By.xpath("//img[@title='Create Product...']")).click();
		
		// click on vendor icon
		d.findElement(By.xpath("//img[@title='Select']")).click();
		su.waitForNumberOfWindows(d, 2);
		String parent = d.getWindowHandle();
		Set<String> w=d.getWindowHandles();
		for(String e:w) {
			d.switchTo().window(e);
			if(!d.getWindowHandle().contains(parent)) {
				if(d.findElement(By.xpath("//a[.='"+VENDORNAME+"']")).isDisplayed()) {
					System.out.println("PASS,displayed vendor name is :"+VENDORNAME);
				}
				else
					System.out.println("FAIL");
				d.close();
			}
			d.switchTo().window(parent);
		}
		
		// logout app and close browser
		su.mouseOverAction(d, d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		su.clickOnAction(d, d.findElement(By.linkText("Sign Out")));
		d.quit();	
	}

}
