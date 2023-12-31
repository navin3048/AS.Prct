package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {	//Rule 1: Create a separate POM class for every web page
	
	//Rule 2: Identify all the web elements using annotations
	
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;
	
	//Rule 3: Initialize these web elements with a constructor
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Rule 4: Provide getter to access these elements
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//Rule 5: Business Library - Generic Methods - Project Specific			(Optional - If required)
	/**
	 * This method will click on Organizations link
	 */
	public void clickOnOrganizationLink()
	{
		OrganizationsLnk.click();
	}
	
	/**
	 * This method will click on Contacts link
	 */
	public void clickOnContactLink()
	{
		ContactsLnk.click();
	}
	
	/**
	 *  This method will perform sign out operation on web app
	 * @param driver
	 */
	public void logoutOfApp(WebDriver driver)
	{
		mouseHoverAction(driver, AdministratorImg);
		SignOutLnk.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
