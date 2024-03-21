package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class HomePage extends SeleniumUtility{

	// find elements
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImage;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;
	
	@FindBy(linkText = "Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(xpath = "//a[.='More']")
	private WebElement moreLink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorsLink;
	
	// create constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//provides getter method
	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getAdminImage() {
		return adminImage;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
	

	public WebElement getLeadsLink(WebElement leadsLink) {
		return leadsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}
	
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}
	
	// Business Library

	/**
	 * This method will click on the contacts link on menu bar
	 */
	public void clickOnContactsLink() {
		contactLink.click();
	}
	
	/**
	 * This method will logout of the application
	 * @param driver
	 * @throws InterruptedException
	 */
	public void logoutOfApp(WebDriver driver) throws InterruptedException {
		mouseOverAction(driver, adminImage);
		Thread.sleep(1000);
		signoutLink.click();
	}
	
	/**
	 * This method will click on the leads link on menu bar
	 */
	public void clickOnLeadsLink() {
		leadsLink.click();
	}
	
	/**
	 * This method will click on the products link on menu bar
	 */
	public void clickOnProductsLink() {
		productsLink.click();
	}
	
	/**
	 * This method will navigate to more and click on campaigns link
	 * @param driver
	 * @throws InterruptedException
	 */
	public void clickOnCampaignsLink(WebDriver driver) throws InterruptedException {
		mouseOverAction(driver, moreLink);
		Thread.sleep(1000);
		campaignsLink.click();
	}
	
	/**
	 * This method will navigate to more and click on vendors link
	 * @param driver
	 * @throws InterruptedException
	 */
	public void clickOnVendorsLink(WebDriver driver) throws InterruptedException {
		mouseOverAction(driver, moreLink);
		Thread.sleep(1000);
		vendorsLink.click();
	}
}
