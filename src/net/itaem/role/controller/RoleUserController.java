package net.itaem.role.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.role.entity.RoleUser;
import net.itaem.role.service.IRoleService;
import net.itaem.user.entity.User;
import net.itaem.user.service.IUserService;
import net.itaem.util.JsonUtil;
import net.itaem.util.ResponseUtil;
import net.itaem.util.UUIDUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 角色用户Controller
 * @author luohong
 * @email 846705189@qq.com
 * @date 2015-01-30
 * */
@Controller
public class RoleUserController extends BaseController {

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IUserService userService;
	
	/**
	 * 跳转到添加用户界面
	 * @param roleId 角色id
	 * @param req
	 * @return 返回添加用户的界面
	 * */
	@RequestMapping("/role/addUser.do")
	public String addUser(String roleId, HttpServletRequest req){
		req.setAttribute("roleId", roleId);
		return "role/addUser";
	}

	/**
	 * 添加用户
	 * @param userIdList 用户id列表
	 * @param roleId 用户所属角色id
	 * @param resp
	 * @throws IOException 
	 * 
	 * */
	@RequestMapping("/role/addUserSubmit.do")
	public void addUserSubmit(String userList, String roleId, HttpServletResponse resp) throws IOException{
		if(userList == null) return;
		if(roleId == null) return;
		String[] userIds = userList.split(",");
		
		for(String userId: userIds){
			RoleUser roleUser = new RoleUser();

			roleUser.setUserId(userId);
			roleUser.setRoleId(roleId);
			roleUser.setId(UUIDUtil.uuid());

			roleService.addRoleUser(roleUser);
		}

		ResponseUtil.println(resp, JsonUtil.createJson("success", "add a new user to the role is successful"));
	}

	/**
	 * 从角色中删除用户列表
	 * @param userIds 要删除的用户列表
	 * @param roleId 角色id
	 * @param resp
	 * */
	@RequestMapping("/role/deleteRoleUser.do")
	public void deleteRoleUser(String userIdStr, String roleId, HttpServletResponse resp) throws IOException{
		if(userIdStr == null) return;
		if(roleId == null) return;

		String[] userIds = userIdStr.split(",");
		for(String userId: userIds){
			RoleUser roleUser = new RoleUser();
			roleUser.setUserId(userId);
			roleUser.setRoleId(roleId);
			roleService.deleteRoleUser(roleUser);
		}
		ResponseUtil.println(resp, JsonUtil.createJson("success", "delete users from role is succeccful"));
	}
	
	/**
	 * 跳转到角色下面用户的界面
	 * */
	@RequestMapping("/role/getRoleUser.do")
	public String getRoleUser(String roleId, HttpServletRequest req){
		req.setAttribute("roleId", roleId);
		return "role/roleUser";
	}

	/**
	 * 获取角色下面的用户的json数据
	 * */
	@RequestMapping("/role/getRoleUserJson.do")
	public void getRoleUserJson(String roleId, HttpServletResponse resp) throws IOException{
		List<User> userList = userService.listByRoleId(roleId);
        int total = userService.countAll();
		ResponseUtil.println(resp, gridJson.userListToGrid(userList, total));
	}
}
