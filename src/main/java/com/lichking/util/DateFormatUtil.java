package com.lichking.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

	
	/**
	 * 格式 yyyy MM dd HH:mm:ss
	 * @return String
	 */
	public static String getDateTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH:mm:ss");
		return sdf.format(new Date());
	}
	
}
