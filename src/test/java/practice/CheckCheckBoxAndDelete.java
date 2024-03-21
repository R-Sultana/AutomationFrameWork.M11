package practice;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CheckCheckBoxAndDelete {

	@Test
	public void checkAndDeleteContact() throws IOException, InterruptedException {
		PropertyFileUtility pu = new PropertyFileUtility();
		SeleniumUtility su = new SeleniumUtility();
		String USERNAME = pu.readDataFromPropertyFile("username");
		String PASSWORD = pu.readDataFromPropertyFile("password");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/index.php?module=Campaigns&action=index");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		
		List<WebElement> contacts = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
		for(int i=1;i<=contacts.size()-1;i++) {
			if(i==6) {
				contacts.get(i).click();
				Thread.sleep(1000);
				WebElement deleteBtn = driver.findElement(By.xpath("//input[contains(@class,'delete')]"));
				su.clickOnAction(driver,deleteBtn );
				su.acceptAlert(driver);
			}
		}
	}
}
