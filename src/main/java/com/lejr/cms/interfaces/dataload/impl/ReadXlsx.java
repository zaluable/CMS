package com.lejr.cms.interfaces.dataload.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;

import com.lejr.cms.interfaces.DataResourceLoadInterface;

public class ReadXlsx implements DataResourceLoadInterface{
	public static HashMap<String, String> readXlsx(String dataPath, Logger logger){
		HashMap<String, String> dataMap = new HashMap<String, String>();
		XSSFWorkbook xssfWorkbook = null;
		try {
			xssfWorkbook = new XSSFWorkbook(dataPath);
		} catch (IOException e) {
			logger.error("readXlsx method accurd a IOException", e);
		}
		XSSFSheet xssfSheet = xssfWorkbook.getSheet("productData");
		if(xssfSheet == null){
			logger.error("The sheet named productData is null");
			System.exit(1);
		}
		//getTitle
		String[] titleList = loopTitleCell(xssfSheet, logger);
		
		//循环row
		for(int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++){
			XSSFRow xssfRow = xssfSheet.getRow(rowNum);
			if(xssfRow == null){
				logger.error("The xssfRow is null, num =["+rowNum+"].");
				System.exit(1);
			}
			//循环cell
			logger.info("XssfRow.getLastCellNum {}",xssfRow.getLastCellNum());
			for(int cellNum = 0; cellNum < xssfRow.getLastCellNum(); cellNum++){
				XSSFCell xssfCell = xssfRow.getCell(cellNum);
				xssfCell.setCellType(CellType.STRING);
				String content = xssfCell.getStringCellValue();
				logger.info("Loop content {}",titleList[cellNum]+"  "+content);
				dataMap.put(titleList[cellNum], content);
			}
		}
		logger.info("Return dataMap {}", dataMap.toString());
		return dataMap;
	}
	
	private static String[] loopTitleCell(XSSFSheet xssfSheet, Logger logger){
		XSSFRow firstRow = xssfSheet.getRow(0);
		logger.info("FirstRow.getLastCellNum {}",firstRow.getLastCellNum());
		String[] titleList = new String[firstRow.getLastCellNum()];
		for(int cellNum = 0; cellNum < firstRow.getLastCellNum(); cellNum++){
			XSSFCell xssfCell = firstRow.getCell(cellNum);
			xssfCell.setCellType(CellType.STRING);
			String title = xssfCell.getStringCellValue();
			titleList[cellNum] = title;
			logger.info("Loop title {}",title);
		}
		logger.info("Return titleList {}",Arrays.toString(titleList));
		return titleList;
	}
}
