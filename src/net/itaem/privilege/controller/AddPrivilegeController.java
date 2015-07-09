package net.itaem.privilege.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.autogeneratecode.privilege.GeneratePrivilege;
import net.itaem.base.controller.BaseController;
import net.itaem.privilege.entity.Privilege;
import net.itaem.privilege.service.IPrivilegeService;
import net.itaem.util.DateUtil;
import net.itaem.util.JsonUtil;
import net.itaem.util.UUIDUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 添加权限Controller
 * 这里负责添加权限类别以及权限
 * @author luohong
 * @author 2015-01-31
 * @author 846705189@qq.com
 * */
@Controller
public class AddPrivilegeController extends BaseController {
	
	@Autowired
	private IPrivilegeService privilegeService;
	
	/**
	 * 跳转到添加新模块权限界面
	 * @return
	 * */
	@GeneratePrivilege(name="跳转到添加新模块权限界面",type="权限管理", uri="/privilege/add.do", desc="无")
	@RequestMapping("/privilege/add.do")
	public String add(){
		return "privilege/add";
	}

	/**
	 * 添加新模块权限
	 * @param name
	 * @param url
	 * @param desc
	 * @param resp
	 * */
	@GeneratePrivilege(name="添加新模块权限",type="权限管理", uri="/privilege/addSubmit.do", desc="无")
	
	@RequestMapping("/privilege/addSubmit.do")
	public void addSubmit(Privilege privilege, HttpServletRequest req, HttpServletResponse resp) throws IOException{
		if(StringUtils.isEmpty(privilege.getName())){
			println(resp, JsonUtil.createJson("error", "权限名字不能为空"));
			return;
		}
		
		privilege.setCreatedTime(DateUtil.getNowDate(null));
		privilege.setId(UUIDUtil.uuid());
		privilegeService.add(privilege);
		println(resp, JsonUtil.createJson("success", "添加权限类别成功"));
	}

	/**
	 * 跳转到添加子模块权限界面
	 * */
	@GeneratePrivilege(name="跳转到添加子模块权限界面",type="权限管理", uri="/privilege/addChild.do", desc="无")

	@RequestMapping("/privilege/addChild.do")
	public String addChild(String parentId, HttpServletRequest req){
		req.setAttribute("parentId", parentId);
		return "privilege/addChild";
	}

	/**
	 * 添加子模块权限
	 * @param name
	 * @param url
	 * @param desc
	 * @param parentId
	 * @throws IOException 
	 * @resp
	 * 
	 * */
	@GeneratePrivilege(name="添加子模块权限",type="权限管理", uri="/privilege/addChildSubmit.do", desc="无")

	@RequestMapping("/privilege/addChildSubmit.do")
	public void addChildSubmit(Privilege privilege, HttpServletRequest req, HttpServletResponse resp) throws IOException{
		privilege.setCreator(getLoginUserName(req, ""));
		privilege.setCreatedTime(DateUtil.getNowDate(null));
		privilege.setId(UUIDUtil.uuid());
		privilegeService.add(privilege);
		println(resp, JsonUtil.createJson("success", "添加权限成功"));
	}
}
