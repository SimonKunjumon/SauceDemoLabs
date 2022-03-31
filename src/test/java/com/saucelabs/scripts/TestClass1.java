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

public class TestClass1 extends TestBase
{
	LoginPage objLoginPage1;
	Inventory objInventory1;
	cart objCart1;
	CheckOutOne objCheckOutOne;
	CheckOutTwo objCheckOutTwo;
	CheckOutComplete objCheckOutComplete;
	@Test(priority = 6)
	public void verifyAddItem() throws InterruptedException, IOException
	{
		
		
	    objLoginPage1 = new LoginPage(driver);
	    String username = ExcelUtility.getCellData(1, 0);
	    String password = ExcelUtility.getCellData(1, 1);
	    objLoginPage1.Login(username, password);
	    
	    objInventory1 = new Inventory(driver);
	    objInventory1.AddToCart();
	    WebElement cart = driver.findElement(By.className("shopping_cart_badge"));
	    String actualResult = cart.getText();
	    String expectedResult = AutomationConstants.CARTPOP;
	    Assert.assertEquals(actualResult, expectedResult);
	}
	@Test(priority = 7)
	public void verifyValidCheckOut() throws IOException
	{
		objInventory1 = new Inventory(driver);
		objInventory1.CartClick();
		objCart1 = new cart(driver);
		objCart1.CartCheckOut();
		objCheckOutOne = new CheckOutOne(driver);
		String firstname = ExcelUtility.getCellData(1, 2);
		String lastname = ExcelUtility.getCellData(1, 3);
		String zip = ExcelUtility.getCellData(1, 4);
		objCheckOutOne.fillInCheckOutForm(firstname, lastname, zip);
		objCheckOutOne.clickContinue();
		objCheckOutTwo = new CheckOutTwo(driver);
		objCheckOutTwo.clickFinish();
		
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = AutomationConstants.FINALPAGE;
		Assert.assertEquals(currentUrl, expectedUrl);
		
		objCheckOutComplete = new CheckOutComplete(driver);
		objCheckOutComplete.clickHome();
		
		
	}
	@Test(priority = 8)
	public void verifyCheckOutFormValidation() throws IOException
	{
		objInventory1 = new Inventory(driver);
		objInventory1.CartClick();
		objCart1 = new cart(driver);
		objCart1.CartCheckOut();
		objCheckOutOne = new CheckOutOne(driver);
		String firstname = "";
		String lastname =  ExcelUtility.getCellData(1, 3);
		String zip = ExcelUtility.getCellData(1, 4);
		objCheckOutOne.fillInCheckOutForm(firstname, lastname, zip);
		objCheckOutOne.clickContinue();
		WebElement formvalidation = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
		String actualResult = formvalidation.getText();
		String expectedResult = AutomationConstants.FIRSTNAMEERROR;
		Assert.assertEquals(actualResult, expectedResult);
	}
	@Test(priority = 9)
	
	public void verifyCheckOutFormValidation1() throws IOException
	{
		objInventory1 = new Inventory(driver);
		objInventory1.CartClick();
		objCart1 = new cart(driver);
		objCart1.CartCheckOut();
		objCheckOutOne = new CheckOutOne(driver);
		String firstname = ExcelUtility.getCellData(1, 2);
		String lastname =  "";
		String zip = ExcelUtility.getCellData(1, 4);
		objCheckOutOne.fillInCheckOutForm(firstname, lastname, zip);
		objCheckOutOne.clickContinue();
		WebElement formvalidation = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
		String actualResult = formvalidation.getText();
		String expectedResult = AutomationConstants.LASTNAMEERROR;
		Assert.assertEquals(actualResult, expectedResult);
	}
	@Test(priority = 9)
	public void verifyCheckOutFormValidation2() throws IOException
	{
		objInventory1 = new Inventory(driver);
		objInventory1.CartClick();
		objCart1 = new cart(driver);
		objCart1.CartCheckOut();
		objCheckOutOne = new CheckOutOne(driver);
		String firstname = ExcelUtility.getCellData(1, 2);
		String lastname =  ExcelUtility.getCellData(1, 3);
		String zip = "";
		objCheckOutOne.fillInCheckOutForm(firstname, lastname, zip);
		objCheckOutOne.clickContinue();
		WebElement formvalidation = driver.findElement(By.xpath("//h3[@data-test=\"error\"]"));
		String actualResult = formvalidation.getText();
		String expectedResult = AutomationConstants.POSTALCODEERROR;
		Assert.assertEquals(actualResult, expectedResult);
		
	}
	@Test(priority = 9)
	public void verifyInvalidFormValues() throws IOException
	{
		objCheckOutOne = new CheckOutOne(driver);
		String firstname = ExcelUtility.getCellData(2, 2);
		String lastname =  ExcelUtility.getCellData(2, 3);
		String zip = ExcelUtility.getCellData(1, 4);
		objCheckOutOne.fillInCheckOutForm(firstname, lastname, zip);
		objCheckOutOne.clickContinue();
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = AutomationConstants.CHECKOUTSTEPONE;
		Assert.assertEquals(currentUrl, expectedUrl);
		
	}
	@Test(priority = 11)
	
	public void verifyInvalidFormValues1() throws IOException
	{   
		objCheckOutOne = new CheckOutOne(driver);
		objCheckOutOne.clickCancel();
		
		objInventory1 = new Inventory(driver);
		objInventory1.CartClick();
		objCart1 = new cart(driver);
		objCart1.CartCheckOut();
		objCheckOutOne = new CheckOutOne(driver);
		
		String firstname = ExcelUtility.getCellData(3, 2);
		String lastname =  ExcelUtility.getCellData(3, 3);
		String zip = ExcelUtility.getCellData(1, 4);
		objCheckOutOne.fillInCheckOutForm(firstname, lastname, zip);
		objCheckOutOne.clickContinue();
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = AutomationConstants.CHECKOUTSTEPONE;
		Assert.assertEquals(currentUrl, expectedUrl);
		
	}
	
	@Test(priority = 12)
	public void verifyInvalidFormValues2() throws IOException, InterruptedException
	{
		objCheckOutOne = new CheckOutOne(driver);
		objCheckOutOne.clickCancel();
		
		objInventory1 = new Inventory(driver);
		objInventory1.CartClick();
		objCart1 = new cart(driver);
		objCart1.CartCheckOut();
		objCheckOutOne = new CheckOutOne(driver);
		
		String firstname = ExcelUtility.getCellData(1, 2);
		String lastname =  ExcelUtility.getCellData(1, 3);
		String zip = ExcelUtility.getCellData(3, 4);
		objCheckOutOne.fillInCheckOutForm(firstname, lastname, zip);
		objCheckOutOne.clickContinue();
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = AutomationConstants.CHECKOUTSTEPONE;
		objCheckOutTwo = new CheckOutTwo(driver);
		objCheckOutTwo.LogOut();
		Assert.assertEquals(currentUrl, expectedUrl);
		
		
		}
	
	
}
