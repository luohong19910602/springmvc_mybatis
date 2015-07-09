package net.itaem.role.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.itaem.autogeneratecode.privilege.GeneratePrivilege;
import net.itaem.role.service.IRoleService;
import net.itaem.util.ResponseUtil;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 添加角色Controller
 * @author luohong
 * @email 846705189@qq.com
 * @date 2015-01-30
 * */
@Controller
public class DeleteRoleController {
	
	@Autowired
	private IRoleService roleService;

	/**
	 * 删除一个Role
	 * @throws IOException 
	 * */
	@GeneratePrivilege(name="删除角色",type="角色管理", uri="/role/delete.do", desc="无")
	@RequestMapping("/role/delete.do")
	@Transactional
	public void delete(String roleId, HttpServletResponse resp) throws IOException{
		if(roleId == null || "".equals(roleId)) return;
		if(roleId.equals("root")) return;

		roleService.delete(roleId);
		JSONObject json = new JSONObject();
		json.put("status", "success");
		resp.getWriter().println(json.toString());
		ResponseUtil.println(resp, json);
	}

}
