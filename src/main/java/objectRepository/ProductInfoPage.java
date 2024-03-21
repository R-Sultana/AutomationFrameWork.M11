package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {

	@FindBy(className = "lvtHeaderText")
	private WebElement productHeaderText;
	
	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductHeaderText() {
		return productHeaderText;
	}
	
	// business library
	public String captureProductHeaderText() {
		return productHeaderText.getText();
	}
}
