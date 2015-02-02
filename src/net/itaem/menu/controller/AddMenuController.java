package net.itaem.menu.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.menu.entity.Menu;
import net.itaem.menu.service.IMenuService;
import net.itaem.user.entity.User;
import net.itaem.util.DateUtil;
import net.itaem.util.JsonUtil;
import net.itaem.util.UUIDUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 添加菜单MenuController
 * @author luohong 
 * @author 846705189@qq.com
 * @author 2015-01-31
 * */
@Controller
public class AddMenuController extends BaseController {
	
	@Autowired
	private IMenuService menuService;
	
	/**
	 * 跳转到添加menu界面
	 * @param menuId
	 * @param req
	 * @return
	 * */
	@RequestMapping("/menu/add.do")
	public String add(String parentId, HttpServletRequest req){
		if(StringUtils.isNotEmpty(parentId))
			req.setAttribute("parentId", parentId);
		
		return "menu/add";
	}

	/**
	 * 添加menu
	 * @param menuId
	 * @param name
	 * @param resp
	 * @param desc
	 * @throws IOException 
	 * */
	@RequestMapping("/menu/addSubmit.do")
	@Transactional
	public void addSubmit(Menu menu, HttpServletRequest req, HttpServletResponse resp) throws IOException{
		menu.setId(UUIDUtil.uuid());
		menu.setCreatedTime(DateUtil.getNowDate(null));
		User u = (User) req.getSession().getAttribute("user");
		menu.setCreator(u.getName());
		//默认图片
		menu.setPic("http://localhost/springmvc_mybatis/ligerUI/lib/ligerUI/skins/icons/archives.gif");
		
		menuService.add(menu);
		
		println(resp, JsonUtil.createJson("success", "add a new menu is successful"));
	}

}
