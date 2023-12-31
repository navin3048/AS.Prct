package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

/**
 * This class consists of all basic configuration annotations
 * @author kavya
 *
 */
public class BaseClass {
	
	//Step 1: Create Object of Generic Utilities
	
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
			
	public WebDriver driver =null;
	public static WebDriver sDriver;

	@BeforeSuite(alwaysRun = true)
	public void bsConfig()
	{
		System.out.println("----database connection successful----");
	}
	
	//@Parameters("browser")		//chrome or firefox
	//@BeforeTest
	@BeforeClass/*(groups = {"SmokeSuite","RegressionSuite"})*/(alwaysRun = true)		//alwaysrun true executes in all groups //in groups eecutes in specified group
	public void bcConfig(/*String BROWSER*/) throws IOException {
	
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		
		//Step 3: Launch the Browser - RUNTIME POLYMORPHISM
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
			System.out.println("--- "+BROWSER+" launched ---");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
			System.out.println("--- "+BROWSER+" launched ---");
		}
		else
		{
			System.out.println("Invalid browser name");
		}	
		
		sDriver = driver;
		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod(alwaysRun = true)
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("--- Login to App successful ---");
	}
	
	@AfterMethod(alwaysRun = true)
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("--- Logout of app successful ---");
	}
	
	//@AfterTest
	@AfterClass(alwaysRun = true)
	public void acConfig()
	{
		driver.quit();
		System.out.println("--- Browser closed ---");
	}
	
	@AfterSuite(alwaysRun = true)
	public void asConfig()
	{
		System.out.println("----database closed successfully----");
	}
}
