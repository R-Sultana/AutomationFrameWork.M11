package campaignsTests;

import java.io.IOException;

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
import objectRepository.CreateNewCampaignPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateNewCampaignTC02Test extends BaseClass{

	@Test
	public void createNewCampaignWithCampaignType() throws IOException, InterruptedException {
		//read test data from excel file
		String CAMPAIGNNAME = eUtil.readDataFromExcelFile("campaigns", 4, 2);
		String CAMPAIGNTYPE = eUtil.readDataFromExcelFile("campaigns", 4, 3);
		
		
		// navigate to campaign link and clickon create campaign and filll deatils and save
		HomePage hp = new HomePage(driver);
		hp.clickOnCampaignsLink(driver);
		
		CampaignsPage cp = new CampaignsPage(driver);
		cp.clickOnCampaignLookupimage();
		
		CreateNewCampaignPage cncp = new CreateNewCampaignPage(driver);
		cncp.createNewCampaign(CAMPAIGNNAME, CAMPAIGNTYPE);
		
		CampaignInfoPage cip = new CampaignInfoPage(driver);
		String CAMPAIGNHEADER = cip.captureCampaignHeaderText();
		
		Assert.assertTrue(CAMPAIGNHEADER.contains(CAMPAIGNNAME));
	
	}
}
