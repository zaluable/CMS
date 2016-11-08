package com.lejr.cms.interfaces.pageload.impl;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

import com.lejr.cms.interfaces.PageLoadInterface;

public class LoadPageViaJsStatus implements PageLoadInterface{
	protected static JavascriptExecutor js;
	protected static String pageLoadStatus = null;

	public static void waitForPageToLoad(Logger logger, WebDriver d) {
		do {
			js = (JavascriptExecutor) d;
			pageLoadStatus = (String) js.executeScript("return document.readyState");
			System.out.print(".");
		} while (!pageLoadStatus.equals("complete"));
		logger.info("Page loaded.");
	}

	public void loadpage(Logger logger, WebDriver d) {
		waitForPageToLoad(logger, d);
	}

	public boolean loadpage(Logger logger, WebDriver d, String msg) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
