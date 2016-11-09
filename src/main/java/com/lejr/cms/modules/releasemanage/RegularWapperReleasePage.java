package com.lejr.cms.modules.releasemanage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import com.lejr.cms.basepage.BasePage;

public class RegularWapperReleasePage extends BasePage{

	private static final Logger logger = LoggerFactory.getLogger(RegularWapperReleasePage.class);

	public RegularWapperReleasePage(WebDriver d) {
		super(d);
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//form//div[text()=\"查询\"]")
	private List<WebElement> serchButs;
	
	@FindBy(id = "ing-list")
	private WebElement toReleaseTb;
	
	@FindBy(id = "ed-list")
	private WebElement releasedTb;
	
	@FindBy(xpath = "//*[@id='confirm-op-publish']/div[text()=\"确定\"]")
	private WebElement relaseConfirmBut;
	
	@FindBy(xpath = "//div[@class='tab_title']/a[text()=\"待发布\"]")
	private WebElement toRealseTitleBut;
	
	@FindBy(xpath = "//div[@class='tab_title']/a[text()=\"已发布\"]")
	private WebElement realsedTitleBut;
	
	public void directlyReleaseWapper(){
		logger.info("In to method directlyReleaseWapper");
		boolean flag = false;
		serchButs.get(0).click();
//		(new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>(){
//
//			public Boolean apply(WebDriver input) {
//				return !(toReleaseTb.findElements(By.xpath("./tr/td[2]")).equals(""));
//			}
//
//		});
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> wapperNames = toReleaseTb.findElements(By.xpath("./table/tbody/tr/td[2]"));
		logger.info("WapperNames size is {},tostring {}",wapperNames.size(),wapperNames.toString());
		Assert.assertNotNull(wapperNames);
		Assert.assertNotEquals(wapperNames.toString(), "");
		for(WebElement wapperName : wapperNames){
			logger.info("Element wapperName gettext is {}",wapperName.getText());
			if(wapperName.getText().equals("[TEST]11091122WAPPER")){
				WebElement directlyReleaseBut = wapperName.findElement(By.xpath("./following-sibling::td[position()=9]/descendant::a[text()=\"立即发布\"]"));
				logger.info("Find the wapper, execute Releasing Action.");
				directlyReleaseBut.click();
				relaseConfirmBut.click();
				flag = true;
				break;
			}
		}
		Assert.assertEquals(flag, true);
		logger.info("Switch tab to Assert Wapper status.");
		
		this.waitClickUntilClickable(realsedTitleBut);
		realsedTitleBut.click();
		serchButs.get(1).click();
		List<WebElement> wapperNames2 = releasedTb.findElements(By.xpath("./tr/td[2]"));
		for(WebElement wapperName2 : wapperNames2){
			if(wapperName2.getText().equals("[TEST]11091122WAPPER")){
				WebElement wapperStatus = wapperName2.findElement(By.xpath("./following-sibling::td[position()=11]"));
				Assert.assertEquals(wapperStatus.getText(), "已发布");
				break;
			}
		}
		
	}
}
	
