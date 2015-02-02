package net.itaem.util;

import java.util.UUID;

/**
 * 用来生成一个uuid字符串，这里生成的字符串会用在数据库的id中
 * @author luohong
 * @email 846705189@qq.com
 * @date 2015-01-15
 * */
public class UUIDUtil {

	/**
	 * 返回一个字符串，这里会调用UUID来生成
	 * @return 返回一个uuid字符串
	 * */
	public static String uuid(){
		String uuid = UUID.randomUUID().toString();
		return uuid.replaceAll("-", "_");
	}
}
