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
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CaptureLastCheckBox {

	@Test
	public void checkLastCheckBox() throws IOException {
		PropertyFileUtility pu = new PropertyFileUtility();
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
		for(int i= contacts.size()-1;i>=1;i++) {
			if(i== contacts.size()-1) {
				contacts.get(i).click();
			}
		}
	}
}
