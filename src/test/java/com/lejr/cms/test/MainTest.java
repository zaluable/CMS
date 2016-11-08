package com.lejr.cms.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lejr.cms.basepage.BasePage;
import com.lejr.cms.modules.login.LoginPage;
import com.lejr.cms.modules.productmanage.ProductAuditDetailPage;
import com.lejr.cms.modules.productmanage.ProductAuditPage;
import com.lejr.cms.modules.productmanage.ProductCreatePage;
import com.lejr.cms.modules.productmanage.ProductWapperDetilPage;
import com.lejr.cms.modules.productmanage.ProductWapperManagerPage;
import com.lejr.utils.BrowserSelectorUtil;
import com.lejr.utils.BrowserSelectorUtil.Browser;
import com.lejr.utils.LogUtil;

public class MainTest {
	private WebDriver driver;
	@BeforeMethod
	public void setup(){
		driver = BrowserSelectorUtil.selectBrowser(Browser.CHROME);
		driver.manage().window().maximize();
		driver.get("http://10.112.88.112/login");
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
	
	@Test
	public void testAuditProduct(){
		LogUtil.beforeTest("testAuditProduct");
		LoginPage loginPage = new LoginPage(driver);
		BasePage basePage = loginPage.loginSuccess("admin", "1qaz2wsx");
		
		ProductAuditPage productAuditPage = basePage.navigateToProductAuditPage();
		ProductAuditDetailPage productAuditDetailPage = productAuditPage.goToAudit();
		productAuditDetailPage.auditProduct();
		LogUtil.afterTest();
	}
	
	@Test
	public void testWapperProduct(){
		LogUtil.beforeTest("testWapperProduct");
		LoginPage loginPage = new LoginPage(driver);
		BasePage basePage = loginPage.loginSuccess("admin", "1qaz2wsx");
		
		ProductWapperManagerPage productWapperManagerPage = basePage.navigateToProductWapperManagerPage();
		ProductWapperDetilPage productWapperDetilPage = productWapperManagerPage.toCreateWapper();
		productWapperDetilPage.createWapper();
		LogUtil.afterTest();
	}
	
	@Test
	public void testAuditWapper(){
		LogUtil.beforeTest("testWapperProduct");
		LoginPage loginPage = new LoginPage(driver);
		BasePage basePage = loginPage.loginSuccess("admin", "1qaz2wsx");
		
		ProductWapperManagerPage productWapperManagerPage = basePage.navigateToProductWapperManagerPage();
		productWapperManagerPage.auditWapper();
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
