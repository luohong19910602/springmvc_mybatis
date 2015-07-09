package net.itaem.role.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.autogeneratecode.privilege.GeneratePrivilege;
import net.itaem.base.controller.BaseController;
import net.itaem.privilege.entity.Privilege;
import net.itaem.privilege.service.IPrivilegeService;
import net.itaem.role.entity.RolePrivilege;
import net.itaem.role.service.IRoleService;
import net.itaem.util.ResponseUtil;
import net.itaem.util.UUIDUtil;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 角色权限Controller
 * @author luohong
 * @email 846705189@qq.com
 * @date 2015-01-30
 * */
@Controller
public class RolePrivilegeController extends BaseController {

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IPrivilegeService privilegeService;
	
	/**
	 * 删除角色的权限
	 * @param menuIdStr
	 * @param roleId
	 * @param resp
	 * @throws IOException 
	 * */
	@GeneratePrivilege(name="删除角色的权限",type="角色管理", uri="/role/deletePrivilege.do", desc="无")
	
	@RequestMapping("/role/deletePrivilege.do")
	public void deleteRolePrivilege(String privilegeIdStr, String roleId, HttpServletResponse resp) throws IOException{
		String[] privilegeIds = privilegeIdStr.split(",");

		for(String privilegeId: privilegeIds){
			RolePrivilege rolePrivilege = new RolePrivilege();
			rolePrivilege.setRoleId(roleId);
			rolePrivilege.setPrivilegeId(privilegeId);

			roleService.deleteRolePrivilege(rolePrivilege);
		}

		JSONObject json = new JSONObject();
		json.put("status", "success");

		ResponseUtil.println(resp, json);

	}

	/**
	 * 跳转到角色权限界面
	 * */
	@GeneratePrivilege(name="跳转到角色权限界面",type="角色管理", uri="/role/getRolePrivilege.do", desc="无")
	
	@RequestMapping("/role/getRolePrivilege.do")
	public String getRolePrivilege(String roleId, HttpServletRequest req){
		req.setAttribute("roleId", roleId);
		return "role/rolePrivilege";
	}

	/**
	 * 获取角色权限的json数据
	 * */
	@GeneratePrivilege(name="获取角色权限的json数据",type="角色管理", uri="/role/getRolePrivilegeJson.do", desc="无")
	
	@RequestMapping("/role/getRolePrivilegeJson.do")
	public void getRolePrivilegeJson(String roleId, HttpServletResponse resp) throws IOException{
		List<Privilege> privilegeList = privilegeService.listByRoleId(roleId);
		
		if(privilegeList != null)
			ResponseUtil.println(resp, gridJson.privilegeListToGrid(privilegeList, privilegeList.size()));
	}
	
	/**
	 * 跳转到添加角色菜单界面
	 * */
	@GeneratePrivilege(name="跳转到添加角色菜单界面",type="角色管理", uri="/role/addRolePrivilege.do", desc="无")
	
	@RequestMapping("/role/addRolePrivilege.do")
	public String addRolePrivilege(String roleId, HttpServletRequest req){
		req.setAttribute("roleId", roleId);
		return "role/addRolePrivilege";
	}

	/**
	 * 添加角色菜单
	 * @throws IOException 
	 * */
	@GeneratePrivilege(name="添加角色菜单",type="角色管理", uri="/role/addRolePrivilegeSubmit.do", desc="无")
	
	@RequestMapping("/role/addRolePrivilegeSubmit.do")
	public void addRolePrivilegeSubmit(String roleId, String privilegeIdList, HttpServletResponse resp) throws IOException{

		if(privilegeIdList != null){
			String[] privilegeIds = privilegeIdList.split(";");

			//这部分内容需要放在service层
			for(String privilegeId: privilegeIds){
				RolePrivilege rp = new RolePrivilege();
				rp.setPrivilegeId(privilegeId);
				rp.setRoleId(roleId);
				rp.setId(UUIDUtil.uuid());

				roleService.addRolePrivilege(rp);
			}
		}

		JSONObject json = new JSONObject();
		json.put("status", "success");
		ResponseUtil.println(resp, json);
	}

}
