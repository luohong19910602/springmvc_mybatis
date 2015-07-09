package net.itaem.privilege.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.itaem.autogeneratecode.privilege.GeneratePrivilege;
import net.itaem.base.controller.BaseController;
import net.itaem.privilege.entity.Privilege;
import net.itaem.privilege.service.IPrivilegeService;
import net.itaem.util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 权限管理Controller
 * 这个控制器主要晚上添加权限，删除权限，更新权限这几个功能
 * @author luohong
 * @email 846705189@qq.com
 * @date 2014-12-29
 * */
@Controller
public class ListPrivilegeController extends BaseController {

	@Autowired
	private IPrivilegeService privilegeService;

	/**
	 * 跳转到系统模块首页
	 * */
	@GeneratePrivilege(name="跳转到系统模块首页",type="权限管理", uri="/privilege/list.do", desc="无")

	@RequestMapping("/privilege/list.do")
	public String list(){
		return "privilege/list";
	}

	/**
	 * 列出全部权限，这里维护好层次关系
	 * 
	 * */
	@GeneratePrivilege(name="列出全部权限，这里维护好层次关系",type="权限管理", uri="/privilege/listJson.do", desc="无")
	@RequestMapping("/privilege/listJson.do")
	public void listJson(HttpServletResponse resp) throws IOException{
		List<Privilege> privilegeList = privilegeService.listAll();
		if(privilegeList != null)
			ResponseUtil.println(resp, gridJson.privilegeListToGrid(privilegeList, privilegeList.size()));
	}
	/**
	 * 列出全部权限的json数据
	 * 这里不维护层次关系
	 * */
	@GeneratePrivilege(name="列出全部权限的json数据",type="权限管理", uri="/privilege/listGridJson.do", desc="无")
	@RequestMapping("/privilege/listGridJson.do")
	public void listGridJson(HttpServletResponse resp) throws IOException{
		//将数据变成json
		List<Privilege> privilegeList = privilegeService.listAllWithoutOrg();
		if(privilegeList != null)
			ResponseUtil.println(resp, gridJson.privilegeListToGrid(privilegeList, privilegeList.size()));
	}

	/**
	 * 打开全部的权限列表
	 * 超级管理员在选择相关连接时，需要配置每一个链接，所以这里需要列出全部的链接，并且这些链接层次关系需要维护好
	 * 比如：权限管理包含了列出权限、添加权限、修改权限、删除权限等几个模块
	 * @throws IOException 
	 * */
	@GeneratePrivilege(name="打开全部的权限列表",type="权限管理", uri="/privilege/listTreeJson.do", desc="无")
	@RequestMapping("/privilege/listTreeJson.do")
	public void listTreeJson(HttpServletResponse resp) throws IOException{
		List<Privilege> privilegeList = privilegeService.listAll();
		ResponseUtil.println(resp, treeJson.privilegeListToTreeJson(privilegeList));
	}
}
