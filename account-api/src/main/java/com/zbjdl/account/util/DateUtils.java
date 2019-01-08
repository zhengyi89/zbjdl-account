package com.zbjdl.account.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	public static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	
	
	/**
	 * 要用到的DATE Format的定义
	 */
	public static final String DATE_ONLY = "yyyy-MM-dd"; // 年/月/日
	public static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss"; // 年/月/日
	public static final String DATEONLY = "yyyyMMdd";
	public static final String DATE_MONTH = "yyyy-MM";
	
	public static final SimpleDateFormat DATEONLYFORMAT = new SimpleDateFormat(DATEONLY);
	public static final SimpleDateFormat DATE_ONLY_FORMAT = new SimpleDateFormat(DATE_ONLY);
	public static final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat(DATE_TIME);
	public static final SimpleDateFormat HMS_FORMAT = new SimpleDateFormat("HH:mm:ss");
	public static final SimpleDateFormat DATE_MONTH_FORMAT = new SimpleDateFormat(DATE_MONTH);

	public static Date addMonth(Date date, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + month);
		return calendar.getTime();
	}
	
	public static String addMonth(String dateStr, int month) {
		Date date =null;
		try {
			date = DateUtils.DATE_MONTH_FORMAT.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + month);
		return DateUtils.DATE_MONTH_FORMAT.format(calendar.getTime());
	}
	
	
}
