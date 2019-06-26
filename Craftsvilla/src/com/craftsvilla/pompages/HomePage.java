package com.craftsvilla.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.craftsvilla.generic.BasePage;


public class HomePage extends BasePage
{

	@FindBy(id="cartCount")
	private WebElement cartLink;
	
	@FindBy(xpath="//span[text()='Sign In']")
	private WebElement signIn;
	
	@FindBy(id="searchval")
	private WebElement searchBox;
	
	@FindBy(id="//button[@class='btn btn-default search-button']")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[@href='/womens-clothing/sarees/?MID=megamenu_sarees_seeall']")
	private WebElement sareesLink;
	
	@FindBy(linkText ="About us")
	private WebElement aboutUsLink;
	
	@FindBy(partialLinkText ="Secure Payment")
	private WebElement securePaymentOptionsLink;
	
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCartLink()
	{
		try
		{
			verifyElementPresent(cartLink);
			cartLink.click();
			log.info("clicked on"+cartLink);
		}
		catch(Exception e)
		{
			log.error("unable to click on"+cartLink+":"+e);
		}
		
	}
	
	public void enterSearchText(String value)
	{
		try
		{
			verifyElementPresent(searchBox);
			searchBox.sendKeys(value);
			verifyElementPresent(searchButton);
			searchButton.click();
			log.info("Entered item"+value+"is present");
		}
		catch(Exception e)
		{
			log.error("Entered item"+value+"is not present :"+e);
		}
	}


}
