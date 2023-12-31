package vtiger.Organization.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateOrganizationTest extends BaseClass{

	@Test(groups =  "SmokeSuite")
	public void createOrgTest() throws IOException {

		String ORGNAME = eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNumber();
		
		//Step 5: Navigate to Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		Reporter.log("navigated to organization link",true);	//to print in both console and report
		
		//Step 6: Click on Create Organization Look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		Reporter.log("clicked on create organzation lookup image"); 	//to print in both report
		
		//Step 7: Create organization with mandatory Fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		Reporter.log("new organzation created");
		
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
		Reporter.log("organzation validated");

	}
	
	@Test
	public void demo()
	{
		System.out.println("This is demo");
	}
}
