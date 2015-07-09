package net.itaem.role.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.autogeneratecode.privilege.GeneratePrivilege;
import net.itaem.base.controller.BaseController;
import net.itaem.role.entity.Role;
import net.itaem.role.service.IRoleService;
import net.itaem.user.entity.User;
import net.itaem.util.DateUtil;
import net.itaem.util.JsonUtil;
import net.itaem.util.UUIDUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 添加角色Controller
 * @author luohong
 * @email 846705189@qq.com
 * @date 2015-01-30
 * */
@Controller
public class AddRoleController extends BaseController {

	@Autowired
	private IRoleService roleService;

	/**
	 * 跳转到添加子角色界面
	 * @param roleId
	 * */
	@GeneratePrivilege(name="跳转到添加子角色界面",type="角色管理", uri="/role/add.do", desc="无")
	@RequestMapping("/role/add.do")
	public String add(String roleId, HttpServletRequest req){
		if(StringUtils.isNotEmpty(roleId))
			req.setAttribute("roleId", roleId);
		return "role/add";
	}

	/**
	 * 添加子角色
	 * @param roleId
	 * @throws IOException 
	 * */
	@GeneratePrivilege(name="添加子角色",type="角色管理", uri="/role/addSubmit.do", desc="无")
	@RequestMapping("/role/addSubmit.do")
	public void addSubmit(Role role, HttpServletRequest req, HttpServletResponse resp) throws IOException{
        //validate the role name if no null
		if(StringUtils.isEmpty(role.getName())){
        	println(resp, JsonUtil.createJson("error", "角色名字不能为空"));
        	return;
        }
		//set the role id
		role.setId(UUIDUtil.uuid());
        
		//set created role info
		User user = (User) req.getSession().getAttribute("user");
		if(user != null)
			role.setCreator(user.getName());
		role.setCreatedTime(DateUtil.getNowDate(null));
        
		//add role to database
		roleService.add(role);

		//response success info
		println(resp, JsonUtil.createJson("success", "添加用户成功"));
	}
}
