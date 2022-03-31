package com.saucelabs.scripts;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.automationconstants.AutomationConstants;
import com.saucedemo.pages.Inventory;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.testbase.TestBase;
import com.saucelabs.excelutility.ExcelUtility;

public class TestClass extends TestBase
{
	LoginPage objLoginPage;
	Inventory objInventory;
	@Test(priority = 1)
	public void verifyValidLogin() throws IOException
	{
		objLoginPage = new LoginPage(driver);
		String username = ExcelUtility.getCellData(1, 0);
		String password = ExcelUtility.getCellData(1, 1);
		objLoginPage.Login(username, password);
		String urlActual = driver.getCurrentUrl();
		String urlExpected = AutomationConstants.INVENTORYPAGE;
		Assert.assertEquals(urlActual,urlExpected);
	}
	
	@Test(priority = 2)
	public void verifyInvalidLogin() throws IOException, InterruptedException
	{   
		objInventory = new Inventory(driver);
		objInventory.LogOut();
		Thread.sleep(2000);
		objLoginPage = new LoginPage(driver);
		
		String username = ExcelUtility.getCellData(5, 0);
		String password = ExcelUtility.getCellData(5, 1);
		objLoginPage.Login(username, password);
		Thread.sleep(2000);
		WebElement warn = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
		String actualResult = warn.getText();
		String expectedResult = AutomationConstants.LOGINERROR;
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	
	@Test(priority = 3)
	public void verifyValidLoginLockedOutUser() throws InterruptedException, IOException
	{
		
		objLoginPage = new LoginPage(driver);
		
		String username = ExcelUtility.getCellData(2, 0);
		String password = ExcelUtility.getCellData(1, 1);
		objLoginPage.Login(username, password);
		Thread.sleep(2000);
		WebElement warn = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
		String actualResult = warn.getText();
		String expectedResult = AutomationConstants.LOCKEDOUTERROR;
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(priority = 4)
	public void verifyValidLoginProblemUser() throws IOException
	{
		objLoginPage = new LoginPage(driver);
		String username = ExcelUtility.getCellData(3, 0);
		String password = ExcelUtility.getCellData(1, 1);
		objLoginPage.Login(username, password);
		String urlActual = driver.getCurrentUrl();
		String urlExpected = AutomationConstants.INVENTORYPAGE;
		Assert.assertEquals(urlActual,urlExpected);
	}
  @Test(priority = 5)
  public void verifyValidLoginPerformanceGlitchUser() throws IOException, InterruptedException
  {
	    objInventory = new Inventory(driver);
		objInventory.LogOut();
		Thread.sleep(2000);
		objLoginPage = new LoginPage(driver);
		
	    objLoginPage = new LoginPage(driver);
		String username = ExcelUtility.getCellData(4, 0);
		String password = ExcelUtility.getCellData(1, 1);
		objLoginPage.Login(username, password);
		String urlActual = driver.getCurrentUrl();
		String urlExpected = AutomationConstants.INVENTORYPAGE;
		Assert.assertEquals(urlActual,urlExpected);
		
		objInventory = new Inventory(driver);
		objInventory.LogOut();
		
		
  }
  
}
