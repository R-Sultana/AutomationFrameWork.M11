package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {

	@FindBy(className = "lvtHeaderText")
	private WebElement vendorHeaderText;
	
	public VendorInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorHeaderText() {
		return vendorHeaderText;
	}
	
	//business logic
	
	/**
	 * This method will capture newly created vendor header text and return to caller
	 * @return
	 */
	public String captureVendorHeaderText() {
		return vendorHeaderText.getText();
	}
}
