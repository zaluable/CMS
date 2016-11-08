package com.lejr.cms.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lejr.cms.basepage.BasePage;
import com.lejr.cms.modules.login.LoginPage;
import com.lejr.cms.modules.productmanage.ProductCreatePage;
import com.lejr.utils.BrowserSelectorUtil;
import com.lejr.utils.BrowserSelectorUtil.Browser;
import com.lejr.utils.LogUtil;

public class MainTest {
	private WebDriver driver;
	@BeforeMethod
	public void setup(){
		driver = BrowserSelectorUtil.selectBrowser(Browser.FIREFOX);
		driver.get("http://admin.jr.letv.com/login");
	}
	
	@Test
	public void testLogin(){
		LogUtil.beforeTest("testLogin");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginSuccess("admin", "1qaz2wsx");
		LogUtil.afterTest();
	}
	
	@Test
	public void testCreateProduct(){
		LogUtil.beforeTest("testCreateProduct");
		LoginPage loginPage = new LoginPage(driver);
		BasePage basePage = loginPage.loginSuccess("admin", "1qaz2wsx");
		ProductCreatePage productCreatePage = basePage.navigateToProductCreatePage();
		productCreatePage.createProduct();
		LogUtil.afterTest();
	}

	
	@AfterMethod
	public void teardown(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		driver.quit();
	}
}
