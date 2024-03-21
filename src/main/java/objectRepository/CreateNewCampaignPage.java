package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class CreateNewCampaignPage extends SeleniumUtility{

	@FindBy(name="campaignname")
	private WebElement campaignName;
	
	@FindBy(name="campaigntype")
	private WebElement campaignTypeDropDown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getCampaignTypeDropDown() {
		return campaignTypeDropDown;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business logic

	/**
	 * This method will create campaign with mandatory fields and save it
	 * @param CAMPAIGNNAME
	 */
	public void createNewCampaign(String CAMPAIGNNAME) {
		campaignName.sendKeys(CAMPAIGNNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create campaign and save it
	 * @param CAMPAIGNNAME
	 * @param CAMPAIGNTYPE
	 */
	public void createNewCampaign(String CAMPAIGNNAME,String CAMPAIGNTYPE) {
		campaignName.sendKeys(CAMPAIGNNAME);
		handleDropDown(campaignTypeDropDown, CAMPAIGNTYPE);
		saveBtn.click();
	}
}
