package campaignsTests;

import java.io.IOException;

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
import objectRepository.CampaignInfoPage;
import objectRepository.CampaignsPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewCampaignPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateNewCampaignTC01Test extends BaseClass {

	@Test
	public void createCampaignWithMandatoryFields() throws IOException, InterruptedException
	 {
			
				// read data from excel file
				String CAMPAIGNNAME=eUtil.readDataFromExcelFile("campaigns", 1, 2);
				
				// navigate to campaign link
				HomePage hp = new HomePage(driver);
				hp.clickOnCampaignsLink(driver);
				
				// click on campaign icon
				CampaignsPage cp= new CampaignsPage(driver);
				cp.clickOnCampaignLookupimage();
				
				// create campaign and fill details and clickon save button 
				CreateNewCampaignPage cncp= new CreateNewCampaignPage(driver);
				cncp.createNewCampaign(CAMPAIGNNAME);
				
				// verification of campaign
				CampaignInfoPage ci = new CampaignInfoPage(driver);
				String CAMPAIGNHEADER= ci.captureCampaignHeaderText();
				Assert.assertTrue(CAMPAIGNHEADER.contains(CAMPAIGNNAME));
				System.out.println(CAMPAIGNHEADER);
			

	}

}
