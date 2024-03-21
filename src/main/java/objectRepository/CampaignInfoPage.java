package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage {

	@FindBy(className = "dvHeaderText")
	private WebElement campaignHeaderText;
	
	public CampaignInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignHeaderText() {
		return campaignHeaderText;
	}
	
	//business Library
	/**
	 * This method will capture campaign header text and return to caller
	 * @return
	 */
	public String captureCampaignHeaderText() {
		return campaignHeaderText.getText();
	}
}
