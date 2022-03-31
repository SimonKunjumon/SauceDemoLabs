package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutComplete 
{ WebDriver driver;
  @FindBy(id ="back-to-products")
  private WebElement home;
	public CheckOutComplete(WebDriver driver)
	  {
		  this.driver = driver;
		  PageFactory.initElements(driver, this);
		  
	  }
	public void clickHome()
	{
		home.click();
	}
}
