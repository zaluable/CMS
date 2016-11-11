package com.lejr.cms.modules.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lejr.cms.absclazz.PageObject;
import com.lejr.cms.basepage.BasePage;
import com.lejr.cms.interfaces.PageLoadInterface;
import com.lejr.cms.interfaces.pageload.impl.LoadPageViaPageSource;
import com.lejr.utils.ScreenshotUtil;

public class LoginPage extends PageObject{
	private PageLoadInterface pageLoader;
	private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
	public LoginPage(WebDriver d) {
		super(d);
		pageLoader = new LoadPageViaPageSource();
		try {
			pageLoader.loadpage(logger, d, "乐视金融交易平台");
		} catch (Exception e) {
			logger.error("Loaded page failed", e);
		}
		PageFactory.initElements(driver, this);
		logger.info("Init the Class ["+this.getClass().getName()+"].");
	}
	
	@FindBy(id = "systemLoginName")
	private WebElement loginNameInput;
	
	@FindBy(id = "password")
	private WebElement loginpasswordInput;
	
	@FindBy(id = "submit_btn")
	private WebElement submitBut;
	
	public BasePage loginSuccess(String name, String passwd){

		loginNameInput.sendKeys(name);
		loginpasswordInput.sendKeys(passwd);
		logger.info("Input login name = ["+name+"] and passwd = ["+passwd+"].");
		ScreenshotUtil.screenShot(driver);
		logger.info("Take login screenshot....");
		submitBut.click();
		logger.info("Click the login button.");
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);  
//		isPageSourceContainsDynamic("/system/menu/findMenu");
//		Assert.assertEquals(true, driver.getPageSource().contains(name));
//		logger.info("pagesource:"+this.driver.getPageSource());
		logger.info("Login success.");
		return new BasePage(this.driver);
	}

}
