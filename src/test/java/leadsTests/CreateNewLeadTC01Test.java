package leadsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CreateNewLeadPage;
import objectRepository.HomePage;
import objectRepository.LeadInfoPage;
import objectRepository.LeadsPage;
import objectRepository.LoginPage;

public class CreateNewLeadTC01Test extends BaseClass{

	@Test(groups={"smokeTest"})
	public void createLeadWithMandatoryFields() throws IOException, InterruptedException {
		
		// read test data from excel file
		String LASTNAME= eUtil.readDataFromExcelFile("leads", 1, 2);
		String COMPANY= eUtil.readDataFromExcelFile("leads", 1, 3);
		
		// navigate lead link 
		HomePage hp= new HomePage(driver);
		hp.clickOnLeadsLink();
		
		//clickon create new lead lookup icon
		LeadsPage lp1= new LeadsPage(driver);
		lp1.clickOnCreateLeadsLookupImage();
		
		//create lead with mandatory field
		CreateNewLeadPage cnlp= new CreateNewLeadPage(driver);
		cnlp.createNewLead(LASTNAME, COMPANY);
		
		//Validation Lead name
		LeadInfoPage lip = new LeadInfoPage(driver);
		String LEADHEADER=lip.captureLeadHeaderText();
		Assert.assertTrue(LEADHEADER.contains(LASTNAME));
		
	}

}
