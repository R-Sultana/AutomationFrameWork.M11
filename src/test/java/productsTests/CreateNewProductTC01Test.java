package productsTests;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CreateNewProductPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ProductInfoPage;
import objectRepository.ProductsPage;

public class CreateNewProductTC01Test extends BaseClass {

	@Test(groups="RegressionSuite")
	public void createProductWithMandatoryfields() throws IOException, InterruptedException  {
				// read testdata from excel file
				String PRODUCTNAME = eUtil.readDataFromExcelFile("products", 1, 2);
				
				//navigate to product link
				HomePage hp= new HomePage(driver);
				hp.clickOnProductsLink();
				
				//clickon Create new product icon
				ProductsPage pp = new ProductsPage(driver);
				pp.clickonCreateProductImage();
				
				// create product with mandatory field
				CreateNewProductPage cnpp= new CreateNewProductPage(driver);
				cnpp.createNewProduct(PRODUCTNAME);
				
				//validation for product name
				ProductInfoPage pi = new ProductInfoPage(driver);
				String PRODUCTHEADER=pi.captureProductHeaderText();
				Assert.assertTrue(PRODUCTHEADER.contains(PRODUCTNAME));
				System.out.println(PRODUCTHEADER);	
			}

	}


