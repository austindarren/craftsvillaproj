package com.craftsvilla.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.craftsvilla.generic.BasePage;

public class SareeProductPage extends BasePage

{

	@FindBy(xpath="//div/a[@href='/shop/craftsvilla-pink-color-crepe-printed-casual-saree/6152573']/img")
	private WebElement maroonSareeLink;
	
	@FindBy(xpath="//div[@class='col-xs-12 px-2']/h1")
	private WebElement productHeader; 
	
	
	public SareeProductPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void sareeProductPage()
	{
		
		try {
			
			verifyElementPresent(maroonSareeLink);
			maroonSareeLink.click();
			log.info("link clicked"+maroonSareeLink+"is present");	

		}
		catch(Exception e)
		{
			log.error("link clicked"+maroonSareeLink+"is not present"+e);	

		}
	}
	
	public void productHeader()
	{
		try
		{
			verifyElementPresent(productHeader);
			String prdName = productHeader.getText();
			log.info(prdName+"header is present");	

		}
		catch(Exception e)
		{
			log.error("header is not present :"+e);
		}
		
	}
	
}
