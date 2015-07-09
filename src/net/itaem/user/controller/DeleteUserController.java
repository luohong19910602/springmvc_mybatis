package net.itaem.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.itaem.autogeneratecode.privilege.GeneratePrivilege;
import net.itaem.base.controller.BaseController;
import net.itaem.user.service.IUserService;
import net.itaem.util.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 删除用户Controller
 * @author luohong
 * @date 2015-01-28
 * @email 846705189@qq.com
 * */
@Controller
public class DeleteUserController extends BaseController {
	
	@Autowired
	private IUserService userService;

	/**
	 * 删除用户
	 * 
	 * */
	@GeneratePrivilege(name="删除用户",type="用户管理", uri="/user/delete.do", desc="无")
	
	@RequestMapping("/user/delete.do")
	public void delete(String[] ids, HttpServletResponse resp) throws IOException{
		if(ids == null || ids.equals("") || ids.length == 0){
			println(resp, JsonUtil.createJson("error", "删除用户失败，id不能不空"));
			return;
		}

		System.out.println(ids);
		for(String id: ids){
			System.out.println(id);
		}
		
		userService.delete(ids);

		println(resp, JsonUtil.createJson("success", "删除用户成功"));
	}
}
