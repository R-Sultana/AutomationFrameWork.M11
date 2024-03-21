package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {

	@FindBy(xpath="//img[@title='Create Campaign...']")
	private WebElement createCampaignLookupImage;
	
	public CampaignsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateCampaignLookupImage() {
		return createCampaignLookupImage;
	}
	
	//business library
	/**
	 * This method will click on create campaign lookup icon
	 */
	public void clickOnCampaignLookupimage() {
		createCampaignLookupImage.click();
	}
}
