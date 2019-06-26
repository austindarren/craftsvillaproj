package com.craftsvilla.generic;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
	
	public WebDriver  driver=null;
	public Logger log = Logger.getLogger(BasePage.class);
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
	}

	
	public void verifyPageTitle(String exp_title) {
		
		
			WebDriverWait wait =new WebDriverWait(driver, 10);
			String act_title = null;
			try
			{	
				wait.until(ExpectedConditions.titleContains(exp_title));
				act_title=driver.getTitle();
				Assert.assertEquals(act_title, exp_title);
				log.info("act_title: "+act_title+"and exp_title: "+exp_title+"matches");
			}
		
		catch(Exception e)
		{
			log.error("act_title: "+act_title+"and exp_title: "+exp_title+"doesnot matches : "+e);
		}
		}
		
	public void mouseHover(WebElement web) {
		
		try {
		Actions action = new Actions(driver);
		action.moveToElement(web).perform();
		}
		catch(Exception e) {
			log.error("WebElement :"+web+"not found :"+e);
		}
		
	}
	
	public void verifyElementPresent(WebElement web) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		try {
			
			wait.until(ExpectedConditions.visibilityOf(web));
			log.info("WebElement: "+web+"found");
			
		}
		catch(Exception e) {
			
			log.error("WebElement: "+web+"not found :"+e);
		}
		
	}
	

	
}
