package net.itaem.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.role.entity.RoleUser;
import net.itaem.user.entity.User;
import net.itaem.user.service.IUserService;
import net.itaem.util.JsonUtil;
import net.itaem.util.MD5Util;
import net.itaem.util.ResponseUtil;
import net.itaem.util.UUIDUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 更新用户Controller
 * @author luohong
 * @date 2015-01-28
 * @email 846705189@qq.com
 * */
@Controller
public class UpdateUserController extends BaseController {

	@Autowired
	private IUserService userService;

	/**
	 * 跳转到编辑用户的界面
	 * */
	@RequestMapping("/user/edit.do")
	public String edit(String userId, HttpServletRequest req){
		req.setAttribute("userId", userId);
		User user = userService.listBy(userId);

		if(user != null)
			req.setAttribute("userInfo", user);

		return "user/edit";
	}

	/**
	 * 更新用户信息
	 * @param user 要更新的用户信息
	 * @param roleIdList 角色信息列表
	 * @throws IOException 
	 * */
	@RequestMapping("/user/editSubmit.do")
	public void editSubmit(User user, String roleIdList, HttpServletResponse resp) throws IOException{
		//valid the input user info
		if(user.getLoginName() == null || user.getPassword() == null || user.getName() == null){
			return;
		}

		//加密密码
		user.setPassword(MD5Util.strToMD5(user.getPassword()));

		String[] roleIds = roleIdList.split(",");

		List<RoleUser> roleUsers = new ArrayList<RoleUser>();
		boolean hasDefaultRole = false;
		for(String roleId: roleIds){
			if(roleId.equals("root")){
				hasDefaultRole = true;
			}
			RoleUser roleUser = new RoleUser();
			roleUser.setRoleId(roleId);
			roleUser.setId(UUIDUtil.uuid());
			roleUser.setUserId(user.getId());
			roleUsers.add(roleUser);			
		}

		//如果没有选择默认角色，将默认角色加入
		if(!hasDefaultRole){
			RoleUser defaultRole = new RoleUser();
			defaultRole.setRoleId("root");
			defaultRole.setId(UUIDUtil.uuid());
			defaultRole.setUserId(user.getId());
		}
		user.setRoleUsers(roleUsers);

		//更新用户
		userService.update(user);

		ResponseUtil.println(resp, JsonUtil.createJson("succes", "更新用户信息成功"));
	}

}
