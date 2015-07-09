package net.itaem.role.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.autogeneratecode.privilege.GeneratePrivilege;
import net.itaem.base.controller.BaseController;
import net.itaem.role.entity.Role;
import net.itaem.role.service.IRoleService;
import net.itaem.util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 角色Controller
 * 
 * @author luohong
 * @email 846705189@qq.com
 * @date 2014-12-25
 * */
@Controller
public class RoleController extends BaseController {

	@Autowired
	private IRoleService roleService;

	/**
	 * 跳转到角色的相关信息界面
	 * 这个界面包含了角色可以访问的菜单，以及角色可以访问的权限，使用两个liger grid组件来搞定
	 * @param roleId
	 * @param req
	 * */
	@GeneratePrivilege(name="跳转到角色的相关信息界面",type="角色管理", uri="/role/openRole.do", desc="无")
	@RequestMapping("/role/openRole.do")
	public String openRole(String roleId, HttpServletRequest req){
		req.setAttribute("roleId", roleId);
		return "role/openRole";
	}


	/**
	 * 根据角色id，来获取角色的基本信息，并且跳转到角色基本信息界面
	 * @param roleId
	 * @param req
	 * @return baseInfo
	 * */
	@GeneratePrivilege(name="根据角色id，来获取角色的基本信息，并且跳转到角色基本信息界面",type="角色管理", uri="/role/getBaseInfo.do", desc="无")
	@RequestMapping("/role/getBaseInfo.do")
	public String getBaseInfo(String roleId, HttpServletRequest req){
		Role role = roleService.byId(roleId);
        
		if(role != null && role.getId() != null && !role.getId().equals(""))
			req.setAttribute("role", role);
		return "role/baseInfo";
	}

	/**
	 * 列出所有角色的数据
	 * @throws IOException 
	 * */
	@GeneratePrivilege(name="列出所有角色的数据",type="角色管理", uri="/role/listJson.do", desc="无")
	
	@RequestMapping("/role/listJson.do")
	public void listJson(HttpServletResponse resp) throws IOException{
		List<Role> roleList = roleService.listAll();
        
		ResponseUtil.println(resp, treeJson.roleListToTreeJson(roleList));
	}

	@GeneratePrivilege(name="列出所有角色的数据",type="角色管理", uri="/role/listGridJson.do", desc="无")
	
	@RequestMapping("/role/listGridJson.do")
	public void listGridJson(HttpServletResponse resp) throws IOException{
		List<Role> roleList = roleService.listAll();
		System.out.println(gridJson.roleListToGrid(roleList));
		ResponseUtil.println(resp, gridJson.roleListToGrid(roleList));
	}

	/**
	 * 跳转到角色列表界面
	 * */
	@GeneratePrivilege(name="跳转到角色列表界面",type="角色管理", uri="/role/list.do", desc="无")
	
	@RequestMapping("/role/list.do")
	public String list(){
		return "role/list";
	}

	/**
	 * 跳转到角色列表界面，这里主要是添加用户时调用
	 * 
	 * */
	@GeneratePrivilege(name="跳转到角色列表界面，这里主要是添加用户时调用",type="角色管理", uri="/role/listByTree.do", desc="无")
	
	@RequestMapping("/role/listByTree.do")
	public String listByTree(){
		return "role/listByTree";
	}
}
