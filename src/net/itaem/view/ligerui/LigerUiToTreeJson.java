package net.itaem.view.ligerui;

import java.util.List;

import net.itaem.menu.entity.Menu;
import net.itaem.privilege.entity.Privilege;
import net.itaem.role.entity.Role;
import net.itaem.view.IToTreeJson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 将menu、privilege、user、role等变成LigerUi tree组件的json字符串
 * 由于这个方法都是线程安全的，并且都是一些工具方法，所以这里使用单例模式，来实现更加高效的内存管理
 * @author luohong
 * @email 846705189@qq.com
 * @date 2015-01-12
 * */
public class LigerUiToTreeJson implements IToTreeJson {
	
	private static final LigerUiToTreeJson instance = new LigerUiToTreeJson();

	private LigerUiToTreeJson(){}

	public static LigerUiToTreeJson getInstance(){
		return instance;
	}
	/**
	 * 将Menu列表转换为LigerUi的Tree json数据
	 * @param menuList 菜单列表
	 * @return ligerui tree的json字符串
	 * @see LigerUiToTree#menuToTree()
	 * */
	public String menuListToTreeJson(List<Menu> menuList){
		if(menuList == null || menuList.size() == 0) return new JSONObject().toString();

		JSONArray json = new JSONArray();
		for(Menu menu: menuList){
			json.add(LigerUiToTree.getInstance().menuToTree(menu).toTreeJson());
		}

		return json.toString();
	}



	/**
	 * 将Privilege列表转换为LigerUi的Tree json数据
	 * @param menuList 权限列表
	 * @return ligerui tree的json字符串
	 * @see LigerUiToTree#privilegeToTree()
	 * */
	public String privilegeListToTreeJson(List<Privilege> privilegeList){
		if(privilegeList == null || privilegeList.size() == 0) return new JSONObject().toString();
		JSONArray json = new JSONArray();
		for(Privilege privilege: privilegeList){
			json.add(LigerUiToTree.getInstance().privilegeToTree(privilege).toTreeJson());
		}
		return json.toString();
	}


	/**
	 * 将Role列表转换为LigerUi的Tree json数据
	 * @param menuList 角色列表
	 * @return ligerui tree的json字符串
	 * @see LigerUiToTree#roleToTree()
	 * */
	public String roleListToTreeJson(List<Role> roleList){
		if(roleList == null || roleList.size() == 0) return new JSONObject().toString();


		JSONArray json = new JSONArray();
		for(Role role: roleList){
			json.add(LigerUiToTree.getInstance().roleToTree(role).toTreeJson());
		}
		return json.toString();
	}


}
