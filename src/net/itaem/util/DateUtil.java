package net.itaem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具
 * @author luohong
 * @date 2014-12-24
 * @email 846705189@qq.com
 * */
public class DateUtil {

	/**
	 * 默认时间格式
	 * */
	public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	

	/**
	 * 返回当前时间的字符串
	 * @param format 时间格式，可以为空，模式格式为yyyy-MM-dd HH:mm:ss
	 * @param return 当前时间
	 * */
	public static String getNowDate(String format) {

		Date currentTime = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat((format == null || "".equals(format)) ? DEFAULT_FORMAT : format);

		return formatter.format(currentTime);

	}

	/**
	 * 返回时间戳
	 * 这里放回的时间戳是一个字符串
	 * */
	public static String getTimeStamp(){
		return System.currentTimeMillis() + "" ;
	}

	public static void main(String[] args) throws ParseException {
		System.out.println(getNowDate("yyyy/MM/dd"));
	}
}
