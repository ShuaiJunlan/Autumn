/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2017 © yangxiaobing, 873559947@qq.com
 *
 * This file is part of contentManagerSystem.
 * contentManagerSystem is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * contentManagerSystem is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with contentManagerSystem.  If not, see <http://www.gnu.org/licenses/>.
 *
 * 这个文件是contentManagerSystem的一部分。
 * 您可以单独使用或分发这个文件，但请不要移除这个头部声明信息.
 * contentManagerSystem是一个自由软件，您可以自由分发、修改其中的源代码或者重新发布它，
 * 新的任何修改后的重新发布版必须同样在遵守GPL3或更后续的版本协议下发布.
 * 关于GPL协议的细则请参考COPYING文件，
 * 您可以在contentManagerSystem的相关目录中获得GPL协议的副本，
 * 如果没有找到，请连接到 http://www.gnu.org/licenses/ 查看。
 *
 * - Author: yangxiaobing
 * - Contact: 873559947@qq.com
 * - License: GNU Lesser General Public License (GPL)
 * - source code availability: http://git.oschina.net/yangxiaobing_175/contentManagerSystem
 */
package com.yxb.cms.architect.utils;

import java.text.ChoiceFormat;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * 日期处理工具类
 *
 * @author yangxiaobing
 * @date 2017/4/7
 */
public class DateUtil {
	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
	public static final String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String QFT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm";
	
	/**yyyyMMddHHmmss*/
	public static final String XIUMA_DATETIME_FORMAT = "yyyyMMddHHmmss";
	/**yyyyMMdd*/
	public static final String XIUMA_DATE_FORMAT = "yyyyMMdd";

	/**date formart : yyyyMMddHHmmss*/
	public static String toStringXiumaDateTime(Date d){
		return toString(d, XIUMA_DATETIME_FORMAT);
	}
	/**date formart : yyyyMMdd*/
	public static String toStringXiumaDate(Date d){
		return toString(d, XIUMA_DATE_FORMAT);
	}
	/**date formart : yyyyMMddHHmmss*/
	public static Date toDateXiumaDateTime(String d){
		return toDate(d, XIUMA_DATETIME_FORMAT);
	}
	/**date formart : yyyyMMdd*/
	public static Date toDateXiumaDate(String d){
		return toDate(d, XIUMA_DATE_FORMAT);
	}


	/**
	 * 日期字符串转换, 页面显示格式转换为XIUMA数据库存储格式
	 * 2006-11-14 => 20061114 
	 * */
	public static String transxiuma(String src){
		if (src==null){
			return null;
		}
		if (src.indexOf('-')<0){
			return src;
		}
		Date d = toDate(src, DEFAULT_DATE_FORMAT);
		return toStringXiumaDate(d);
	}
	
	/**
	 * 日期字符串转换, XIUMA数据库存储格式转换为页面显示格式
	 * 20061114 => 2006-11-14  
	 * */
	public static String trans2view(String src){
		if (StringUtils.isEmpty(src)){
			return "";
		}
//		return src.substring(0, 4) + src.substring(4, 6) + src.substring(6);
		Date d = toDateXiumaDate(src);
		return toString(d, DEFAULT_DATE_FORMAT);
	}
	
	
	/**
	 * 日期字符串转换, XIUMA数据库存储格式转换为页面显示格式
	 * 20061114055545 => 2006-11-14 05:55  
	 * */
	public static String trans2viewTime(String src){
		if (StringUtils.isEmpty(src)){
			return "";
		}

		Date d = toDateXiumaDateTime(src);
		return toString(d, "yyyy-MM-dd HH:mm");
	}
	
	/**
	 * 日期字符串转换, XIUMA数据库存储格式转换为页面显示格式
	 * 20061114055545 => 2006-11-14 05:55:45  
	 * */
	public static String trans3viewTime(String src){
		if (StringUtils.isEmpty(src)){
			return "";
		}

		Date d = toDateXiumaDateTime(src);
		return toString(d, DEFAULT_DATETIME_FORMAT);
	}
	
	private static final double[] LIMITS = { 0, 1, 2 };

	private static final String[] MINUTES_PART =
		{ "", "1 minute ", "{0,number} minutes " };

