package com.lejr.cms.modules.productmanage;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lejr.cms.basepage.BasePage;
import com.lejr.cms.interfaces.dataload.impl.ReadXlsx;
import com.lejr.utils.TimeUtil;

public class ProductCreatePage extends BasePage{
	private HashMap<String, String> dataMap;
	public static String productName;
	private final static String path = "C:\\Users\\zhangxiao3\\Desktop\\product-dataprovider.xlsx";
	private final static String contractPath = "contarct\\first.html";

	private static final Logger logger = LoggerFactory.getLogger(ProductCreatePage.class);
	private String[] idList = {"recruitStartTime", "recruitEndTime", "dateOfValue", "dateOfExpiry"};
	public ProductCreatePage(WebDriver d) {
		super(d);
		dataMap = ReadXlsx.readXlsx(path, logger);
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id = "")
	private WebElement  Input;
	
	@FindBy(id = "")
	private WebElement  Sele;
	
	@FindBy(id = "")
	private WebElement  But;
	
	@FindBy(id = "")
	private WebElement  Rb;


	/*
	 * 
	 * 增加产品（大包）
	 * 
	 */

	// 项目类型
	@FindBy(id = "projectType")
	private WebElement projectTypeSele;
	
	// 录入方式
	@FindBy(id = "inputMode")
	private WebElement inputModeSele;

	/*
	 * 
	 * 合同及交易所信息
	 * 
	 */

	// 产品名称
	@FindBy(id = "productName")
	private WebElement productNameInput;
	
	// 是否交易所发行
	@FindBy(id = "isTransactionPublish")
	private WebElement isTransactionPublishSele;
	
	// 产品命名序号（起始）
	@FindBy(id = "productStartNum")
	private WebElement productStartNumInput;
	
	// 产品代码（起始）
	@FindBy(id = "productStartCode")
	private WebElement productStartCodeInput;
	
	// 募集总金额
	@FindBy(id = "productTotalAmount")
	private WebElement productTotalAmountInput;
	
	// 产品供应商
	@FindBy(id = "venderCode")
	private WebElement venderCodeSele;
	
	// 入驻商户
	@FindBy(id = "merchantCode")
	private WebElement merchantCodeSele;
	
	// 每项目最大募集金额
	@FindBy(id = "projectTotalAmount")
	private WebElement projectTotalAmountInput;
	
	// 融资类型
	@FindBy(id = "financeType")
	private WebElement financeTypeSele;
	
	// 项目数
	@FindBy(id = "projectNum")
	private WebElement projectNumInput;
	
	// 最低募集比例
	@FindBy(id = "successMinRate")
	private WebElement successMinRateInput;
	
	// 财顾费结算比例
	@FindBy(id = "adviceFeeRate")
	private WebElement adviceFeeRateInput;
	
	// 服务费结算比例
	@FindBy(id = "serviceFeeRate")
	private WebElement serviceFeeRateInput;
	
	// 交易所费用结算比例
	@FindBy(id = "tradingFeeRate")
	private WebElement tradingFeeRateInput;
	
	// 是否使用内部spv
	@FindBy(id = "isSpv")
	private WebElement isSpvSele;
	
	// 交易主体
	@FindBy(id = "companyCode")
	private WebElement companyCodeSele;

	/*
	 * 
	 * 项目信息
	 * 
	 */

	// 项目名称
	@FindBy(id = "projectName")
	private WebElement projectNameInput;

	// 募集开始日
	@FindBy(id = "recruitStartTime")
	private WebElement recruitStartTimeInput;

	// 募集结束日
	@FindBy(id = "recruitEndTime")
	private WebElement recruitEndTimeInput;

	// 项目命名序号(起始)
	@FindBy(id = "projectNo")
	private WebElement projectNoInput;

	// 最低购买金额
	@FindBy(id = "minPurchaseAmount")
	private WebElement minPurchaseAmountInput;

	// 递增购买金额
	@FindBy(id = "incrementalPurchaseAmount")
	private WebElement incrementalPurchaseAmountInput;

	// 最高购买金额
	@FindBy(id = "maxPurchaseAmount")
	private WebElement maxPurchaseAmountInput;

