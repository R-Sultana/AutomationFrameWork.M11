package vendorsTests;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CreateNewVendorPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.VendorInfoPage;
import objectRepository.VendorsPage;

public class CreateNewVendorTC01Test extends BaseClass {

	@Test
	public void createVendorWithMandatoryFields() throws IOException, InterruptedException {
				
				//read data from excel file 
				String VENDORNAME=eUtil.readDataFromExcelFile("vendors", 1, 2);
				
				//navigate to vendor link
				HomePage hp = new HomePage(driver);
				hp.clickOnVendorsLink(driver);
				
				// clickon create vendor icon
				VendorsPage vp = new VendorsPage(driver);
				vp.clickOnCreateVendorLookupImage();
				
				// fill details and click on save
				CreateNewVendorPage cnvp = new CreateNewVendorPage(driver);
				cnvp.createNewVendor(VENDORNAME);
				
				//validation for vendors
				VendorInfoPage vi = new VendorInfoPage(driver);
				String VENDORHEADER=vi.captureVendorHeaderText();
				Assert.assertTrue(VENDORHEADER.contains(VENDORNAME));
			

	}

}
