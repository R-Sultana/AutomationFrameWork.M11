package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//Rule 1: Create a seperate POM class for every webpage
	
	// Rule 2: identify all web elements using @FindBy
	@FindBy(name="user_name") 
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Rule3: Create a constructor to initialize elements declared in POM page
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Rule4: Provide getter methods to access elements
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	//Business Logic---Generic method related to project
	/**
	 * This method will Login to the application
	 * @param USERNAME
	 * @param PASS
	 */
	public void loginToApp(String USERNAME, String PASS) {
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASS);
		loginBtn.click();
	}
	
	
}