	private static final String[] SECONDS_PART =
		{ "0 seconds", "1 second", "{1,number} seconds" };

	private static final ChoiceFormat MINUTES_FORMAT =
		new ChoiceFormat(LIMITS, MINUTES_PART);

	private static final ChoiceFormat SECONDS_FORMAT =
		new ChoiceFormat(LIMITS, SECONDS_PART);

	private static final MessageFormat MINUTE_SECONDS =
		new MessageFormat("{0}{1}");

	static {
		MINUTE_SECONDS.setFormat(0, MINUTES_FORMAT);
		MINUTE_SECONDS.setFormat(1, SECONDS_FORMAT);
	}


	public static final long ONE_DAY = 24 * 60 * 60 * 1000;

	public static final SimpleDateFormat _defDateTimeFmt =
		new SimpleDateFormat(DEFAULT_DATETIME_FORMAT);

	public static final SimpleDateFormat _defDateFmt =
		new SimpleDateFormat(DEFAULT_DATE_FORMAT);

	public static String toString(Date date, String format) {

		SimpleDateFormat formatter;

		if ((date == null) || (format == null) || (format.length() == 0)) {
			return null;
		}
		formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}
	
	public static String toString(String str, String format) throws ParseException {

		SimpleDateFormat formatter;

		if ((str == null) || (format == null) || (format.length() == 0)) {
			return null;
		}
		formatter = new SimpleDateFormat(format);
		Date date = formatter.parse(str);
		return formatter.format(date);
	}
	

	public static Date toDate(String str, String format) {
		if ((str == null)
			|| (str.length() == 0)
			|| (format == null)
			|| (format.length() == 0)) {
			return null;
		}

		SimpleDateFormat formatter = new SimpleDateFormat(format);
		formatter.setLenient(false);
		ParsePosition pos = new ParsePosition(0);
		return formatter.parse(str, pos);
	}

	public static boolean compare(Date date1, Date date2) {
		if (date1 == null && date2 == null) {
			return true;
		}
		if (date1 == null || date2 == null)
			return false;
		else
			return date1.getTime() == date2.getTime();
	}
    /**
     * 字符串转换成Date
     * @param str
     * @return
     */
	public static Date toDate(String str) {
		try {
			if (str.indexOf(':') > 0) {
				return  toDate(str, DEFAULT_DATETIME_FORMAT);
			} else {
				return  toDate(str, DEFAULT_DATE_FORMAT);
			}
		} catch (Exception ex) {
			return null;
		}
	}
	
	

	public static String currentDateToString(String format) {
		Date date = new Date();
		return toString(date, format);
	}
	
	public static String curDateStr() {
		return _defDateFmt.format(new Date());
	}
	
	public static String curDateTimeStr() {
		return _defDateTimeFmt.format(new Date());
	}

	public static String formatElapsedTime(long millis) {
		long seconds = millis / 1000;
		long minutes = seconds / 60;
		Object[] args = { new Long(minutes), new Long(seconds % 60)};
		return MINUTE_SECONDS.format(args);
	}
	

	
	/**
	   * 取得指定月份的第一天日期
	   * @param year
	   * @param month
	   * @return
	   */
	  public static String getFirstDateOfMonth(int year, int month) {
	    if (year<0 || month>12 || month<1) return null;
	    return year + (month<10?("0"+month):(""+month)) + "01";
	  }

	  /**
	   * 取得指定月份的最后一天日期
	   * @param year
	   * @param month
	   * @return
	   */
	  public static String getLastDateOfMonth(int year, int month) {
	    if (year<0 || month>12 || month<1) return null;
	    
	    Calendar cal = Calendar.getInstance();
	    cal.set(year,month,1);  //下个月的第一天
	    cal.add(Calendar.DATE,-1); //减一天
	    
	    int day = cal.get(Calendar.DATE);
	    
	    return year + (month<10?("0"+month):(""+month)) + (day<10?("0"+day):(""+day));
	  }
	  
