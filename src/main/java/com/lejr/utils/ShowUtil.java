package com.lejr.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShowUtil {
	private static JavascriptExecutor js = null;
	
	public static void highlight(WebDriver diver, WebElement element) {
        js = (JavascriptExecutor) diver;
        
        js.executeScript("element = arguments[0];" +
        "original_style = element.getAttribute('style');" +
        "element.setAttribute('style', original_style + \";" +
        "background: yellow; border: 2px solid red;\");" +
        "setTimeout(function(){element.setAttribute('style', original_style);}, 1000);", element);
        
        js = null;
        }
}
