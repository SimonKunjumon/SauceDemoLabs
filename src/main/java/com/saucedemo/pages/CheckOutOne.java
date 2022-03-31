package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOne 
{ WebDriver driver;
   @FindBy(id = "first-name")
   private WebElement firstname;
   @FindBy(id = "last-name")
   private WebElement lastname;
   @FindBy(id = "postal-code")
   private WebElement postalcode;
   @FindBy(id = "continue")
   private WebElement cont;
   @FindBy(id = "cancel")
   private WebElement cancel;
   @FindBy(id = "react-burger-menu-btn")
	private WebElement menu;
   @FindBy(id = "logout_sidebar_link")
	private WebElement logout;
	 public CheckOutOne(WebDriver driver)
	  {
		  this.driver = driver;
		  PageFactory.initElements(driver, this);
		  
	  }
	 
	 public void fillInCheckOutForm(String strFirstName,String strLastName,String strZip)
	 {   
		firstname.clear();
		firstname.sendKeys(strFirstName);
		lastname.clear();
		lastname.sendKeys(strLastName);
		postalcode.clear();
		postalcode.sendKeys(strZip);
	 }
	 
	 public void clickContinue()
	 {
		 cont.click();
	 }
	 
	 public void clickCancel()
	 {
		 cancel.click();
	 }
	 public void LogOut()
		{
			menu.click();
			logout.click();
			
		}
	 
	 
}
