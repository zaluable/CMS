package com.lejr.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtil {
	 private static final Logger logger = LoggerFactory.getLogger(LogUtil.class);
	 
	 public static void beforeTest(String testName){
		 logger.info("********************************************************************");
		 logger.info("---------------------- "+testName+ " Start -------------------------");
	 }
	 
	 public static void afterTest(){
		 logger.info("------------------------ Finish ------------------------------------");
		 logger.info("********************************************************************");
	 }
}
