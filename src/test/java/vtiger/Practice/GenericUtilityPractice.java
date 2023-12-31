package vtiger.Practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class GenericUtilityPractice {
	
	public static void main(String[] args) throws IOException, Throwable {
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String data = pUtil.readDataFromPropertyFile("url");
		String data1 = pUtil.readDataFromPropertyFile("abcd");
		System.out.println(data);
		System.out.println(data1);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String value = eUtil.readDataFromExcel("Organization", 1, 2);
		System.out.println(value);
		
		eUtil.writeDataIntoExcel("Organization", 10, 7, value);
		System.out.println("Data added");
		
		
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getRandomNumber());
		
		System.out.println(jUtil.getSystemDate());
		
		System.out.println(jUtil.getSystemDateInFormat());
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.maximizeWindow(driver);
		Thread.sleep(2000);
		wUtil.minimizeWindow(driver);

		
	}

}
