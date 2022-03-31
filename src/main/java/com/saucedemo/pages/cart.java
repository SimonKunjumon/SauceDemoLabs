package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cart 
{
  WebDriver driver;
  @FindBy(id = "checkout")
  private WebElement checkout;
  @FindBy(id = "remove-sauce-labs-backpack")
  private WebElement remove;
  @FindBy(id = "continue-shopping")
  private WebElement continueshopping;
  public cart(WebDriver driver)
  {
	  this.driver = driver;
	  PageFactory.initElements(driver, this);
	  
  }
  public void CartCheckOut()
  {
	  checkout.click();
  }
  
  public void remove()
  {
	  remove.click();
  }
  
  public void continueshopping()
  {
	  continueshopping.click();
  }
  
}
