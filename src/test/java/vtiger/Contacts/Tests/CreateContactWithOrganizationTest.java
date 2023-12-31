package vtiger.Contacts.Tests;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.OrganizationInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass{

	@Test(groups = "RegressionSiute")
	public void createContactWithOrgTest() throws IOException {								
		
		String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 3)+ jUtil.getRandomNumber();
		
		//Step 5: Navigate to Organizations link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 6: Click on Create Organization Look up Image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		//Step 7: Create organization with mandatory Fields
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
	
		//Step 8: Validate for Organization
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String OrgHeader = oip.getOrganizationHeader();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader+" ---- Organization Created ----");
		}
		else
		{
			System.out.println(" ---- Organization Creatio Failed ----");
		}
		
		// Step 10: Navigate Contacts Link
		hp.clickOnContactLink();

		// Step 11: Click on create Contact Look Up Image
		ContactsPage cp =new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImage();

		// Step 12: Create contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		
		//Step 12: Validate for Contact
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.getContactHeader();
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println(contactHeader+" ---- PASS ----");
		}
		else
		{
			System.out.println(" ---- Failed ----");
		}	
		
	}

}
