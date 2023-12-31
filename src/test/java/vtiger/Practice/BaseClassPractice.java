package vtiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice {
	
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("before suite");
	}
	
	@AfterSuite
	public void asConfig()
	{
		System.out.println("after suite");
	}
	
	@BeforeClass
	public void bcConfig()
	{
		System.out.println("before class");
	}
	
	@AfterClass
	public void acConfig()
	{
		System.out.println("after class");
	}
	
	@BeforeMethod
	public void bmConfig()
	{
		System.out.println("before method");
	}

	@AfterMethod
	public void amConfig()
	{
		System.out.println("after method");
	}
	
	@Test
	public void test()
	{
		System.out.println("test");
	}
	
	@Test
	public void test2()
	{
		System.out.println("test2");
	}
}
