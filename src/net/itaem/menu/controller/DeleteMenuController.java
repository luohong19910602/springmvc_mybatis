package net.itaem.menu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.menu.service.IMenuService;
import net.itaem.util.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 删除菜单MenuController
 * @author luohong 
 * @author 846705189@qq.com
 * @author 2015-01-31
 * */
@Controller
public class DeleteMenuController extends BaseController {
	@Autowired
	private IMenuService menuService;

	/**
	 * 删除菜单
	 * @param menuId
	 * @param resp
	 * @throws IOException 
	 * */
	@Transactional
	@RequestMapping("/menu/delete.do")
	public void delete(String menuId, HttpServletResponse resp) throws IOException{
		if(menuId == null || menuId.equals("root")){
			println(resp, JsonUtil.createJson("error", "菜单id不能为空"));
			return;
		}
		
		menuService.delete(menuId);
		println(resp, JsonUtil.createJson("success", "删除菜单成功"));
	}
}
