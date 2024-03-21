package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactImage;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateContactImage() {
		return createContactImage;
	}
	
	// Business Logic
	/**
	 * This method will click on create contact lookup image
	 */
	public void clickonCreateContactImage() {
		createContactImage.click();
	}
	
}
