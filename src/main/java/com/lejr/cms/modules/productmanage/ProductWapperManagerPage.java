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

	public ProductWapperDetilPage toCreateWapper() {
		this.clickElementWithJSE(createBut);
		return new ProductWapperDetilPage(driver);
	}

	public void auditWapper() {
		String name = "wapper";
		List<WebElement> wapperNames = wapperTable.findElements(By.xpath("./tr/td[2]"));
		for (WebElement wapperName : wapperNames) {
			if (wapperName.getText().equals(name)) {
				WebElement wapperAuditBut = wapperName
						.findElement(By.xpath("./following-sibling::td/descendant::a[attribute::class='aduit_btn ']"));
				// if(wapperAuditBut.getAttribute(name))
				wapperAuditBut.click();
				logger.info("window handler is {}", driver.getWindowHandles());
				Set<String> handles = driver.getWindowHandles();
				for (String string : handles) {
					WebDriver popup = driver.switchTo().window(string);
					if (popup.getCurrentUrl().contains("602003161745")) {
						logger.info("HA HA HA");
					}
				}
			}
		}
	}

}
