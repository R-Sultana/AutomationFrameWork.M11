package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	@FindBy(className = "dvHeaderText")
	private WebElement contactHeaderText;
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	
	// Business Library
	
	/**
	 * This method will capture contact header text and return value to caller
	 * @return
	 */
	public String captureContactHeader() {
		return contactHeaderText.getText();
	}	
	
}
