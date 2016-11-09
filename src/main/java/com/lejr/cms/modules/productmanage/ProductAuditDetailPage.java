package com.lejr.cms.modules.productmanage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lejr.cms.basepage.BasePage;

public class ProductAuditDetailPage extends BasePage{
	
	private static final Logger logger = LoggerFactory.getLogger(ProductAuditDetailPage.class);
	public ProductAuditDetailPage(WebDriver d) {
		super(d);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);	
	}
	
	public ProductAuditPage auditProduct(){
		this.excuteJsFuntion("list");
		this.excuteJsFuntion("auditProduct");
		return new ProductAuditPage(driver);
	}

}
