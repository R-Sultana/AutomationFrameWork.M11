package objectRepository;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement createLeadsLookupImage;
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//business logic
	public void clickOnCreateLeadsLookupImage() {
		createLeadsLookupImage.click();
	}
}
