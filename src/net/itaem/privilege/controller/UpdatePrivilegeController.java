package net.itaem.privilege.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.privilege.entity.Privilege;
import net.itaem.privilege.service.IPrivilegeService;
import net.itaem.util.JsonUtil;
import net.itaem.util.ResponseUtil;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 删除权限Controller
 * 这里负责添加权限类别以及权限
 * @author luohong
 * @author 2015-01-31
 * @author 846705189@qq.com
 * */
@Controller
public class UpdatePrivilegeController extends BaseController {
	
	@Autowired
	private IPrivilegeService privilegeService;
	
	@RequestMapping("/privilege/edit.do")
	public String edit(String id, HttpServletRequest req){
		Privilege privilege = privilegeService.listBy(id);
		req.setAttribute("privilege", privilege);
		return "privilege/edit";
	}
	
	/**
	 * 提交更新privilege
	 * @param privilege
	 * @param resp
	 * */
	@RequestMapping("/privilege/editSubmit.do")
	public void editSubmit(Privilege privilege, HttpServletResponse resp) throws IOException{
		if(StringUtils.isEmpty(privilege.getId())){
			ResponseUtil.println(resp, JsonUtil.createJson("error", "更新权限失败"));
			return;
		}
		privilegeService.update(privilege);
		println(resp, JsonUtil.createJson("success", "跟新权限成功"));
	}
}
