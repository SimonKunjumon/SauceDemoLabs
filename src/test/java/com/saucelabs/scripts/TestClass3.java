package com.saucelabs.scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.saucedemo.automationconstants.AutomationConstants;
import com.saucedemo.pages.CheckOutComplete;
import com.saucedemo.pages.CheckOutOne;
import com.saucedemo.pages.CheckOutTwo;
import com.saucedemo.pages.Inventory;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.cart;
import com.saucedemo.testbase.TestBase;
import com.saucelabs.excelutility.ExcelUtility;

public class TestClass3 extends TestBase
{
	LoginPage objLoginPage3;
	Inventory objInventory3;
	cart objCart3;
	CheckOutOne objCheckOutOne2;
	CheckOutTwo objCheckOutTwo2;
	CheckOutComplete objCheckOutComplete2;
	@Test(priority = 15)
	public void verifyAddItemPerformanceGlitchUser() throws InterruptedException, IOException
	{
		
		
	    objLoginPage3 = new LoginPage(driver);
	    String username = ExcelUtility.getCellData(4, 0);
	    String password = ExcelUtility.getCellData(1, 1);
	    objLoginPage3.Login(username, password);
	    
	    objInventory3 = new Inventory(driver);
	    objInventory3.AddToCart();
	    WebElement cart = driver.findElement(By.className("shopping_cart_badge"));
	    String actualResult = cart.getText();
	    String expectedResult = AutomationConstants.CARTPOP;
	    Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test(priority = 16)
	public void verifyValidCheckOutPerformanceGlitchUser() throws IOException
	{
		objInventory3 = new Inventory(driver);
		objInventory3.CartClick();
		objCart3 = new cart(driver);
		objCart3.CartCheckOut();
		objCheckOutOne2 = new CheckOutOne(driver);
		String firstname = ExcelUtility.getCellData(1, 2);
		String lastname = ExcelUtility.getCellData(1, 3);
		String zip = ExcelUtility.getCellData(1, 4);
		objCheckOutOne2.fillInCheckOutForm(firstname, lastname, zip);
		objCheckOutOne2.clickContinue();
		objCheckOutTwo2 = new CheckOutTwo(driver);
		objCheckOutTwo2.clickFinish();
		
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = AutomationConstants.FINALPAGE;
		Assert.assertEquals(currentUrl, expectedUrl);
		
		objCheckOutComplete2 = new CheckOutComplete(driver);
		objCheckOutComplete2.clickHome();
		
		
	}
	@Test(priority = 17)
	public void verifyCheckOutFormValidationPerformanceGlitchUser() throws IOException
	{
		objInventory3 = new Inventory(driver);
		objInventory3.CartClick();
		objCart3 = new cart(driver);
		objCart3.CartCheckOut();
		objCheckOutOne2 = new CheckOutOne(driver);
		String firstname = "";
		String lastname =  ExcelUtility.getCellData(1, 3);
		String zip = ExcelUtility.getCellData(1, 4);
		objCheckOutOne2.fillInCheckOutForm(firstname, lastname, zip);
		objCheckOutOne2.clickContinue();
		WebElement formvalidation = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
		String actualResult = formvalidation.getText();
		String expectedResult = AutomationConstants.FIRSTNAMEERROR;
		Assert.assertEquals(actualResult, expectedResult);
	}
@Test(priority = 17)
	
	public void verifyCheckOutFormValidation1PerformanceGlitchUser() throws IOException
	{
		objInventory3 = new Inventory(driver);
		objInventory3.CartClick();
		objCart3 = new cart(driver);
		objCart3.CartCheckOut();
		objCheckOutOne2 = new CheckOutOne(driver);
		String firstname = ExcelUtility.getCellData(1, 2);
		String lastname =  "";
		String zip = ExcelUtility.getCellData(1, 4);
		objCheckOutOne2.fillInCheckOutForm(firstname, lastname, zip);
		objCheckOutOne2.clickContinue();
		WebElement formvalidation = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
		String actualResult = formvalidation.getText();
		String expectedResult = AutomationConstants.LASTNAMEERROR;
		Assert.assertEquals(actualResult, expectedResult);
	}
@Test(priority = 18)
public void verifyCheckOutFormValidation2PerformanceGlitchUser() throws IOException
{
	objInventory3 = new Inventory(driver);
	objInventory3.CartClick();
	objCart3 = new cart(driver);
	objCart3.CartCheckOut();
	objCheckOutOne2 = new CheckOutOne(driver);
	String firstname = ExcelUtility.getCellData(1, 2);
	String lastname =  ExcelUtility.getCellData(1, 3);
	String zip = "";
	objCheckOutOne2.fillInCheckOutForm(firstname, lastname, zip);
	objCheckOutOne2.clickContinue();
	WebElement formvalidation = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
	String actualResult = formvalidation.getText();
	String expectedResult = AutomationConstants.POSTALCODEERROR;
	Assert.assertEquals(actualResult, expectedResult);
	
}

@Test(priority = 19)
public void verifyInvalidFormValuesPerformanceGlitchUser() throws IOException
{
	objCheckOutOne2 = new CheckOutOne(driver);
	String firstname = ExcelUtility.getCellData(2, 2);
	String lastname =  ExcelUtility.getCellData(2, 3);
	String zip = ExcelUtility.getCellData(1, 4);
	objCheckOutOne2.fillInCheckOutForm(firstname, lastname, zip);
	objCheckOutOne2.clickContinue();
	String currentUrl = driver.getCurrentUrl();
	String expectedUrl = AutomationConstants.CHECKOUTSTEPONE;
	Assert.assertEquals(currentUrl, expectedUrl);
	
}

@Test(priority = 20)

public void verifyInvalidFormValues1PerformanceGlitchUser() throws IOException
{   
	objCheckOutOne2 = new CheckOutOne(driver);
	objCheckOutOne2.clickCancel();
	
	objInventory3 = new Inventory(driver);
	objInventory3.CartClick();
	objCart3 = new cart(driver);
	objCart3.CartCheckOut();
	objCheckOutOne2 = new CheckOutOne(driver);
	
	String firstname = ExcelUtility.getCellData(3, 2);
	String lastname =  ExcelUtility.getCellData(3, 3);
	String zip = ExcelUtility.getCellData(1, 4);
	objCheckOutOne2.fillInCheckOutForm(firstname, lastname, zip);
	objCheckOutOne2.clickContinue();
	String currentUrl = driver.getCurrentUrl();
	String expectedUrl = AutomationConstants.CHECKOUTSTEPONE;
	Assert.assertEquals(currentUrl, expectedUrl);
	
	
	
}

@Test(priority = 21)
public void verifyInvalidFormValues2PerformanceGlitchUser() throws IOException, InterruptedException
{
	objCheckOutOne2 = new CheckOutOne(driver);
	objCheckOutOne2.clickCancel();
	
	objInventory3 = new Inventory(driver);
	objInventory3.CartClick();
	objCart3 = new cart(driver);
	objCart3.CartCheckOut();
	objCheckOutOne2 = new CheckOutOne(driver);
	
	String firstname = ExcelUtility.getCellData(1, 2);
	String lastname =  ExcelUtility.getCellData(1, 3);
	String zip = ExcelUtility.getCellData(3, 4);
	objCheckOutOne2.fillInCheckOutForm(firstname, lastname, zip);
	objCheckOutOne2.clickContinue();
	String currentUrl = driver.getCurrentUrl();
	String expectedUrl = AutomationConstants.CHECKOUTSTEPONE;
	objCheckOutTwo2 = new CheckOutTwo(driver);
	objCheckOutTwo2.LogOut();
	Assert.assertEquals(currentUrl, expectedUrl);
	
	
	}
}
