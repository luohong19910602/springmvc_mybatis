package net.itaem.view;

import java.util.List;

import net.itaem.menu.entity.Menu;
import net.itaem.privilege.entity.Privilege;
import net.itaem.role.entity.Role;
import net.itaem.view.ligerui.LigerUiToTree;

/**
 * 将数据变成tree组件的json字符串
 * 默认情况下，这里指的tree组件是liger ui tree组件
 * 主要组件有：菜单（Menu），权限（Privilege），角色（Role）
 * @author luohong
 * @email 846705189@qq.com
 * @date 2015-01-13
 * */
public interface IToTreeJson {

	/**
	 * 将Menu列表转换为LigerUi的Tree json数据
	 * @param menuList 菜单列表
	 * @return ligerui tree的json字符串
	 * @see LigerUiToTree#menuToTree()
	 * */
	public String menuListToTreeJson(List<Menu> menuList);

	/**
	 * 将Privilege列表转换为LigerUi的Tree json数据
	 * @param menuList 权限列表
	 * @return ligerui tree的json字符串
	 * @see LigerUiToTree#privilegeToTree()
	 * */
	public String privilegeListToTreeJson(List<Privilege> privilegeList);

	/**
	 * 将Role列表转换为LigerUi的Tree json数据
	 * @param menuList 角色列表
	 * @return ligerui tree的json字符串
	 * @see LigerUiToTree#roleToTree()
	 * */
	public String roleListToTreeJson(List<Role> roleList);
}