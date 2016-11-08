package com.lejr.cms.interfaces.pageload.impl;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import com.lejr.cms.interfaces.PageLoadInterface;

public class LoadPageViaPageSource implements PageLoadInterface {
	protected boolean loadFlag = false;

	public boolean isLoad() {
		return loadFlag;
	}

	public static boolean isPageSourceContainsDynamic(final String str, WebDriver driver) throws TimeoutException {
		return new WebDriverWait(driver, 10, 500).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.getPageSource().contains(str);
			}
		});
	}

	public void load(Logger logger, String msg, WebDriver driver) {
		try {
			isPageSourceContainsDynamic(msg, driver);
			loadFlag = true;
			logger.info("Page loaded.");
		} catch (TimeoutException e) {
			logger.error("The method is timeout for load the string =["+msg+"] in page source.", e);
			throw e;
		}
	}

	public boolean loadpage(Logger logger, WebDriver d, String msg) {
		do {
			load(logger, msg, d);
		} while (!isLoad());
		return false;
	}


	public void loadpage(Logger logger, WebDriver d) {
		// TODO Auto-generated method stub
		
	}

}
