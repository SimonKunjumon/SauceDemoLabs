package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inventory
{ 	
	WebDriver driver;
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menu;
	@FindBy(id = "logout_sidebar_link")
	private WebElement logout;
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement addtocart;
	@FindBy(xpath = "//a[@class=\"shopping_cart_link\"]")
	private WebElement cart;
	@FindBy(id = "checkout")
	private WebElement checkout;
	public Inventory(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void LogOut()
	{
		menu.click();
		logout.click();
		
	}
	
	public void AddToCart()
	{
		addtocart.click();
	}
    
	public void CartClick()
	{
		cart.click();
		
	}

}
