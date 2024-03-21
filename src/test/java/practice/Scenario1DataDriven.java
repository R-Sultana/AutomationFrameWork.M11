package practice;

import java.io.File;
import java.io.FileInputStream;
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


public class Scenario1DataDriven {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Read data from propert file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		System.out.println(URL);
		String USER=p.getProperty("username");
		String PASS= p.getProperty("password");
		
		//lauch the browser with url
		WebDriver d=new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		d.get(URL);
		
		//login to app with valid credentials
		d.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USER);
		d.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASS);
		d.findElement(By.xpath("//input[@id='submitButton']")).click();
		System.out.println("login successful");
		
		//navigate to contacts module
		d.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		d.findElement(By.xpath("//img[contains(@title,'Create Contact...')]")).click();
		
		// read test data from excel file and pass to test script
		FileInputStream fisExcel=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
		Sheet sh = wb.getSheet("contacts");
		Row r = sh.getRow(1);
		Cell c=r.getCell(2);
		String lastname= c.getStringCellValue();
		
		
		d.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		d.findElement(By.xpath("//input[@name='button']")).click();
		
		//Verification for contact name
		WebElement contactHeader=d.findElement(By.className("dvHeaderText"));
		if(contactHeader.getText().contains(lastname))
			System.out.println("PASS");
		else
			System.out.println("FAIL");
		
		// logout of the app
		WebElement acc=d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act= new Actions(d);
		WebElement signout=d.findElement(By.xpath("//a[text()='Sign Out']"));
		act.moveToElement(acc).perform();
		Thread.sleep(1000);
		act.moveToElement(signout).click().perform();
		d.quit();
	}

}
