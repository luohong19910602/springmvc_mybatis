package net.itaem.util;

import java.util.StringTokenizer;

/**
 * 工具类
 * 
 * */
public class StringUtil {
 
	public static void main(String[] args){
		String str = "Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.";
		StringTokenizer st = new StringTokenizer(str);
		System.out.println(st.countTokens());
		
	}
}
