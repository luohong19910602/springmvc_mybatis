package net.itaem.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.autogeneratecode.privilege.GeneratePrivilege;
import net.itaem.base.controller.BaseController;
import net.itaem.role.entity.Role;
import net.itaem.role.entity.RoleUser;
import net.itaem.role.service.IRoleService;
import net.itaem.user.service.IUserService;
import net.itaem.util.JsonUtil;
import net.itaem.util.ResponseUtil;
import net.itaem.util.UUIDUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户权限Controller
 * @author luohong
 * @date 2015-01-28
 * @email 846705189@qq.com
 * */
@Controller
public class UserRoleController extends BaseController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;

	/**
	 * 跳转到添加用户角色界面
	 * */
	@GeneratePrivilege(name="跳转到添加用户角色界面",type="用户管理", uri="/user/addUserRole.do", desc="无")
	
	@RequestMapping("/user/addUserRole.do")
	public String addUserRole(String userId, HttpServletRequest req){
		req.setAttribute("userId", userId);
		return "user/addUserRole";
	}

	/**
	 * 添加用户角色
	 * @param userId 用户id
	 * @param resourceList 角色列表id
	 * @throws IOException 
	 * */
	@GeneratePrivilege(name="添加用户角色",type="用户管理", uri="/user/addUserRoleSubmit.do", desc="无")
	@RequestMapping("/user/addUserRoleSubmit.do")
	public void addUserRoleSubmit(String userId, String roleList, HttpServletResponse resp) throws IOException{
		String[] roleIds = roleList.split(",");

		for(String roleId: roleIds){
			RoleUser roleUser = new RoleUser();
			roleUser.setId(UUIDUtil.uuid());
			roleUser.setUserId(userId);
			roleUser.setRoleId(roleId);

			roleService.addRoleUser(roleUser);
		}

		ResponseUtil.println(resp, JsonUtil.createJson("status", "add user role successful"));
	}

	/**
	 * 删除用户的角色
	 * @throws IOException 
	 * */
	@GeneratePrivilege(name="删除用户的角色",type="用户管理", uri="/user/deleteUserRole.do", desc="无")
	
	@RequestMapping("/user/deleteUserRole.do")
	public void deleteUserRole(String userId, String roleList, HttpServletResponse resp) throws IOException{
		for(String roleId: roleList.split(",")){
			RoleUser roleUser = new RoleUser();

			roleUser.setUserId(userId);
			roleUser.setRoleId(roleId);

			roleService.deleteRoleUser(roleUser);
		}

		ResponseUtil.println(resp, JsonUtil.createJson("status", "add user role successful"));
	}

	/**
	 * 跳转到用户角色界面
	 * */
	@GeneratePrivilege(name="跳转到用户角色界面",type="用户管理", uri="/user/getUserRole.do", desc="无")
	
	@RequestMapping("/user/getUserRole.do")
	public String getUserRole(String userId, HttpServletRequest req){
		req.setAttribute("userId", userId);
		return "user/userRole";
	}
	
	/**
	 * 获取用户角色的json数据
	 * @throws IOException 
	 * 
	 * */
	@GeneratePrivilege(name="获取用户角色的json数据",type="用户管理", uri="/user/getUserRoleJson.do", desc="无")
	
	@RequestMapping("/user/getUserRoleJson.do")
	public void getUserRoleJson(String userId, HttpServletResponse resp) throws IOException{
		List<Role> roleList = roleService.listByUserId(userId);
		ResponseUtil.println(resp, gridJson.roleListToGrid(roleList));
	}
}
