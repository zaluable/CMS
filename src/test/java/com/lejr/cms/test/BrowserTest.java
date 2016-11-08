package com.lejr.cms.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.lejr.utils.BrowserSelectorUtil;
import com.lejr.utils.BrowserSelectorUtil.Browser;

public class BrowserTest {
	@Test
	public void testBrowser() {
		WebDriver wDriver = BrowserSelectorUtil.selectBrowser(Browser.FIREFOX);
		wDriver.get("http://www.baidu.com");
	}
	@Test
	public void testJs(){
		String id = "id";
		// remove readonly attribute
		String script = "var setDate=document.getElementById(\""+id+"\");setDate.removeAttribute('readonly');";
		System.err.println(script);
	}
}
