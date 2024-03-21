package productsTests;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CreateNewProductPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ProductsPage;
import objectRepository.VendorsPopUpInProductPage;

public class VerifyVendorNameITTC02Test extends BaseClass {

	@Test
	public void verifyVendorNameITTC02() throws IOException, InterruptedException {
	
		
		//read data from excel file
		String VENDORNAME = eUtil.readDataFromExcelFile("products", 4, 2);
		
		//navigate to product link
		HomePage hp= new HomePage(driver);
		hp.clickOnProductsLink();
		
		//clickon Create new product icon
		ProductsPage pp = new ProductsPage(driver);
		pp.clickonCreateProductImage();
		
		// capture the current window
		String parent= driver.getWindowHandle();
		
		// click on vendor name lookup icon
		CreateNewProductPage cnpp = new CreateNewProductPage(driver);
		cnpp.clickOnVendorImage(driver);
		sUtil.waitForNumberOfWindows(driver, 2);
	
		//validation for vendor name
		Set<String> windows= driver.getWindowHandles();
		for(String w : windows) {
			driver.switchTo().window(w);
			if(!driver.getWindowHandle().contains(parent)) {
				VendorsPopUpInProductPage vppp = new VendorsPopUpInProductPage(driver);
				//if(vppp.getVendorName().isDisplayed())
				Assert.assertTrue(vppp.captureVendorNamePopup().contains(VENDORNAME));
				driver.close();
			}
		}
		driver.switchTo().window(parent);
		
		

	}
}

