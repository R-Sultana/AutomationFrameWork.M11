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

public class Scenario2DDT {

	public static void main(String[] args) throws IOException {
		
		// step1:read data from property file and excel file
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fisp);
		String URL=p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh=wb.getSheet("leads");
		String LASTNAME = sh.getRow(1).getCell(2).getStringCellValue();
		String COMPANY = sh.getRow(1).getCell(3).getStringCellValue();
		
		//step2: launch browser with url
		WebDriver d= new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		d.get(URL);
		
		//step3:login to app with valid credentials
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		d.findElement(By.id("submitButton")).click();
		
		//step4:navigate to lead modules and clickon create lead icon
		d.findElement(By.xpath("//a[text()='Leads']")).click();
		d.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		
		//step5:fill details and save
		d.findElement(By.name("lastname")).sendKeys(LASTNAME);
		d.findElement(By.xpath("//input[@name='company']")).sendKeys(COMPANY);
		d.findElement(By.name("button")).click();
		
		//step6: verify lead
		String leadData = d.findElement(By.className("dvHeaderText")).getText();
		if(leadData.contains(LASTNAME))
			System.out.println("PASS"+leadData);
		else
			System.out.println("FAIL");
		
		//step7:logout of the app
		WebElement ACCOUNT = d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebElement SIGNOUT=d.findElement(By.xpath("//a[text()='Sign Out']"));
		Actions act= new Actions(d);
		act.moveToElement(ACCOUNT).click(SIGNOUT).perform();
		d.quit();
		
		
	}

}
