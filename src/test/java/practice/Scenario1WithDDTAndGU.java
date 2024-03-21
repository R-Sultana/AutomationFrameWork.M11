package practice;


import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class Scenario1WithDDTAndGU {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		PropertyFileUtility pu=new PropertyFileUtility();
		ExcelFileUtility eu= new ExcelFileUtility();
		SeleniumUtility su = new SeleniumUtility();
		
		
				//Read data from propert file
				String URL=pu.readDataFromPropertyFile("url");
				System.out.println(URL);
				String USER=pu.readDataFromPropertyFile("username");
				String PASS= pu.readDataFromPropertyFile("password");
				
				//lauch the browser with url
				WebDriver d=new ChromeDriver();
				su.maximizeWindow(d);
				su.addImplicitWait(d);
				d.get(URL);
				
				//login to app with valid credentials
//				d.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USER);
//				d.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASS);
//				d.findElement(By.xpath("//input[@id='submitButton']")).click();
//				System.out.println("login successful");
				
				LoginPage lp= new LoginPage(d);
				
				lp.loginToApp(USER, PASS);
//				lp.getUserNameEdt().sendKeys(USER);
//				lp.getPasswordEdt().sendKeys(PASS);
//				lp.getLoginBtn().click();
				
				
				
				//navigate to contacts module
				d.findElement(By.linkText("Contacts")).click();
				d.findElement(By.xpath("//img[contains(@title,'Contact')]")).click();
				
				// read test data from excel file and pass to test script
				String LASTNAME=eu.readDataFromExcelFile("contacts", 4, 2);
				d.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LASTNAME);
				d.findElement(By.xpath("//input[@name='button']")).click();
				
				//Verification for contact name
				WebElement contactHeader=d.findElement(By.className("dvHeaderText"));
				if(contactHeader.getText().contains(LASTNAME))
					System.out.println("PASS");
				else
					System.out.println("FAIL");
				
				// logout of the app
				WebElement acc=d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				WebElement signout=d.findElement(By.xpath("//a[.='Sign Out']"));
				su.mouseOverAction(d, acc);
				su.mouseOverAction(d, signout);
				System.out.println("logout successful");
				su.clickOnAction(d,signout);
				d.quit();
			
	}

}
