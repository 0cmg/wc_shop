package com.lichking.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	
	/**
	 * 格式 yyyy MM dd HH:mm:ss
	 * @return String
	 */
	public static String getDateTime(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
		return sdf.format(date);
	}
	
	
	public static Date getTodayZero(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	public static Date getTomorrowZero(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(getTodayZero());
		cal.add(Calendar.DAY_OF_YEAR, 1);
		return cal.getTime();
	}
	
	public static Date getYesterdayZero(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(getTodayZero());
		cal.add(Calendar.DAY_OF_YEAR, -1);
		return cal.getTime();
	}
	
	public static Date getThisWeekZero(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(getTodayZero());
		cal.set(Calendar.DAY_OF_WEEK, 1);
		return cal.getTime();
	}
	
	public static Date getLastWeekZero(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(getThisWeekZero());
		cal.add(Calendar.DAY_OF_YEAR, -7);
		return cal.getTime();
	}
	
	
}
