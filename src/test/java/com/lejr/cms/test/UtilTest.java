package com.lejr.cms.test;

import org.testng.annotations.Test;

import com.lejr.utils.LogUtil;
import com.lejr.utils.ScreenshotUtil;
import com.lejr.utils.TimeUtil;

public class UtilTest {

	@Test
	public void testreadXlsx(){
		LogUtil.beforeTest("testCreateProduct");
		String path = "C:\\Users\\zhangxiao3\\Desktop\\product-dataprovider.xlsx";
//		ReadXlsx.readXlsx(path);
		LogUtil.afterTest();
	}
	
	@Test
	public void testTimeUtil(){
		System.err.println(TimeUtil.getCurrentTime());
		System.err.println(TimeUtil.computerByDayInterval(1));
		System.err.println(TimeUtil.computerByDayInterval(5));
	}	
	@Test
	public void tesrWapperName(){
		String name1 = "[TEST]11081713PROD";
		System.err.println(name1.substring(0, 14)+"WAPPER");
	}
	
	@Test
	public void testMkdir(){
		String path = "screenshot/"+TimeUtil.getCurrentTime();
		try {
			ScreenshotUtil.createDirectory(path);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