	// 起息日
	@FindBy(id = "dateOfValue")
	private WebElement dateOfValueInput;

	// 到期日
	@FindBy(id = "dateOfExpiry")
	private WebElement dateOfExpiryInput;

	// 项目期限
	@FindBy(id = "investmentHorizon")
	private WebElement investmentHorizonInput;

	// 收益计算方式
	@FindBy(id = "incomeCalculationMethod")
	private WebElement incomeCalculationMethodSele;

	// 收益支付方式
	@FindBy(id = "repayWay")
	private WebElement repayWaySele;

	// 风险评级
	@FindBy(id = "riskRank")
	private WebElement riskRankSele;
	
	//是否可以转让
	@FindBy(id = "isTransfer")
	private WebElement isTransferSele;

	/*
	 * 
	 * 添加小包合同模板
	 * 
	 */

	// 选择文件
	@FindBy(id = "file_0")
	private WebElement file_0But;

	// 产品级别
	@FindBy(xpath = "//*[@id=\"productForm\"]/div/div[3]/div/div[15]/div/div/label[1]")
	private WebElement productLevelRb;

	// 订单级别
	@FindBy(id = "//*[@id=\"productForm\"]/div/div[3]/div/div[15]/div/div/label[2]")
	private WebElement orderLevelRb;

	/*
	 * 
	 * 项目属性
	 * 
	 */

	// 项目属性
	@FindBy(id = "projectPropertis1")
	private WebElement projectPropertis1Sele;

	// 冠军包
	@FindBy(id = "projectCommonProperty1")
	private WebElement projectCommonProperty1Sele;

	// 中超包
	@FindBy(id = "projectCommonProperty2")
	private WebElement projectCommonProperty2Sele;

	// 限购包
	@FindBy(id = "projectCommonProperty3")
	private WebElement projectCommonProperty3Sele;

	// 预约包
	@FindBy(id = "projectCommonProperty4")
	private WebElement projectCommonProperty4Sele;

	// 限购次数
	@FindBy(id = "maxPurchasNum")
	private WebElement maxPurchasNumInput;

	// 活动ID
	@FindBy(id = "activityID")
	private WebElement activityIDInput;

	// 9要理财
	@FindBy(id = "projectCommonProperty5")
	private WebElement projectCommonProperty5Sele;

	// 乐迷秒翻天
	@FindBy(id = "projectCommonProperty6")
	private WebElement projectCommonProperty6Sele;

	// 爵迹包
	@FindBy(id = "projectCommonProperty7")
	private WebElement projectCommonProperty7Sele;

	/*
	 * 
	 * 项目介绍
	 * 
	 */

	// 项目介绍
	@FindBy(id = "projectDesc")
	private WebElement projectDescInput;

	/*
	 * 
	 * 收益率信息
	 * 
	 */

	// 是否阶梯收益率
	// 非阶梯收益
	@FindBy(id = "isladderincome")
	private WebElement isladderincomeRb;

	// 计息基数
	// 360天
	@FindBy(xpath = "//*[@id=\"productForm\"]/div/div[7]/div[2]/div[2]/input[1]")
	private WebElement day360Rb;

	// 计息基数
	// 365天
	@FindBy(id = "//*[@id=\"productForm\"]/div/div[7]/div[2]/div[2]/input[2]")
	private WebElement day365Rb;

	// 预期年化收益率
	@FindBy(id = "userAnnualRate")
	private WebElement userAnnualRateInput;

	/*
	 * 
	 * 提交
	 * 
	 */

	// 保存
	@FindBy(id = "btn_submit")
	private WebElement submitBut;

	// 重置
	@FindBy(id = "reset_btn")
	private WebElement resetBut;
	
	//
	@FindBy(xpath = "//button[@i-id='ok']")
	private WebElement okBut;
	
