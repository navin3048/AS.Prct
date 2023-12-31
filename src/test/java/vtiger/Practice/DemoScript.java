package vtiger.Practice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoScript {

	public static void main(String[] args) {
		
		Random ran = new Random();
		int value = ran.nextInt(10000);
		
		//Step 1: Launch the browser
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		
		//Step 2: Login to the app
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();	
		
		//Step 3: Navigate to Organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4: Click on Create Organization Lookup image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 5: Create Organization with Mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("CSS CROP "+value);
		
		//Step 6: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 7: Validate for Organization
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains("CSS CROP"))
		{
			System.out.println(orgHeader+"----PASS----");	
		}
		else
		{
			System.out.println(orgHeader+"----FAIl----");
		}
		
		//Step 8: Logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign out successfully");

	}

}
