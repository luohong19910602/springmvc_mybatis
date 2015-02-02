package net.itaem.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 调用 HttpServletResponse 对象的getWriter().println()输出数据到前台，
 * 并且这里设置编码格式为utf-8格式
 * 这样子可以解决很多response输出数据乱码问题
 * @author luohong
 * @email 846705189@qq.com
 * @Darte 2015-1-01-08
 * */
public class ResponseUtil {
    
	/**
	 * 调用response对象来输出数据，并且设置编码为utf-8
	 * @param resp
	 * @param message
	 * @throws IOException 
	 * */
	public static void println(HttpServletResponse resp, String message) throws IOException{
		/*设置字符集为'UTF-8'*/
		resp.setContentType("text/json"); 
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().println(message);
		resp.getWriter().flush();
    }
	
	/**
	 * 调用response对象来输出数据，并且设置编码为utf-8
	 * @param resp
	 * @param message
	 * @throws IOException 
	 * @see ResponseUtil#println(HttpServletResponse resp, String message)
	 * */
	public static void println(HttpServletResponse resp, JSONArray jsonArray) throws IOException {
		println(resp, jsonArray.toString());
	}
	
	/**
	 * 调用response对象来输出数据，并且设置编码为utf-8
	 * @param resp
	 * @param message
	 * @throws IOException 
	 * @see ResponseUtil#println(HttpServletResponse resp, String message)
	 * */
	public static void println(HttpServletResponse resp, JSONObject json) throws IOException {
		println(resp, json.toString());
	}
	
	
}
