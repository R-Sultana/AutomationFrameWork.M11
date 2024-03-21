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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario3DDT {

	public static void main(String[] args) throws IOException {
		
		// step1:Read data from property file and excel file
		
		FileInputStream fisp= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p= new Properties();
		p.load(fisp);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("campaigns");
		String CAMPAIGNNAME = sh.getRow(1).getCell(2).getStringCellValue();
		
		//step2: launch browser and navigate to url
		WebDriver d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		d.get(URL);
		
		//step3: login to app with valid credentials 
		d.findElement(By.name("user_name")).sendKeys(USERNAME);
		d.findElement(By.name("user_password")).sendKeys(PASSWORD);
		d.findElement(By.id("submitButton")).click();
		
		//step4: navigate campaign module and click on create campaign icon
		Actions act= new Actions(d);
		act.moveToElement(d.findElement(By.xpath("//a[text()='More']"))).click(d.findElement(By.xpath("//a[@name='Campaigns']")));
		d.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		
		//step5: fill mandatory details and save it
		d.findElement(By.name("campaignname")).sendKeys(CAMPAIGNNAME);
		d.findElement(By.className("crmButton")).click();
		
		//step6: verify campaign
		if(d.findElement(By.className("dvHeaderText")).getText().contains(CAMPAIGNNAME))
			System.out.println("PASS"+d.findElement(By.className("dvHeaderText")));
		else
			System.out.println("FAIL");
		
		//step7: logout app and close browser
		Actions act1 = new Actions(d);
		act1.moveToElement(d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		act1.click(d.findElement(By.xpath("//a[text()='Sign Out']"))).perform();
		d.quit();
		
		
	}

}
