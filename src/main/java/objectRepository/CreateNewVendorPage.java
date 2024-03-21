package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {

	@FindBy(name="vendorname")
	private WebElement vendorName;
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phone;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	public CreateNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getVendorName() {
		return vendorName;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business logic
	/**
	 * This method will create new vendor with vendor name and save it
	 * @param VENDORNAME
	 */
	public void createNewVendor(String VENDORNAME) {
		vendorName.sendKeys(VENDORNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will create new vendor with vendor name and phone and save it
	 * @param VENDORNAME
	 * @param PHONE
	 */
	public void createNewVendor(String VENDORNAME,String PHONE) {
		vendorName.sendKeys(VENDORNAME);
		phone.sendKeys(PHONE);
		saveBtn.click();
	}
}
