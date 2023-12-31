package vtiger.Organization.Tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateMUltipleOrgTest extends BaseClass {
	
	@Test(dataProvider = "OrgWithIndustry")
	public void createOrgTest(String ORG, String INDUSTRY) throws IOException
	{	
		String ORGNAME = ORG+jUtil.getRandomNumber();
				
		//Step 5: Navigate to Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
				
		//Step 6: Click on Create Organization Look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 7: Create organization with industry
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);
		
		//Step 8: Validate for Organization
		OrganizationInfoPage oip =new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeader();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader+" ---- PASS ----");
		}
		else
		{
			System.out.println(" ---- Failed ----");
		}	
	}
	
	@DataProvider(name = "OrgWithIndustry")
	public Object[][] getData() throws IOException
	{
		Object[][] data = eUtil.readDataFromExcelToDataProvider("dataProviderOrg");
		return data;
	}

}
