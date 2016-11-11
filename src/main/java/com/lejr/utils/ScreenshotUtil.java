package com.lejr.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScreenshotUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(ScreenshotUtil.class);
	private static String path = "screenshot/"+TimeUtil.getCurrentTime();
	
	public static void screenShot(WebDriver driver) {
		try {
			createDirectory(path);
		} catch (Exception e1) {
			logger.info("Catch the exception ",e1);
		}

		try {
			File source_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // 关键代码，执行屏幕截图，默认会把截图保存到temp目录
			FileUtils.copyFile(source_file, new File(path + File.separator + TimeUtil.getTimeStampFull() + ".png")); // 这里将截图另存到我们需要保存的目录，例如screenshot\20120406-165210.png
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
    public static void createDirectory(String path) throws Exception {  
        if (StringUtils.isEmpty(path)) {  
            return;  
        }  
        try {  
            // 获得文件对象  
            File f = new File(path);  
            if (!f.exists()) {  
                logger.info("Dictionary is {} not exist , creating...",path);
                f.mkdirs();  
            }  
        } catch (Exception e) {  
            logger.error("创建目录错误.path=" + path, e);  
            throw e;  
        }  
    }  
  
    /** 
     * 新建文件. 
     *  
     * @param path 文件路径 
     * @throws Exception 
     */  
    public static void createFile(String path) throws Exception {  
        if (StringUtils.isEmpty(path)) {  
            return;  
        }  
        try {  
            // 获得文件对象  
            File f = new File(path);  
            if (f.exists()) {  
                return;  
            }  
            // 如果路径不存在,则创建  
            if (!f.getParentFile().exists()) {  
                f.getParentFile().mkdirs();  
            }  
            f.createNewFile();  
        } catch (Exception e) {  
        	logger.error("创建文件错误.path=" + path, e);  
            throw e;  
        }  
    }  
  
    /** 
     * 保存文件(文件不存在会自动创建). 
     *  
     * @param path 文件路径 
     * @param content 文件内容 
     * @throws Exception 
     */  
//    public static void saveFile(String path, String content) throws Exception {  
//        saveFile(path, content, DEFAULT_ENCODE);  
//    }  
  
    /** 
     * 保存文件(文件不存在会自动创建). 
     *  
     * @param path 文件路径 
     * @param content 文件内容 
     * @param encoding 编码(UTF-8/gb2312/...) 
     * @throws Exception 
     */  
//    public static void saveFile(String path, String content, String encoding) throws Exception {  
//        FileOutputStream fileOutputStream = null;  
//        BufferedOutputStream bw = null;  
//        try {  
//            // 获得文件对象  
//            File f = new File(path);  
//            // 默认编码UTF-8  
//            encoding = (StringUtils.isEmpty(encoding)) ? DEFAULT_ENCODE : encoding;  
//            // 如果路径不存在,则创建  
//            if (!f.getParentFile().exists()) {  
//                f.getParentFile().mkdirs();  
//            }  
//            // 开始保存文件  
//            fileOutputStream = new FileOutputStream(path);  
//            bw = new BufferedOutputStream(fileOutputStream);  
//            bw.write(content.getBytes(encoding));  
//        } catch (Exception e) {  
//            log.error("保存文件错误.path=" + path + ",content=" + content + ",encoding=" + encoding, e);  
//            throw e;  
//        } finally {  
//            if (bw != null) {  
//                try {  
//                    bw.close();  
//                } catch (IOException e1) {  
//                }  
//            }  
//            if (fileOutputStream != null) {  
//                try {  
//                    fileOutputStream.close();  
//                } catch (IOException e1) {  
//                }  
//            }  
//        }  
//    }  

}
