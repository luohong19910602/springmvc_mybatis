package net.itaem.role.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.base.controller.BaseController;
import net.itaem.menu.entity.Menu;
import net.itaem.menu.service.IMenuService;
import net.itaem.resource.service.IResourceService;
import net.itaem.role.entity.RoleMenu;
import net.itaem.role.service.IRoleService;
import net.itaem.util.ResponseUtil;
import net.itaem.util.UUIDUtil;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 角色菜单Controller
 * @author luohong
 * @author 2015-01-30
 * @email 846705189@qq.com
 * */
@Controller
public class RoleMenuController extends BaseController {

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IMenuService menuService;

	@Autowired
	private IResourceService resourceService;
	
	/**
	 * 跳转到添加角色菜单界面
	 * */
	@RequestMapping("/role/addRoleMenu.do")
	public String addRoleMenu(String roleId, HttpServletRequest req){
		req.setAttribute("roleId", roleId);
		return "role/addRoleMenu";
	}


	/**
	 * 添加角色菜单
	 * 由于每个角色都可以访问不一样的菜单，并且对于同一个菜单，每个角色可以访问的url也是不一样的
	 * 所以这里拿到所有的resource id list之后，这里需要取出每个resource对应的menu id，然后插入到数据库中
	 * 取出数据时，先取出角色对应的menu id列表，然后再遍历每个menu，拿到角色可以访问的resource列表
	 * @param roleId 角色id
	 * @param resourceList 资源列表
	 * 所以后台需要做相应的处理
	 * 
	 * @throws IOException 
	 * */
	@RequestMapping("/role/addRoleMenuSubmit.do")
	public void addRoleMenuSubmit(String roleId, String resourceList, HttpServletResponse resp) throws IOException{
		if(resourceList != null){
			String[] resourceIds = resourceList.split(";");
			RoleMenu[] roleMenus = createRoleMenus(resourceIds, roleId);
			roleService.addRoleMenus(roleMenus);
		}
	}

	/**
	 * 创建role menu对象
	 * 
	 * */
	private RoleMenu[] createRoleMenus(String[] resourceIds, String roleId) {
		if(resourceIds == null) return null;

		RoleMenu[] roleMenus = new RoleMenu[resourceIds.length];
		int index = 0;

		//这部分内容需要放在service层
		for(String resourceId: resourceIds){
			RoleMenu roleMenu = new RoleMenu();
			roleMenu.setId(UUIDUtil.uuid());
			roleMenu.setResourceId(resourceId);
			roleMenu.setRoleId(roleId);
			//这里取出这个resource所属的menu
			net.itaem.resource.entity.Resource res = resourceService.findBy(resourceId);                

			if(res != null)
				roleMenu.setMenuId(res.getMenuId());

			roleMenus[index++] = roleMenu;
		}
		return roleMenus;

	}

	/**
	 * 删除角色的菜单
	 * 
	 * @param menuIdStr 这个参数包含了菜单id以及资源id的可能，
	 * 如果是menu id，那么就删除这个menu，如果是resource，那么就删除这个resource
	 * 
	 * @param roleId
	 * @param resp
	 * @throws IOException 
	 * */
	@RequestMapping("/role/deleteMenu.do")
	public void deleteRoleMenu(String menuIdStr, String roleId, HttpServletResponse resp) throws IOException{
		String[] menuIds = menuIdStr.split(",");

		for(String menuId: menuIds){
			net.itaem.resource.entity.Resource res = resourceService.findBy(menuId);

			if(res == null){ //删除menu
				RoleMenu roleMenu = new RoleMenu();
				roleMenu.setRoleId(roleId);
				roleMenu.setMenuId(menuId);
				roleService.deleteRoleMenu(roleMenu);
			}else{  //删除resource
				RoleMenu roleMenu = new RoleMenu();
				roleMenu.setResourceId(res.getId());
				roleMenu.setRoleId(roleId);
				roleMenu.setMenuId(res.getMenuId());

				roleService.deleteRoleMenu(roleMenu);
			}
		}
		JSONObject json = new JSONObject();
		json.put("status", "success");

		ResponseUtil.println(resp, json);
	}

	/**
	 * 跳转到获取角色menu界面
	 * */
	@RequestMapping("/role/getRoleMenu.do")
	public String getRoleMenu(String roleId, HttpServletRequest req){
		req.setAttribute("roleId", roleId);

		return "role/roleMenu";
	}

	/**
	 * 返回角色对应menu的json数据
	 * 
	 * */
	@RequestMapping("/role/getRoleMenuJson.do")
	public void getRoleMenuJson(String roleId, HttpServletRequest req, HttpServletResponse resp) throws IOException{		
		req.setAttribute("roleId", roleId);

		List<Menu> menuList = menuService.listBy(roleId);

		ResponseUtil.println(resp, gridJson.menuListToGrid(menuList));
	}
}
