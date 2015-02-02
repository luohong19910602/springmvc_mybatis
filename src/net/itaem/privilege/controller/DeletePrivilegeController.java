package net.itaem.privilege.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
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
public class DeletePrivilegeController extends BaseController {
	@Autowired
	private IPrivilegeService privilegeService;

	/**
	 * 删除模块
	 * @param idsStr
	 * @param resp
	 * @throws IOException 
	 * */
	@RequestMapping("/privilege/delete.do")
	public void delete(String idsStr, HttpServletResponse resp) throws IOException{
		if(StringUtils.isEmpty(idsStr)){
            println(resp, JsonUtil.createJson("error", "删除权限失败"));
			return;
		}
		String[] ids = idsStr.split(",");
		privilegeService.delete(ids);

		ResponseUtil.println(resp, JsonUtil.createJson("success", "add a privilege is successful"));
	}
}