	public ProductListPage createProduct(){
		this.selectOptionByVisibleText(projectTypeSele, dataMap.get("projectTypeSele"));
		this.selectOptionByVisibleText(inputModeSele, dataMap.get("inputModeSele"));
		
		//大包信息
		productName = "[TEST]"+TimeUtil.getTimeStamp()+"PROD";
		
		this.selectOptionByVisibleText(isTransactionPublishSele, dataMap.get("isTransactionPublishSele"));
		this.selectOptionByVisibleText(venderCodeSele, dataMap.get("venderCodeSele"));
		this.selectOptionByVisibleText(merchantCodeSele, dataMap.get("merchantCodeSele"));
		this.selectOptionByVisibleText(financeTypeSele, dataMap.get("financeTypeSele"));
		

		productNameInput.sendKeys(productName);
		productStartNumInput.sendKeys(dataMap.get("productStartNumInput"));
		productStartCodeInput.sendKeys(dataMap.get("productStartCodeInput"));
		productTotalAmountInput.sendKeys(dataMap.get("productTotalAmountInput"));
		projectTotalAmountInput.sendKeys(dataMap.get("projectTotalAmountInput"));
		projectNumInput.sendKeys(dataMap.get("projectNumInput"));
		successMinRateInput.sendKeys(dataMap.get("successMinRateInput"));
		adviceFeeRateInput.sendKeys(dataMap.get("adviceFeeRateInput"));
		serviceFeeRateInput.sendKeys(dataMap.get("serviceFeeRateInput"));
		tradingFeeRateInput.sendKeys(dataMap.get("tradingFeeRateInput"));

		this.selectOptionByVisibleText(isSpvSele, dataMap.get("isSpvSele"));
		this.selectOptionByVisibleText(companyCodeSele, dataMap.get("companyCodeSele"));
		
		//小包信息
		String projectName = "[TEST]"+TimeUtil.getTimeStamp()+"PROJ";
		projectNameInput.sendKeys(projectName);
		
		projectNoInput.sendKeys(dataMap.get("projectNoInput"));
		minPurchaseAmountInput.sendKeys(dataMap.get("minPurchaseAmountInput"));
		incrementalPurchaseAmountInput.sendKeys(dataMap.get("incrementalPurchaseAmountInput"));
		maxPurchaseAmountInput.sendKeys(dataMap.get("maxPurchaseAmountInput"));
		
		int timeInterval = Integer.valueOf(dataMap.get("investmentHorizonInput"));
		
		this.removeReadOnlyAttrList(idList);
		
		recruitStartTimeInput.sendKeys(TimeUtil.getCurrentTime());
		recruitEndTimeInput.sendKeys(TimeUtil.getCurrentTime());
		dateOfValueInput.sendKeys(TimeUtil.computerByDayInterval(1));
		investmentHorizonInput.sendKeys(dataMap.get("investmentHorizonInput"));
		dateOfExpiryInput.sendKeys(TimeUtil.computerByDayInterval(1+timeInterval));
		
		this.selectOptionByVisibleText(incomeCalculationMethodSele, dataMap.get("incomeCalculationMethodSele"));
		this.selectOptionByVisibleText(repayWaySele, dataMap.get("repayWaySele"));
		this.selectOptionByVisibleText(riskRankSele, dataMap.get("riskRankSele"));
		this.selectOptionByVisibleText(isTransferSele, dataMap.get("isTransferSele"));
		
		//添加合同
		File contract = new File(contractPath);
		logger.info("contract path is {}",contract.getAbsolutePath());
//		file_0But.sendKeys(contract.getAbsolutePath());
		file_0But.sendKeys("C:\\Users\\zhangxiao3\\Desktop\\test_data\\contract\\first.html");
		try {
			new WebDriverWait(driver, 10, 500).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return file_0But.findElement(By.xpath("../span")).getText().contains("成功");
				}
			});
		} catch (TimeoutException e) {
			logger.error("Upload contract fail.");
			throw e;
		}

		
		//项目属性
		this.selectOptionByVisibleText(projectPropertis1Sele, dataMap.get("projectPropertis1Sele"));
		this.projectDescInput.sendKeys(productName+"项目介绍");
		
		//收益率信息
		userAnnualRateInput.sendKeys(dataMap.get("userAnnualRateInput"));
		
		//提交
		submitBut.click();

		
		this.excuteJsFuntion("confirmSubmit");
		this.clickElementWithJSE(okBut);
		return new ProductListPage(driver);
	}
}
