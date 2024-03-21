package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.ExcelFileUtility;

public class VendorsPopUpInProductPage {
	
	@FindBy(linkText = "Raju")
	private WebElement vendorName;
	
	public VendorsPopUpInProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorName() {
		return vendorName;
	}
	
	//business logic
	
	/**
	 * This method will capture the vendor name and return to caller
	 * @return
	 */
	public String captureVendorNamePopup() {
		return vendorName.getText();
	}
	
}
