package com.lejr.cms.absclazz;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;

public abstract class PageObject {
	protected WebDriver driver;
	protected static JavascriptExecutor js;
	protected static String pageLoadStatus = null;
	protected ObjectMapper mapper = new ObjectMapper();
	private static final Logger logger = LoggerFactory.getLogger(PageObject.class);

	public PageObject(WebDriver d) {
		this.driver = d;
	}

	public void clickElementWithJSE(String id) {
		// Create the object of JavaScript Executor
		// click command through Javascript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = null;
		try {
			element = driver.findElement(By.id(id));
		} catch (NoSuchElementException e) {
			logger.error("Can't find the element id = [" + id + "].", e);
			throw e;
		}
		// Use any locator type using to identify the element
		js.executeScript("arguments[0].click();", element);
		logger.info("The method clickElementWithJSE executed done with id = [" + id + "].");
		js = null;
	}

	public void clickElementWithJSE(WebElement element) {
		// Create the object of JavaScript Executor
		// click command through Javascript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Use any locator type using to identify the element
		js.executeScript("arguments[0].click();", element);
		logger.info("The method clickElementWithJSE executed done with element = [" + element + "].");
		js = null;
	}
	
	public boolean excuteJsFuntion(String functionName){
		boolean flag = false;
		if(isPageSourceContainsDynamic(functionName)){
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String script = "$(document).ready("+functionName+"());";
			js.executeScript(script);
			flag = true;
			logger.info("The function {} has executed",functionName);
			return flag;
		}
		logger.error("Can not find the function {}",functionName);
		return false;
	}
	
	public void resetElementStyleAttrToBlock(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.display='block';",element);
		js = null;
	}
	
	public void resetElementStyleAttrToNone(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.display='none';",element);
		js = null;
	}
	
	public void removeReadOnlyAttrList(String[] idList){
		for (String id : idList){
			this.removeReadOnlyAttr(id);
		}
	}

	public void removeReadOnlyAttr(String id) {
		js = (JavascriptExecutor) driver;
		// remove readonly attribute
		String script = "var setDate=document.getElementById(\"" + id + "\");setDate.removeAttribute('readonly');";
		js.executeScript(script);
		logger.info("The method removeReadOnlyAttr executed done with id = [" + id + "].");
	}
	
	public void waitClickUntilClickable(WebElement e){
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(e));
		e.click();
	}

	public WebElement waitForElementVisible(WebDriver driver, final By locator, long timeOutInSeconds,
			String errorMessage) {
		Function<WebDriver, WebElement> waitFn = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				try {
					WebElement el = driver.findElement(locator);
					if (el.isDisplayed()) {
						return el;
					}
				} catch (Exception e) {
				}
				return null;
			}
		};

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		if (errorMessage != "") {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("Cannot find Element: " + locator.toString());
		}
		return wait.until(waitFn);
	}

	public Boolean waitForElementPresent(WebDriver driver, final By locator, long timeOutInSeconds,
			String errorMessage) {
		Function<WebDriver, Boolean> waitFn = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					driver.findElement(locator);
					return true;
				} catch (Exception e) {
					return false;
				}
			}
		};

		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		if (errorMessage != "") {
			wait.withMessage(errorMessage);
		} else {
			wait.withMessage("Cannot find Element: " + locator.toString());
		}
		return wait.until(waitFn);
	}

	// 保留方法
	public boolean isPageSourceContainsDynamic(final String str) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, 10, 500).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driver) {
					return driver.getPageSource().contains(str);
				}
			});
			flag = true;
			return flag;
		} catch (TimeoutException e) {
			logger.error("The method isPageSourceContainsDynamic load for string =[" + str + "] timeout.");
			logger.error("Page source is {},str is {}",driver.getPageSource(),str);
			throw e;
		}
	}

	public boolean switchFrame(String attribute, String frameName) {
		boolean flag = false;
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		driver.switchTo().defaultContent();
		for (WebElement frame : frames) {
			if (frame.getAttribute(attribute).contains(frameName)) {
				driver.switchTo().frame(frame);
				flag = true;
				return flag;
			}
		}
		return flag;
	}

	public boolean isPageSourceContains(String str, int time) {
		boolean flag = false;
		if (driver.getPageSource().contains(str) == false) {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
			flag = true;
			return flag;
		}
		return flag;
	}

	public boolean isByElementDisplayed(By by, int time) {
		boolean flag = false;
		if (driver.findElement(by).isDisplayed() == false) {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
			if (driver.findElement(by).isDisplayed() == true) {
				flag = true;
				return flag;
			}
		}
		return flag;
	}

	public boolean isByElementDisplayed(WebElement element, int time) {
		boolean flag = false;
		if (element.isDisplayed() == false) {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
			if (element.isDisplayed() == true) {
				flag = true;
				return flag;
			}
		}
		return flag;
	}

	public boolean selectOptionByValue(WebElement element,String value)
			throws NoSuchElementException, NullPointerException {
		boolean flag = false;
		List<WebElement> allOptions = element.findElements(By.tagName("option"));
		for (WebElement option : allOptions) {
			logger.info("Get the value is {}",option.getAttribute("value"));
			if (value.equals(option.getAttribute("value"))) {
				logger.info("Find the option ,which value = [" + value + "].");
				option.click();
				logger.info("Selected the option");
				flag = true;
				return flag;
			}
		}
		logger.error("can't find the option value = {} on this element {}",value,element);
		return flag;
	}

	public boolean selectOptionByVisibleText(WebElement element, String visibleText)
			throws NoSuchElementException, NullPointerException {
		boolean flag = false;
		List<WebElement> allOptions = element.findElements(By.tagName("option"));
		// select.selectByVisibleText("visibleText$");
		for (WebElement e : allOptions) {
			logger.info("e get text {}", e.getText());
			if (e.getText().contains(visibleText)) {
				logger.info("Find the option ,which text = [" + visibleText + "].");
				e.click();
				logger.info("Selected the option");
				flag = true;
				return flag;
			}
		}
		logger.error("can't find the option visibleText = {} on this element {}",visibleText,element);
		return flag;
	}

	public boolean clickSubTag(WebElement e, String subtag) {
		boolean flag = false;
		List<WebElement> subTags = e.findElements(By.xpath("./li"));
		for (WebElement tag : subTags) {
			logger.info("subtag.getText {}", tag.getText());
			if (subtag.equals(tag.getText())) {
				tag.click();
				logger.info("Click the subtag [" + subtag + "].");
				flag = true;
				return flag;
			}
		}
		logger.error("Can not find the subtag [" + subtag + "].");
		throw new NoSuchElementException("Can not find the subtag [" + subtag + "].");
	}

	public void navigateToTargetPage(WebElement rootNode, String topTag, String subtag, String sideBarName, String mainWinName) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(sideBarName);
		logger.info("Switch to frame ["+sideBarName+"].");
		WebElement aElement = getNavigateTopTag(rootNode ,topTag);

		WebElement bElement = aElement.findElement(By.xpath("./ul"));
		resetElementStyleAttrToBlock(bElement);

		clickSubTag(bElement, subtag);
		resetElementStyleAttrToNone(bElement);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(mainWinName);
	}
	
	public WebElement getNavigateTopTag(WebElement rootNode, String topTag){
		List<WebElement> topTags = rootNode.findElements(By.xpath("./li"));
		for(WebElement e : topTags){
			logger.info("Top tag get text:{}",e.getText());
			if (e.getText().contains(topTag)){
				logger.info("Return e:{}",e.getTagName());
				return e;
			}
		}
		return null;
	}
}
