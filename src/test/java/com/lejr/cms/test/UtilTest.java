package com.lejr.cms.test;

import org.testng.annotations.Test;

import com.lejr.utils.LogUtil;
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
	

}