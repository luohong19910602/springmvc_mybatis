package net.itaem.base.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.base.entity.Page;
import net.itaem.user.entity.User;
import net.itaem.view.ILigerFactory;
import net.itaem.view.IToGridJson;
import net.itaem.view.IToTreeJson;
import net.itaem.view.ligerui.DefaultLigerUiFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 这个类是基本的controller
 * 在这个里面，注入了两个工具，分别是IToGridJson，IToTreeJson，
 * 用于将数据库数据变成相关liger ui组件的json数据
 * 为了让程序的通用性更加好，这里面还有一个获取翻页信息的方法
 * 
 * @author luohong
 * @date 2015-01-15
 * @email 846705189@qq.com
 * */
public class BaseController {

	//这里使用工厂设计模式，所以在controller层，这几个类是松耦合的
	ILigerFactory factory = null;

	protected IToGridJson gridJson = null;
	protected IToTreeJson treeJson = null;

	public BaseController(){
		factory = new DefaultLigerUiFactory();
		gridJson = factory.createToGridJson();	
		treeJson = factory.createToTreeJson();
	}

	/**
	 * @param gridJson
	 * @param treeJson
	 * */
	public BaseController(IToGridJson gridJson, IToTreeJson treeJson){
		this.gridJson = gridJson;	
		this.treeJson = treeJson;
	}

	/**
	 * 提供一个方法给子类类设置
	 * @param gridJson
	 * */
	protected void setGridJson(IToGridJson gridJson){
		this.gridJson = gridJson;
	}

	/**
	 * 提供一个方法给子类类设置
	 * @param treeJson
	 * */
	protected void setTreeJson(IToTreeJson treeJson){
		this.treeJson = treeJson;
	}

	/**
	 * 调用response对象来输出数据，并且设置编码为utf-8
	 * @param resp
	 * @param message
	 * @throws IOException 
	 * */
	protected void println(HttpServletResponse resp, String message) throws IOException{
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
	 * */
	protected void println(HttpServletResponse resp, JSONArray jsonArray) throws IOException {
		println(resp, jsonArray.toString());
	}

	/**
	 * 调用response对象来输出数据，并且设置编码为utf-8
	 * @param resp
	 * @param message
	 * @throws IOException 
	 * */
	protected void println(HttpServletResponse resp, JSONObject json) throws IOException {
		println(resp, json.toString());
	}

	/**
	 * 得到用户请求的翻页对象信息
	 * @return 翻页对象信息
	 * */
	public Page getPage(HttpServletRequest req){
		Page page = new Page();
		String pageStr = req.getParameter("page");
		String pageSizeStr = req.getParameter("pagesize");

		if(pageStr != null && !"".equals(pageStr) && pageStr.matches("\\d+")){
			page.setPage(Integer.parseInt(pageStr));
		}

		if(pageSizeStr != null && !"".equals(pageSizeStr) && pageStr.matches("\\d+")){
			page.setSize(Integer.parseInt(pageSizeStr));
		}

		return page;
	}

	/**
	 * 使用alert提示用户的请求状态
	 * @param content
	 * @param resp
	 * @throws IOException 
	 * */
	public void alert(String content, HttpServletResponse resp) throws IOException{
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write("<script language='javascript'>alert('"+ content +");" + "');"
				+ "</script>");
	    resp.getWriter().flush();
	}
	
	
	/**
	 * 获取当前登录对象的user
	 * @param req
	 * @return 当前登录用户
	 * */
	public User getLoginUser(HttpServletRequest req){
		User u = (User) req.getSession().getAttribute("user");
		return u;
	}
	
	public String getLoginUserName(HttpServletRequest req, String defaultName){
		User u = getLoginUser(req);
		if(u == null){
			return defaultName;
		}else{
			return u.getName();
		}
	}
	
	/**
	 * 获得网站的更目录
	 * 
	 * */
	public String getBaseURL(HttpServletRequest req){
		String scheme = req.getScheme();
		String serverName = req.getServerName();
		String contextPath = req.getContextPath();
		int port = req.getServerPort();
		//网站的访问跟路径
		String baseURL = scheme + "://" + serverName + ":"+ port + contextPath;
		return baseURL;
	}
}
