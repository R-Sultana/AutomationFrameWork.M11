package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility {

	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getleadSourceDropDown() {
		return leadSourceDropDown;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	// Business Logic
	/**
	 * This method will fill contacts mandatory field and save it
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME) {
		lastName.sendKeys(LASTNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create a new contact with lead source dropdown and save it
	 * @param LASTNAME
	 * @param LEADSOURCE
	 */
	public void createNewContact(String LASTNAME, String LEADSOURCE) {
		lastName.sendKeys(LASTNAME);
		handleDropDown(leadSourceDropDown, LEADSOURCE);
		saveBtn.click();
	}
}
