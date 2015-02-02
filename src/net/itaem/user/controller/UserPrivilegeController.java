package net.itaem.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.privilege.entity.Privilege;
import net.itaem.privilege.service.IPrivilegeService;
import net.itaem.user.entity.UserPrivilege;
import net.itaem.user.service.IUserService;
import net.itaem.util.JsonUtil;
import net.itaem.util.ResponseUtil;
import net.itaem.util.UUIDUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户权限 Controller
 * 
 * @author luohong
 * @date 2015-01-28
 * @email 846705189@qq.com
 * */
@Controller
public class UserPrivilegeController extends BaseController {
	@Autowired
	private IUserService userService;

	@Autowired
	private IPrivilegeService privilegeService;
	
	
	/**
	 * 跳转到用权限界面
	 * */
	@RequestMapping("/user/getUserPrivilege.do")
	public String getUserPrivilege(String userId, HttpServletRequest req){
		req.setAttribute("userId", userId);
		return "user/userPrivilege";
	}
    
	/**
	 * 获取用户权限的json数据
	 * @throws IOException 
	 * 
	 * */
	@RequestMapping("/user/getUserPrivilegeJson.do")
	public void getUserPrivilegeJson(String userId, HttpServletResponse resp) throws IOException{
		List<Privilege> privilegeList = privilegeService.listByUserId(userId);
		if(privilegeList != null)
			ResponseUtil.println(resp, gridJson.privilegeListToGrid(privilegeList, privilegeList.size()));
	}
	
	/**
	 * 跳转到添加用户权限界面
	 * */
	@RequestMapping("/user/addUserPrivilege.do")
	public String addUserPrivilege(String userId, HttpServletRequest req){
		req.setAttribute("userId", userId);
		return "user/addUserPrivilege";
	}
	
	/**
	 * 添加用户权限
	 * @param userId 用户id
	 * @param privilegeList 权限列表id
	 * @throws IOException 
	 * */
	@RequestMapping("/user/addUserPrivilegeSubmit.do")
	public void addUserPrivilegeSubmit(String userId, String privilegeList, HttpServletResponse resp) throws IOException{
		String[] privilegeIds = privilegeList.split(";");
		userService.addUserPrivileges(createUserPrivileges(privilegeIds, userId, true));
		ResponseUtil.println(resp, JsonUtil.createJson("success", "添加权限成功"));
	}

	/**
	 * 删除用户的权限，但是这里删除的权限只是属于用户的权限，不能删除用户所属角色的权限
	 * */
	@RequestMapping("/user/deleteUserPrivilege.do")
	public void deleteUserPrivilege(String privilegeIdStr, String userId, HttpServletResponse resp) throws IOException{
		String[] privilegeIds = privilegeIdStr.split(",");
		userService.deleteUserPrivileges(createUserPrivileges(privilegeIds, userId, false));
		ResponseUtil.println(resp, JsonUtil.createJson("success", "delete user privileges successful"));
	}
	
	/**
	 * 根据权限id列表，用户id，来生成UserPrivilege数组
	 * @param privilegeIds 权限id列表
	 * @param userId 用户id
	 * @param hasId 是否需要包含id，因为添加数据时，需要id，删除时不需要，所以提供一个回调的接口
	 * */
	private UserPrivilege[] createUserPrivileges(String[] privilegeIds, String userId, boolean hasId){
		UserPrivilege[] userPris = new UserPrivilege[privilegeIds.length];
		int index = 0;
		for(String privilegeId: privilegeIds){
			UserPrivilege userPri = new UserPrivilege();
			if(hasId)
				userPri.setId(UUIDUtil.uuid());
			userPri.setUserId(userId);
			userPri.setPrivilegeId(privilegeId);
			userPris[index++] = userPri;
		}
		return userPris;
	}
}
