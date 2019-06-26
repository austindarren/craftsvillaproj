package com.craftsvilla.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.craftsvilla.generic.BasePage;

public class SareesPage extends BasePage {

	
	@FindBy(xpath="//a[@href='https://www.craftsvilla.com/cvfeeds/buy-crepe-drapes-online-craftsvilla']")
	private WebElement crepeSareeLink; 


	
	@FindBy(xpath="//a[@href='/womens-clothing/sarees/?MID=megamenu_sarees_seeall']")
	private WebElement sareesLink;
	
	
	
	
	public SareesPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void mouseOverSaree() {
		try
		{
		verifyElementPresent(sareesLink);
		mouseHover(sareesLink);
		verifyElementPresent(crepeSareeLink);
		crepeSareeLink.click();
		log.info("link clicked"+crepeSareeLink+"is present");	
		}
		catch(Exception e)
		{
			log.error("link clicked"+crepeSareeLink+"is not present");
		}
	}
	
	

}
