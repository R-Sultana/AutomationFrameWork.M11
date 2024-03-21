package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProductLookupImage;
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProductLookupImage() {
		return createProductLookupImage;
	}
	
	//business logic
	
	public void clickonCreateProductImage() {
		createProductLookupImage.click();
	}
}
