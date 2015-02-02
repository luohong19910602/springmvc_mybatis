package net.itaem.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.base.entity.Page;
import net.itaem.user.entity.User;
import net.itaem.user.service.IUserService;
import net.itaem.util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UserController
 * 
 * 用户登录，以及权限控制中心
 * 
 * 新建一个用户时，会配置用户对应的访问权限，也就是可访问的菜单与url
 * 然后把用户的权限生成json数据，直接保存在数据库中
 * 所以每次用户尝试获取用户的菜单数据时，都需要验证用户是否登录，然后再取出数据
 * 
 * @author luohong
 * @date 2014-12-24
 * @email 846705189@qq.com 
 * */
@Controller
public class UserController extends BaseController{
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 跳转到用户列表界面
	 * */
	@RequestMapping("/user/list.do")
	public String list(HttpServletRequest req){
		Page page = new Page();
		req.setAttribute("page", page);
		return "user/list";
	}

	@RequestMapping("/user/selectUser.do")
	public String selectUser(){
		return "user/selectUser";
	}
    
	/**
	 * 跳转到添加用户基本信息界面
	 * */
	@RequestMapping("/user/baseInfo.do")
	public String baseInfo(){
		return "user/baseInfo";
	}

	/**
	 * 列出用户的数据，这里包含了分页以及查询功能
	 * */
	@RequestMapping("/user/listJson.do")
	public void listJson(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		Page page = getPage(req);
		List<User> userList = null;
		userList = userService.listAll(page);
		ResponseUtil.println(resp, gridJson.userListToGrid(userList));
	}

	/**
	 * 跳转到登录用户的基本信息界面，这里会列出用户的信息，权限，菜单等
	 * */
	@RequestMapping("/user/getLoginUserInfo.do")
	public String getLoginUserInfo(HttpServletRequest req){
		User user = (User) req.getSession().getAttribute("user");

		if(user != null)
			req.setAttribute("userInfo", user);

		return "/userInfo";
	}

	/**
	 * 跳转到用户信息界面
	 * */
	@RequestMapping("/user/getUserInfo.do")
	public String getUserInfo(String userId, HttpServletRequest req){
		req.setAttribute("userId", userId);
		User user = userService.listBy(userId);

		if(user != null)
			req.setAttribute("userInfo", user);

		return "user/userInfo";
	}

}