	  /**
	   * 取得指定日期的相隔天数对应的日期
	   * @param year
	   * @param month
	   * @param day
	   * @param days 相隔天数
	   * @return
	   */
	  public static int[] findYearMonthAndDay(int year,int month,int day,int days) {
	    int[] result = new int[3];
	    Calendar cal = Calendar.getInstance();
	    cal.set(year,month-1,day);
	    cal.add(Calendar.DATE,days);

	    result[0] = cal.get(Calendar.YEAR);
	    result[1] = cal.get(Calendar.MONTH)+1;
	    result[2] = cal.get(Calendar.DATE);
	    return result;
	  }
	  
	  /**
	   * 得到指定日期的上一天的日期
	   * @param date 格式：yyyyMMdd
	   * @return yyyyMMdd
	   */
	  public static String getPreviousDate(String date) {
		  int year = Integer.parseInt(date.substring(0,4));
		  int month = Integer.parseInt(date.substring(4,6));
		  int day = Integer.parseInt(date.substring(6,8));
		  
		  int[] result = findYearMonthAndDay(year, month, day, -1);
		  
		  return result[0] + (result[1]<10?("0"+result[1]):(""+result[1])) + (result[2]<10?("0"+result[2]):(""+result[2]));
	  }
	  /**
	   * 得到指定日期的后一天的日期
	   * @param date 格式：yyyyMMdd
	   * @return yyyyMMdd
	   */
	  public static String getBackDate(String date) {
		  int year = Integer.parseInt(date.substring(0,4));
		  int month = Integer.parseInt(date.substring(4,6));
		  int day = Integer.parseInt(date.substring(6,8));
		  
		  int[] result = findYearMonthAndDay(year, month, day, 1);
		  
		  return result[0] + (result[1]<10?("0"+result[1]):(""+result[1])) + (result[2]<10?("0"+result[2]):(""+result[2]));
	  }
	  /**
	   * 得到指定日期的前七天的日期
	   * @param date 格式：yyyyMMdd
	   * @return yyyyMMdd
	   */
	  public static String getPreviousSevenDate(String date) {
		  int year = Integer.parseInt(date.substring(0,4));
		  int month = Integer.parseInt(date.substring(4,6));
		  int day = Integer.parseInt(date.substring(6,8));
		  
		  int[] result = findYearMonthAndDay(year, month, day, -6);
		  
		  return result[0] + (result[1]<10?("0"+result[1]):(""+result[1])) + (result[2]<10?("0"+result[2]):(""+result[2]));
	  }
	  /**
	   * 2011年10月
	   * @param date 格式：yyyyMMdd或YYYYMM
	   * @return 2011年10月
	   */
	  public static String toChinaXiumaDate(String date)
	  {
		  int year = Integer.parseInt(date.substring(0,4));
		  int month = Integer.parseInt(date.substring(4,6));		  
		  
         
		  return year+"年"+month+"月";
	  }
	  /**
	   * 得到指定日期的上一个月的日期
	   * @param date 格式：yyyyMMdd或YYYYMM
	   * @return yyyyMM
	   */
	  public static String getPreMonthDate(String date)
	  {
		  int year = Integer.parseInt(date.substring(0,4));
		  int month = Integer.parseInt(date.substring(4,6));
		  int day =0;
		  if(date.length()==8)
		       day=Integer.parseInt(date.substring(6,8));
		  else day=Integer.parseInt("01");
		  
          int[] result = findYearMonth(year, month, day, -1);
		  return result[0] + (result[1]<10?("0"+result[1]):(""+result[1])) + (result[2]<10?("0"+result[2]):(""+result[2]));
	  }
	  /**
	   * 得到指定日期的上一个年的日期
	   * @param date 格式：yyyyMMdd
	   * @return yyyyMM
	   */
	  public static String getPreYearDate(String date)
	  {
		  int year = Integer.parseInt(date.substring(0,4));
		  int month = Integer.parseInt(date.substring(4,6));
		  int day=Integer.parseInt(date.substring(6,8));
		  
          int[] result = findYearDate(year, month, day, -1);
		  return result[0] + (result[1]<10?("0"+result[1]):(""+result[1]))+(result[2]<10?("0"+result[2]):(""+result[2]));
	  }
	  
