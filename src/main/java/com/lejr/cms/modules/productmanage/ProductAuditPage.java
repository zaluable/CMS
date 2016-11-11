package com.lejr.cms.modules.productmanage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lejr.cms.basepage.BasePage;

public class ProductAuditPage extends BasePage{
	
	private static final Logger logger = LoggerFactory.getLogger(ProductAuditPage.class);

	public ProductAuditPage(WebDriver d) {
		super(d);
		PageFactory.initElements(driver, this);	
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//*[@id=\"list_area\"]/div/table/tbody")
	private WebElement tbody;
	
	public ProductAuditDetailPage goToAudit() throws Exception{
		String name = ProductCreatePage.productName;
//		String name = "[TEST]11081713PROD";

		List<WebElement> productNames = tbody.findElements(By.xpath("./tr/td[2]"));
		for(WebElement productName : productNames){
			logger.info("productName is {}",productName.getText());
			if(name.equals(productName.getText())){
				WebElement auditBut = productName.findElement(By.xpath("./following-sibling::td/div/a"));
				logger.info("Get attribute is {}", auditBut.getAttribute("style"));
				if(auditBut.getAttribute("style").equals("")){
					auditBut.click();
					return new ProductAuditDetailPage(driver);
				}else{
					logger.error("The productname = {} you wanne to audit has already audit",name);
				}
			}
		}
		return null;
	}

}
