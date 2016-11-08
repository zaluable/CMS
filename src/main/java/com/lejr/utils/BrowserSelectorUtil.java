package com.lejr.utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserSelectorUtil {
	
	public enum Browser{
		FIREFOX, IE, CHROME;
	}
	
	public static WebDriver selectBrowser(Browser browser){
		switch (browser){
		case FIREFOX:
			return new FirefoxDriver();
			
		case IE:
		    System.setProperty("webdriver.ie.driver", "src\\main\\resources\\wd\\IEDriverServer.exe");
			return new InternetExplorerDriver();
			
		case CHROME:
		    System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\wd\\chromedriver.exe");
			return new ChromeDriver();
		
		default:
			throw new NoSuchElementException("didn't surport this brower!");
		}
	}
	
	
	public static WebDriver selectBrowser(){
	    System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\wb\\chromedriver.exe");
		return new ChromeDriver();
	}
}
