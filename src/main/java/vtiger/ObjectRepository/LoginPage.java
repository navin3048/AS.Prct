package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Rule 1: Create a separate POM class for every web page
	
	//Rule 2: Identify all the web elements using annotations
	@FindBy(name = "user_name")
	private WebElement UserNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement PasswordEdt;
	
	@FindAll({@FindBy(id = "submitButton"),@FindBy(xpath = "//input[@type='submit']")})
	private WebElement SumbitBtn;
	
	//Rule 3: Initialize these web elements with a constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Provide getter to access these elements
	public WebElement getUserNameEdt() {
		return UserNameEdt;
	}

	public WebElement getPasswordEdt() {
		return PasswordEdt;
	}

	public WebElement getSumbitBtn() {
		return SumbitBtn;
	}
	
	//Rule 5: Business Library - Generic Methods - Project Specific			(Optional - If possible create it) additional feature
	/**
	 * This method will login to Applications
	 * @param USERNAME
	 * @param PASSWORD
	 */
	public void loginToApp(String USERNAME, String PASSWORD)
	{
		UserNameEdt.sendKeys(USERNAME);
		PasswordEdt.sendKeys(PASSWORD);
		SumbitBtn.click();
	}
	
	
	
}
