package net.itaem.role.service;

import java.util.List;

import net.itaem.role.entity.Role;
import net.itaem.role.entity.RoleMenu;
import net.itaem.role.entity.RolePrivilege;
import net.itaem.role.entity.RoleUser;

public interface IRoleService {

	/**
	 * 列出全部的角色
	 * 并且角色之间必须维护好层次管理
	 * 并且这里的角色必须把可以访问的菜单也查询出来
	 * 
	 * @return
	 * */
	public List<Role> listAll();
	
	/**
	 * 列出全部的角色
	 * 角色的层次关系没有维护好
	 * @return
	 * */
	public List<Role> listAllWithoutOrg();

	/**
	 * 删除一个角色
	 * @param id
	 * 
	 * */
	public void delete(String id);

	public void add(Role role);

	/**
	 * 根据角色id查找一个角色
	 * @param roleId
	 * @return 
	 * */
	public Role byId(String roleId);

	/**
	 * 添加一个role menu
	 * */
	public void addRoleMenu(RoleMenu roleMenu);
	
	/**
	 * 添加多个role menu
	 * @param roleMenus
	 * */
	public void addRoleMenus(RoleMenu[] roleMenus);

	public void deleteRoleMenu(RoleMenu roleMenu);

	/**
	 * 添加一个role privilege
	 * */
	public void addRolePrivilege(RolePrivilege rolePrivilege);

	/**
	 * 删除一个role privilege
	 * */
	public void deleteRolePrivilege(RolePrivilege rolePrivilege);


	public void addRoleUser(RoleUser roleUser);

	public void deleteRoleUser(RoleUser roleUser);
	
	/**
	 * 获取用户所属的角色列表
	 * */
	public List<Role> listByUserId(String userId);

}
