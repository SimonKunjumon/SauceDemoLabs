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

public class TestClass2 extends TestBase
{ 
	LoginPage objLoginPage2;
	Inventory objInventory2;
	cart objCart2;
	CheckOutOne objCheckOutOne1;
	CheckOutTwo objCheckOutTwo1;
	CheckOutComplete objCheckOutComplete1;
	
	@Test(priority = 12)
	public void verifyDisplayItemProblemUser() throws InterruptedException, IOException
	{
		
		
	    objLoginPage2 = new LoginPage(driver);
	    String username = ExcelUtility.getCellData(3, 0);
	    String password = ExcelUtility.getCellData(1, 1);
	    objLoginPage2.Login(username, password);
	    String img = "//img[@src=\"/static/media/sl-404.168b1cce.jpg";
	    String expectedImg = AutomationConstants.BACKPACKIMG;
	    Assert.assertEquals(img, expectedImg);
	}
	
	@Test(priority = 13)
	public void verifyAddItemProblemUser()
	{
		objInventory2 = new Inventory(driver);
	    objInventory2.AddToCart();
	    WebElement cart = driver.findElement(By.className("shopping_cart_badge"));
	    String actualResult = cart.getText();
	    String expectedResult = AutomationConstants.CARTPOP;
	    Assert.assertEquals(actualResult, expectedResult);
	}
	@Test(priority = 14)
	public void verifyValidCheckOutProblemUser() throws IOException, InterruptedException
	{
		objInventory2 = new Inventory(driver);
		objInventory2.CartClick();
		objCart2 = new cart(driver);
		objCart2.CartCheckOut();
		objCheckOutOne1 = new CheckOutOne(driver);
		String firstname1 = ExcelUtility.getCellData(1, 2);
		String lastname1 = ExcelUtility.getCellData(1, 3);
		String zip1 = ExcelUtility.getCellData(1, 4);
		objCheckOutOne1.fillInCheckOutForm(firstname1, lastname1, zip1);
		objCheckOutOne1.clickContinue();
		String url = driver.getCurrentUrl();
		String expectedUrl = AutomationConstants.CHECKOUTSTEPTWOPAGE;
		
		objCheckOutOne1.LogOut();
		Assert.assertEquals(url, expectedUrl);
		
		
		
		
	 }

}
