package com.lejr.cms.interfaces;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

public interface PageLoadInterface {
//	public boolean isLoad();
//	
	public void loadpage(Logger logger, WebDriver d);
	
	public boolean loadpage(Logger logger, WebDriver d, String msg);
}
