package net.itaem.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.menu.service.IMenuService;
import net.itaem.privilege.service.IPrivilegeService;
import net.itaem.resource.service.IResourceService;
import net.itaem.role.entity.RoleUser;
import net.itaem.role.service.IRoleService;
import net.itaem.user.entity.User;
import net.itaem.user.service.IUserService;
import net.itaem.util.DateUtil;
import net.itaem.util.JsonUtil;
import net.itaem.util.MD5Util;
import net.itaem.util.ResponseUtil;
import net.itaem.util.UUIDUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 添加用户Controller
 * @author luohong
 * @date 2015-01-28
 * @email 846705189@qq.com
 * */
@Controller
public class AddUserController extends BaseController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IMenuService menuService;

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IResourceService resourceService;

	@Autowired
	private IPrivilegeService privilegeService;
	@RequestMapping("/user/add.do")
	public String add(){
		return "user/add";
	}

	/**
	 * 添加用户
	 * @param privilegeIdList 权限id列表
	 * @param roleIdList 角色id列表
	 * @param menuIdList 菜单id列表
	 * 
	 * @param resp
	 * @param resp
	 * @throws IOException 
	 * */
	@RequestMapping("/user/addSubmit.do")
	public void addSubmit(User user, String roleIdList, 
			HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//valid the input user info
		if(user.getLoginName() == null 
				|| user.getPassword() == null
				|| user.getLoginName().equals("") || user.getPassword().equals("")){
			println(resp, JsonUtil.createJson("error", "添加用户失败，角色登录名、密码不能为空"));
			return;
		}

		if(roleIdList == null || roleIdList.equals("")){
			println(resp, JsonUtil.createJson("error", "添加用户失败，角色不能为空"));
			return;
		}

		/**
		 * 不允许重复注册用户
		 * */
		if(userService.hasRegisted(user.getLoginName())){
			println(resp, JsonUtil.createJson("error", "该用户名已经被注册"));
			return;
		}

		//set created info
		User u = (User) req.getSession().getAttribute("user");
		user.setCreatedTime(DateUtil.getNowDate(null));
		user.setCreator(u.getName());

		user.setId(UUIDUtil.uuid());

		//加密密码
		user.setPassword(MD5Util.strToMD5(user.getPassword()));
		//添加用户
		userService.add(user);

		String[] roleIds = roleIdList.split(",");

		//添加用户角色
		for(String roleId: roleIds){
			RoleUser roleUser = new RoleUser();
			roleUser.setRoleId(roleId);
			roleUser.setId(UUIDUtil.uuid());
			roleUser.setUserId(user.getId());

			roleService.addRoleUser(roleUser);
		}

		ResponseUtil.println(resp, JsonUtil.createJson("success", "add a user successful"));
	}
}
