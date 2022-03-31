package com.saucedemo.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

public class TestBase 
{public static WebDriver driver;
public static Properties prop = null;
String driverPath = "D:\\chromedriver\\chromedriver.exe";
public static void TestBase()
{
	try 
	{
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources" + "/config.properties"); 
		prop.load(ip);
	}
	
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	
	catch(IOException e)
	{
		e.printStackTrace();
	}
}

@BeforeTest
public void onSetUp()
{
   TestBase();
   String BrowserName = prop.getProperty("browser");
   if(BrowserName.equals("chrome"))
   {
	   System.setProperty("webdriver.chrome.driver", driverPath);
	   driver = new ChromeDriver();
   }
   
   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   driver.get(prop.getProperty("url"));
   driver.manage().window().maximize();

}
@AfterMethod
public void tearDown(ITestResult iTestResult) throws IOException
{
	 if(iTestResult.FAILURE == iTestResult.getStatus())
	 {
		 takeScreenshot(iTestResult.getName());
	 }
}

public String takeScreenshot (String Name) throws IOException
{
	 String DateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	 File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 String Destination = System.getProperty("user.dir") + "\\target\\" + Name + DateName;
	 File finalDestination = new File(Destination);
	 org.openqa.selenium.io.FileHandler.copy(source,finalDestination);
	 return Destination;
	 
}
@AfterSuite
public void quitBrowser()
{
	 driver.quit();
}

}



