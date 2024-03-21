package contactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenerImplementation.class)
public class CreateNewContactTC01Test extends BaseClass {

	@Test(groups="smokeTest")
	public void createContactWithMandatoryFields() throws IOException, InterruptedException
	 {
				
				// read test data from excel file and pass to test script
				String LASTNAME=eUtil.readDataFromExcelFile("contacts", 1, 2);
				
				//navigate to contacts module
				HomePage hp= new HomePage(driver);
				hp.clickOnContactsLink();
				
				// clickon create contact look up icon
				ContactsPage cp= new ContactsPage(driver);
				cp.clickonCreateContactImage();
				
				// create contact with mandatory field and save
				CreateNewContactPage cncp= new CreateNewContactPage(driver);
				cncp.createNewContact(LASTNAME);
				
				//Assert.fail();
				
				//Verification for contact name
				ContactInfoPage cip = new ContactInfoPage(driver);
				String CONTACTHEADER= cip.captureContactHeader();
				Assert.assertTrue(CONTACTHEADER.contains(LASTNAME));
				System.out.println(CONTACTHEADER);
				
			
	}

	}


