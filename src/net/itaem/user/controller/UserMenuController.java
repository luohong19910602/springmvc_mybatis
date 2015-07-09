package net.itaem.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.autogeneratecode.privilege.GeneratePrivilege;
import net.itaem.base.controller.BaseController;
import net.itaem.menu.entity.Menu;
import net.itaem.menu.service.IMenuService;
import net.itaem.resource.service.IResourceService;
import net.itaem.user.entity.User;
import net.itaem.user.entity.UserMenu;
import net.itaem.user.service.IUserService;
import net.itaem.util.ResponseUtil;
import net.itaem.util.UUIDUtil;
import net.itaem.view.ITree;
import net.itaem.view.ligerui.LigerUiToTree;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * 
 * */

/**
 * 获取用户的菜单controller
 * @author luohong
 * @date 2015-01-29
 * @email 846705189@qq.com
 * */
@Controller
public class UserMenuController extends BaseController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IMenuService menuService;

	@Autowired
	private IResourceService resourceService;

	/**
	 * 判断用户是否已经登录
	 * */
	private boolean isLogin(HttpServletRequest req) {
		User u = (User) req.getSession().getAttribute("user");
		return u != null;
	}

	/**
	 * 构建用户的菜单数据，这里的数据应该直接从数据库中获取即可
	 * 这里是整个系统的权限认证入口，会直接根据登录用户来生成用的菜单数据
	 * 所以这个方法会做如下几件事情
	 * 1、判断用户是否登录，如果没有，直接返回到登录界面
	 * 2、取出用户的菜单数据，这里使用缓存技术，将用户的菜单数据直接保存在数据库，每次直接读取数据库数据
	 * 3、直接返回json数据
	 * 这个方法主要用于获取登录用户的菜单数据
	 * @param req
	 * @param resp
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 * */
	@GeneratePrivilege(name="构建用户的菜单数据，这里的数据应该直接从数据库中获取即可",type="用户管理", uri="/user/getUserMenuJson.do", desc="无")
	
	@RequestMapping("/user/getUserMenuJson.do")
	public void getUserMenuJson(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("hello");
		//判断用户是否登录
		boolean isLogin = isLogin(req);
		
		if(!isLogin){
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			return;
		}

		//生成用户对应的菜单数据
		String json = createMenuJson(req);

		if(json != null){
			ResponseUtil.println(resp, json);
		}else{
			ResponseUtil.println(resp, new JSONObject().toString());
		}
	}

	/**
	 * 生成用户的菜单数据
	 * @param
	 * */
	private String createMenuJson(HttpServletRequest req) {
		User user = (User) req.getSession().getAttribute("user");
		if(user.getSuperUserFlag() == User.SUPER_USER){
			return loadAllMenu();
		}else{
			return loaddUserMenu(user);
		}
	}

	/**
	 * 加载用户可以访问的菜单
	 * */
	private String loaddUserMenu(User user) {
		List<Menu> menuList = menuService.listByUserId(user.getId());
		return treeJson.menuListToTreeJson(menuList);
	}

	/**
	 * 从数据库中加载全部菜单数据，这个方法由超级用户调用
	 * */
	private String loadAllMenu(){
		List<Menu> menuList = menuService.listAll(true);
		JSONArray treeJsonArray = new JSONArray();

		if(menuList != null && menuList.size() > 0){
			for(Menu menu: menuList){
				ITree tree = LigerUiToTree.getInstance().menuToTree(menu);

				treeJsonArray.add(tree.toTreeJson());
			}
		}
		return treeJsonArray.toString();
	}

	/**
	 * 跳转到添加用户菜单界面
	 * */
	@GeneratePrivilege(name="跳转到添加用户菜单界面",type="用户管理", uri="/user/addUserMenu.do", desc="无")
	
	
	@RequestMapping("/user/addUserMenu.do")
	public String addUserMenu(String userId, HttpServletRequest req){
		req.setAttribute("userId", userId);
		return "user/addUserMenu";
	}

	/**
	 * 添加用户菜单
	 * @param userId 用户id
	 * @param resourceList 资源列表id
	 * */
	@GeneratePrivilege(name="添加用户菜单",type="用户管理", uri="/user/addUserMenuSubmit.do", desc="无")
	
	@RequestMapping("/user/addUserMenuSubmit.do")
	public void addUserMenuSubmit(String userId, String resourceList, HttpServletResponse resp){
		if(resourceList != null){
			String[] resourceIds = resourceList.split(";");
			UserMenu[] userMenus = createUserMenus(resourceIds, userId);

			for(UserMenu userMenu: userMenus){
				userService.addUserMenu(userMenu);
			}
		}
	}

	/**
	 * 创建role menu对象
	 * */
	private UserMenu[] createUserMenus(String[] resourceIds, String userId) {
		if(resourceIds == null) return null;

		UserMenu[] userMenus = new UserMenu[resourceIds.length];
		int index = 0;

		//这部分内容需要放在service层
		for(String resourceId: resourceIds){
			UserMenu userMenu = new UserMenu();
			userMenu.setId(UUIDUtil.uuid());
			userMenu.setUserId(userId);
			userMenu.setResourceId(resourceId);

			//这里取出这个resource所属的menu
			net.itaem.resource.entity.Resource res = resourceService.findBy(resourceId);                

			if(res != null)
				userMenu.setMenuId(res.getMenuId());

			userMenus[index++] = userMenu;
		}
		return userMenus;

	}


	/**
	 * 删除用户菜单
	 * */
	@GeneratePrivilege(name="删除用户菜单",type="用户管理", uri="/user/deleteUserMenu.do", desc="无")
	
	@RequestMapping("/user/deleteUserMenu.do")
	public void deleteRoleMenu(String menuIdStr, String userId, HttpServletResponse resp) throws IOException{
		String[] menuIds = menuIdStr.split(",");

		for(String menuId: menuIds){
			net.itaem.resource.entity.Resource res = resourceService.findBy(menuId);

			if(res == null){  //找不到这个资源，那么代表该id是menu，所以不做任何处理
				continue;
			}

			UserMenu userMenu = new UserMenu();
			userMenu.setMenuId(res.getMenuId());
			userMenu.setResourceId(res.getId());
			userMenu.setUserId(userId);
			userService.deleteUserMenu(userMenu);
		}
		JSONObject json = new JSONObject();
		json.put("status", "success");

		ResponseUtil.println(resp, json);
	}
	
	/**
	 * 跳转到用户菜单界面
	 * */
	@GeneratePrivilege(name="跳转到用户菜单界面",type="用户管理", uri="/user/getUserMenu.do", desc="无")
	
	@RequestMapping("/user/getUserMenu.do")
	public String getUserMenu(String userId, HttpServletRequest req){
		req.setAttribute("userId", userId);

		return "user/userMenu";
	}
	
	/**
	 * 获得用户的json数据
	 * @throws IOException 
	 * */
	@GeneratePrivilege(name="获得用户的json数据",type="用户管理", uri="/user/getUserMenuJsonByUserId.do", desc="无")
	
	@RequestMapping("/user/getUserMenuJsonByUserId.do")
	public void getUserMenuJsonByUserId(String userId, HttpServletResponse resp) throws IOException{
		List<Menu> menuList = menuService.listByUserId(userId);

		ResponseUtil.println(resp, gridJson.menuListToGrid(menuList));
	}
    
}
