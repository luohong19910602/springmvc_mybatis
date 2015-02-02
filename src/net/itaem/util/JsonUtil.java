package net.itaem.util;

import net.sf.json.JSONObject;

/**
 * 这个工具主要负责创建json数据
 * 
 * */
public class JsonUtil {
    public static final String SUCCESS = "success";
    public static final String FAIL = "fail";
    
	/**
	 * 创建一个json数据，格式如下
	 * {
	 *     status: "success",
	 *     message: "add a new user"
	 * }
	 *
	 * @param status 状态信息
	 * @param message 提示信息
	 * */
	public static String createJson(String status, String message){
    	JSONObject json = new JSONObject();
    	
    	json.put("status", status);
    	json.put("message", message);
    	
    	return json.toString();
    }
}
