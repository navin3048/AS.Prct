package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoScript1 {

	public static void main(String[] args) throws IOException {
		
		//Step 1: Read all the necessary data
		/*Read the data from property file*/
		
		FileInputStream fisp = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fisp);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		Random ran = new Random();
		int value = ran.nextInt(10000);
		
		/*Read the data from excel sheet*/
		
		FileInputStream fise = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String ORGNAME = wb.getSheet("Organization").getRow(1).getCell(2).getStringCellValue()+value;
		wb.close();
		
		WebDriver driver = null;
		
		//Step 2: Launch the browser  - Runtime Polymorphism
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}	
		else
		{
			System.out.println("Invalid browser type");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		//Step 3: Login the App
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step 4: Navigate to Organizations Link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 5: Click on Create Organization LookUp image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 6: Create Organization with Mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//Step 7: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
		//Step 8: Validate for Organization
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader+"----PASS----");	
		}
		else
		{
			System.out.println(orgHeader+"----FAIl----");
		}
		
		//Step 9: Logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("signout successful");
		
		driver.quit();
	}
}