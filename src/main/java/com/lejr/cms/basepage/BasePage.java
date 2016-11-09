package com.lejr.cms.basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lejr.cms.absclazz.PageObject;
import com.lejr.cms.interfaces.PageLoadInterface;
import com.lejr.cms.interfaces.pageload.impl.LoadPageViaJsStatus;
import com.lejr.cms.modules.productmanage.ProductAuditPage;
import com.lejr.cms.modules.productmanage.ProductCreatePage;
import com.lejr.cms.modules.productmanage.ProductWapperManagerPage;
import com.lejr.cms.modules.releasemanage.RegularWapperReleasePage;

public class BasePage extends PageObject{
	protected PageLoadInterface pageLoader;
	private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
	public BasePage(WebDriver d) {
		super(d);
		pageLoader = new LoadPageViaJsStatus();
		pageLoader.loadpage(logger, d);
		PageFactory.initElements(driver, this);		
	}

	@FindBy(id = "rootNode")
	private WebElement rootNode;
	
	protected String sideBarName = "nav_frame";
	
	protected String mainWinName = "right";
	
	
	public ProductCreatePage navigateToProductCreatePage(){
		navigateToTargetPage(rootNode, "项目管理", "项目批量录入", sideBarName, mainWinName);
		return new ProductCreatePage(this.driver);
	}
	
	public ProductAuditPage navigateToProductAuditPage(){
		navigateToTargetPage(rootNode, "项目管理", "产品列表（大包审核）",sideBarName, mainWinName);
		return new ProductAuditPage(this.driver);
	}
	
	public ProductWapperManagerPage navigateToProductWapperManagerPage(){
		navigateToTargetPage(rootNode, "项目管理", "产品展示包管理",sideBarName, mainWinName);
		return new ProductWapperManagerPage(this.driver);
	}
	
	public RegularWapperReleasePage navigateToRegularWapperReleasePage(){
		navigateToTargetPage(rootNode, "发布管理", "定期理财展示包发布",sideBarName, mainWinName);
		return new RegularWapperReleasePage(this.driver);
	}
}
