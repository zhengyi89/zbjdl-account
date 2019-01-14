package com.zbjdl.account.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

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
		Date date = null;
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

	public static List<String> getBetweenMonth(String startDate, String endDate) {
		List<String> resultList = new ArrayList<String>();
		try {
			Date d1 = DATE_MONTH_FORMAT.parse(startDate);// 定义起始日期
			Date d2 = DATE_MONTH_FORMAT.parse(endDate);// 定义结束日期 可以去当前月也可以手动写日期。
			Calendar dd = Calendar.getInstance();// 定义日期实例
			dd.setTime(d1);// 设置日期起始时间
			while (dd.getTime().before(d2)) {// 判断是否到结束日期
				String str = DATE_MONTH_FORMAT.format(dd.getTime());
				resultList.add(str);
				dd.add(Calendar.MONTH, 1);// 进行当前日期月份加1
			}
			resultList.add(endDate);
		} catch (Exception e) {
			System.out.println("异常" + e.getMessage());
		}
		return resultList;
	}

	public static int getMonthSpace(Date date1, Date date2) {
		int result = 0;

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(date1);
		c2.setTime(date2);
		result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

		return result == 0 ? 1 : Math.abs(result);

	}
	
	public static TreeSet<String> genDateSet(String startDate, String endDate) {
		TreeSet<String> set = new TreeSet<String>();
		List<String> list = getBetweenMonth(startDate, endDate);
		for (String string : list) {
			set.add(string);
		}
		return set;
	}

	public static TreeMap<String, String> genDateSelector(String startDate, String endDate) {
		TreeMap<String, String> map = new TreeMap<String, String>();
		List<String> list = getBetweenMonth(startDate, endDate);
		for (String string : list) {
			map.put(string, string);
		}
		return map;
	}

	public static void main(String[] args) {
		TreeMap<String, String> map = genDateSelector("2018-09", "2019-01");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey());
		}

	}

}
