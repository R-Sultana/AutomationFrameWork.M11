package practice;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import genericUtilities.PropertyFileUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CheckFifthCheckBox {

	@Test
	public void checkFifthCheckBox() throws IOException {
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
		
		List<WebElement>cBoxes = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));
		System.out.println(cBoxes.size());
		for(int i=1;i<=cBoxes.size()-1;) {
			if(i==5) {
			cBoxes.get(i).click();
			}
			i=i+2;
		}
	}
}
