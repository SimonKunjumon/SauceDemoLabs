package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutTwo 
{   WebDriver driver;
    @FindBy(id = "finish")
    private WebElement finish;
    @FindBy(id = "cancel")
    private WebElement cancel;
    @FindBy(id = "react-burger-menu-btn")
	private WebElement menu;
    @FindBy(id = "logout_sidebar_link")
	private WebElement logout;
    
	public CheckOutTwo(WebDriver driver)
	  {
		  this.driver = driver;
		  PageFactory.initElements(driver, this);
		  
	  }
	
	public void clickFinish()
	{
		finish.click();
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