	  /**
	   * 取得指定日期的相隔月数对应的日期
	   * @param year
	   * @param month
	   * @param day
	   * @param months 相隔月数
	   * @return
	   */
	  public static int[] findYearMonth(int year,int month,int day,int months) {
	    int[] result = new int[3];
	    Calendar cal = Calendar.getInstance();
	    cal.set(year,month-1,day);
	    cal.add(Calendar.MONTH ,months);

	    result[0] = cal.get(Calendar.YEAR);
	    result[1] = cal.get(Calendar.MONTH)+1;
	    result[2] = cal.get(Calendar.DATE);
	    return result;
	  }
	  /**
	   * 取得指定日期的相隔年数对应的日期
	   * @param year
	   * @param month
	   * @param day
	   * @param years 相隔年数
	   * @return
	   */
	  public static int[] findYearDate(int year,int month,int day,int years) {
	    int[] result = new int[3];
	    Calendar cal = Calendar.getInstance();
	    cal.set(year,month-1,day);
	    cal.add(Calendar.YEAR ,years);

	    result[0] = cal.get(Calendar.YEAR);
	    result[1] = cal.get(Calendar.MONTH)+1;
	    result[2] = cal.get(Calendar.DATE);
	    return result;
	  }
	  /**
	   * 校验传的日期是否是合法日期
	   * @param date 格式:yyyyMMdd
	   * @return
	   */
	  public static boolean isValidXiumaDate(String date) {
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");; 
		  try 
		  { 
			  dateFormat.parse(date); 
			  return true; 
		  } 
		  catch (Exception e) 
		  { 
			  //如果throw java.text.ParseException或者NullPointerException，就说明格式不对 
			  return false; 
		  } 
	  }
	  /**
	   * 日期间相隔的天数
	   * @param t1
	   * @param t2 
	   * @return
	   * @throws ParseException
	   */
	  public static int getBetweenDays(String t1,String t2) throws ParseException
		{
			DateFormat format = new SimpleDateFormat("yyyyMMdd"); 
			int betweenDays = 0;
			Date d1 = format.parse(t1); 
			Date d2 = format.parse(t2); 
			Calendar c1 = Calendar.getInstance(); 
			Calendar c2 = Calendar.getInstance(); 
			c1.setTime(d1); 
			c2.setTime(d2); 
			// 保证第二个时间一定大于第一个时间 
			if(c1.after(c2)){ 
			c1 = c2; 
			c2.setTime(d1); 
			} 
			int betweenYears = c2.get(Calendar.YEAR)-c1.get(Calendar.YEAR); 
			betweenDays = c2.get(Calendar.DAY_OF_YEAR)-c1.get(Calendar.DAY_OF_YEAR); 
			for(int i=0;i<betweenYears;i++){ 
			c1.set(Calendar.YEAR,(c1.get(Calendar.YEAR)+1)); 
			betweenDays += c1.getMaximum(Calendar.DAY_OF_YEAR); 
			} 
			return betweenDays+1; 
		}
	  
	  
		/**
		 * 日期字符串转换，页面显示格式为：yyyy-MM-dd HH:mm:dd
		 * @param 参数为：Date类型
		 */
		public static String Date2Stirng2Second(Date date){
			return toString(date,DEFAULT_DATETIME_FORMAT);
		}
		
		/**
		 * 日期字符串转换，页面显示格式为：yyyy-MM-dd
		 * @param 参数为：Date类型
		 */
		public static String Date2Stirng(Date date){
			return toString(date,DEFAULT_DATE_FORMAT);
		}
		
		/**
		 * 日期字符串转换，页面显示格式为：yyyy-MM-dd HH:mm:dd
		 * 参数为：String类型
		 * @throws ParseException 
		 */
		public static String Date2Stirng2Second(String date) throws ParseException{
			return toString(date,DEFAULT_DATETIME_FORMAT);
		}
		
		/**
		 * 格式化时间 格式为：yyyy-MM-dd HH:mm:dd
		 * @param dateStr 日期字符串
		 * @return Date类型
		 * @throws ParseException
		 */
		public static Date formatDateStirng(String dateStr) throws ParseException{
			return toDate(dateStr, DEFAULT_DATETIME_FORMAT);
		}
}
