package net.itaem.menu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.autogeneratecode.privilege.GeneratePrivilege;
import net.itaem.base.controller.BaseController;
import net.itaem.menu.entity.Menu;
import net.itaem.menu.service.IMenuService;
import net.itaem.util.ResponseUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 菜单Menu的Controller
 * 
 * 这个Controller主要负责添加menu，删除menu，列出menu的json数据
 * 
 * @author luohong
 * @date 2014-12-10
 * @email 846705189@qq.com
 * */
@Controller
public class ListMenuController extends BaseController {
	
	@Autowired
	private IMenuService menuService;

	/**
	 * 跳转到/WEB-INF/menu/list.jsp
	 * @return 
	 * */
	@GeneratePrivilege(name="跳转到menu列表界面",type="菜单管理", uri="/menu/list.do", desc="无")
	@RequestMapping("/menu/list.do")
	public String list(HttpServletRequest req, HttpServletResponse resp){
		return "menu/list";
	}

	/**
	 * 获取菜单的数据
	 * 这里的数据不包括resource数据
	 * @throws IOException 
	 * */
	@GeneratePrivilege(name="列出menu的json",type="菜单管理", uri="/menu/listJson.do", desc="无")
	@RequestMapping("/menu/listJson.do")
	public void listJson(HttpServletResponse resp) throws IOException{
		ResponseUtil.println(resp, listJson(false));
	}

	/**
	 * 获取菜单的grid数据格式的数据，并且这里不需要resource
	 * */
	@GeneratePrivilege(name="列出menu的grid json",type="菜单管理", uri="/menu/listGridJson.do", desc="无")
	@RequestMapping("/menu/listGridJson.do")
	public void listGridJson(HttpServletResponse resp) throws IOException{
		List<Menu> menuList = menuService.listAll(true);
		ResponseUtil.println(resp, gridJson.menuListToGrid(menuList));
	}

	/**
	 * 获取菜单的数据
	 * 这里的数据包括resource数据
	 * 如果这个菜单本身不含有任何可以访问的资源url，那么这个菜单就不会显示出来
	 * @throws IOException 
	 * */
	@GeneratePrivilege(name="列出menu的tree json",type="菜单管理", uri="/menu/listJsonWithResource.do", desc="无")
	@RequestMapping("/menu/listJsonWithResource.do")
	public void listJsonWithResource(HttpServletResponse resp) throws IOException{
		List<Menu> menuList = menuService.listAll(true);
		ResponseUtil.println(resp, treeJson.menuListToTreeJson(menuList));
	}

	/**
	 * 获取权限的数据
	 * @param containsResource 是否要包含resource资源数据
	 * @return
	 * */
	private String listJson(boolean containsResource){
		List<Menu> menuList = menuService.listAll(containsResource);
		return treeJson.menuListToTreeJson(menuList);
	}
}
