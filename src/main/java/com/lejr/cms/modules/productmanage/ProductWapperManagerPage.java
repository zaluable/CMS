package com.lejr.cms.modules.productmanage;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lejr.cms.basepage.BasePage;

public class ProductWapperManagerPage extends BasePage {

	private static final Logger logger = LoggerFactory.getLogger(ProductWapperManagerPage.class);

	public ProductWapperManagerPage(WebDriver d) {
		super(d);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/productDisplay/add']")
	WebElement createBut;

	@FindBy(xpath = "//tbody")
	WebElement wapperTable;
	
	@FindBy(xpath = "//body/div/div/div/descendant::select")
	WebElement pagesizeSele;

	public ProductWapperDetilPage toCreateWapper() {
		this.clickElementWithJSE(createBut);
		return new ProductWapperDetilPage(driver);
	}

	public ProductWapperManagerPage auditWapper() {
		this.selectOptionByValue(pagesizeSele, "20");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String wapperToBeAudit = ProductWapperDetilPage.wapperName;
		List<WebElement> wapperNames = wapperTable.findElements(By.xpath("./tr/td[2]"));
		for (WebElement wapperName : wapperNames) {
			if (wapperName.getText().equals(wapperToBeAudit)) {
				WebElement dispalyCodeTb = wapperName.findElement(By.xpath("./parent::tr[attribute::data-displayname='"+wapperToBeAudit+"']"));
				String displayCode = dispalyCodeTb.getAttribute("data-displaycode");
				WebElement wapperAuditBut = wapperName
						.findElement(By.xpath("./following-sibling::td/descendant::a[attribute::class='aduit_btn ']"));
				// if(wapperAuditBut.getAttribute(name))
				wapperAuditBut.click();
				logger.info("window handler is {}", driver.getWindowHandles());
				Set<String> handles = driver.getWindowHandles();
				for (String string : handles) {
					WebDriver popup = driver.switchTo().window(string);
					if (popup.getCurrentUrl().contains(displayCode)) {
						logger.info("Get the popup window url = {}",popup.getCurrentUrl());
						WebElement passRB = popup.findElement(By.xpath("//input[@type='radio'][@value='1']"));
						passRB.click();
						WebElement submitBut = popup.findElement(By.xpath("//form[@id='aduit-form']//descendant::div[attribute::class='s_btn submit_btn']"));
						submitBut.click();
						break;
					}
				}
				this.driver = this.driver.switchTo().window(driver.getWindowHandle());
				return this;
			}
		}
		logger.error("Can not find the wapper name = {}",wapperToBeAudit);
		return null;
	}

}
