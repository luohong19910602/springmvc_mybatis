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
//		System.out.println(getNowDate("yyyy/MM/dd"));
		String str = "a2078a64_db6c_4a05_aa39_189b6ac6af59:sdafasdfa,db1c3f33_6e78_4626_a677_01557a31d674:asdfsdfs,f0846e30_bec8_448f_b0b1_edb6b8f6a863:dddd";
		System.out.println(str.split(",", -1)[0].split(":")[0]);
	}
}
