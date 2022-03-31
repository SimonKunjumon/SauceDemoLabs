package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	@FindBy(id = "user-name")
	private WebElement username;
	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "login-button")
	private WebElement login;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void Login(String strUserName, String strPassword)
	{   //System.out.println(driver);
		username.clear();
		
		username.sendKeys(strUserName);
		
		password.clear();
		password.sendKeys(strPassword);
		login.click();
		
	}

}
