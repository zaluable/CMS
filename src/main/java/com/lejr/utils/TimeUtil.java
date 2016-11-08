package com.lejr.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
	public static String getCurrentTime() {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
//		"yyyy-MM-dd HH:mm:ss"
		SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormate.format(date);
	}
	
	public static String computerByDayInterval(int day){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH, day);
		Date date = calendar.getTime();
		SimpleDateFormat dateFormate = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormate.format(date);
	}

	public static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmm");
		return sdf.format(date);
	}
}
