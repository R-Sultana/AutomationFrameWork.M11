package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewLeadPage extends SeleniumUtility{

	@FindBy(name = "lastname")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@name='company']")
	private WebElement company;
	
	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDropDown;
	
	@FindBy(xpath = "//input[contains(@class,'save')]")
	private WebElement saveBtn;
	
	public CreateNewLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business logic
	/**
	 * This method will create lead with mandatory fields and save it
	 * @param LASTNAME
	 * @param COMPANY
	 */
	public void createNewLead(String LASTNAME,String COMPANY) {
		lastName.sendKeys(LASTNAME);
		company.sendKeys(COMPANY);
		saveBtn.click();
	}
	
	/**
	 * This method will create lead and save it
	 * @param LASTNAME
	 * @param COMPANY
	 * @param INDUSTRY
	 */
	public void createNewLead(String LASTNAME,String COMPANY,String INDUSTRY) {
		lastName.sendKeys(LASTNAME);
		company.sendKeys(COMPANY);
		handleDropDown(industryDropDown, INDUSTRY);
		saveBtn.click();
	}
}
