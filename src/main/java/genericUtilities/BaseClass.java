package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass {
	
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public SeleniumUtility sUtil = new SeleniumUtility();
	public WebDriver driver;
	
	public static WebDriver sDriver;
	
	@BeforeSuite(groups={"smokeTest","RegressionSuite"})
	public void bsConfig() {
		System.out.println("====DB Connection Successful=====");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(alwaysRun = true)
	public void bcConfig(/*String BROWSER*/) throws IOException {
		String URL = pUtil.readDataFromPropertyFile("url");
		driver= new ChromeDriver();
//		if(BROWSER.equalsIgnoreCase("Chrome")) {
//			driver = new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("Firefox")) {
//			driver = new FirefoxDriver();
//		}
//		else {
//			driver = new ChromeDriver();
//			System.out.println("Lauched default browser");
//		}
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitWait(driver);
		driver.get(URL);
		
		sDriver=driver;
		System.out.println("====Launch Browser Successful====");
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException {
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD= pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("====Login to app Successful====");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("====Logout Successful====");
	}
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig() {
		driver.quit();
		System.out.println("====Browser Closure Successful====");
	}
	@AfterSuite(alwaysRun = true)
	public void asConfig() {
		System.out.println("====DB closure Successful====");
	}

}
