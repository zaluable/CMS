package com.lejr.cms.modules.productmanage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lejr.cms.basepage.BasePage;

public class ProductWapperDetilPage extends BasePage{
	private static final Logger logger = LoggerFactory.getLogger(ProductWapperDetilPage.class);
	public static String wapperName;
	public ProductWapperDetilPage(WebDriver d) {
		super(d);
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath = "//input[@class='inpt displayName']")
	WebElement wapperNameInput;
	
	@FindBy(xpath = "//select[@class='s_select productCode']")
	WebElement relativeProductSele;
	//com_btn select_project_btn
	
	@FindBy(xpath = "//a[@class='com_btn select_project_btn']")
	WebElement selectProjectBut;
	
	@FindBy(xpath ="//div[@class='s_btn submit_btn submit_all']")
	WebElement submitAllProductsBut;
	
	@FindBy(xpath = "//textarea[@class='displayDesc']")
	WebElement wapperDescribInput;
	
	//s_btn submit_btn
	@FindBy(xpath = "//div[@class='s_btn submit_btn']")
	WebElement submitBut;
	
	public ProductWapperManagerPage createWapper(){
		wapperName = ProductCreatePage.productName.substring(0, 14)+"WAPPER";
		wapperNameInput.sendKeys(wapperName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.selectOptionByVisibleText(relativeProductSele, ProductCreatePage.productName);
		selectProjectBut.click();
		this.waitClickUntilClickable(submitAllProductsBut);
		this.waitClickUntilClickable(submitBut);
		return new ProductWapperManagerPage(driver);		
	}

}
