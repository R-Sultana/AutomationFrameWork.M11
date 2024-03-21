package objectRepository;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage{

	@FindBy(name="productname")
	private WebElement productName;
	

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement vendorNameImage;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getVendorNameImage() {
		return vendorNameImage;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business logic
	/**
	 * This method will create new product and save it
	 * @param PRODUCTNAME
	 */
	public void createNewProduct(String PRODUCTNAME) {
		productName.sendKeys(PRODUCTNAME);
		saveBtn.click();
	}
	
	/**
	 * This method will click on vendor image 
	 */
	public void clickOnVendorImage(WebDriver driver) {
		vendorNameImage.click();
		
		}
	}

