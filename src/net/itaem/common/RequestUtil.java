package net.itaem.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * request工具类
 * @author luohong 15013336884 846705189@qq.com
 * */
public class RequestUtil {
    
	/**
	 * 获得所有请求参数
	 * @param req 请求对象
	 * @return a map of the request parameters
	 * */
	public static Map<String, String[]> params(HttpServletRequest req){
		if(req == null) return new HashMap<String, String[]>();
		
		return req.getParameterMap();
    }
	
	/**
	 * 获得某个请求参数的内容
	 * @param req 请求对象
	 * @param name 参数名
	 * @param defaultValue 默认值
	 * @return 该参数的值
	 * */
	public static String getParamByName(HttpServletRequest req, String name, String defaultValue){
		if(req == null) return defaultValue;
		String value = req.getParameter(name);
		return value == null ? defaultValue: value;
	}
	
	/**
	 * 获得网站根路劲
	 * @return
	 * */
	public static String contxtPath(HttpServletRequest req){
		String scheme = req.getScheme();
		String serverName = req.getServerName();
		String contextPath = req.getContextPath();
		int port = req.getServerPort();
		//网站的访问跟路径
		String baseURL = scheme + "://" + serverName + ":"+ port + contextPath;
		return baseURL;
	}
	
}
