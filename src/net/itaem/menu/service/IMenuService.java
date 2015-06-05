package net.itaem.menu.service;

import java.util.List;

import net.itaem.menu.entity.Menu;
import net.itaem.user.entity.User;

/**
 * 菜单service
 * @author luohong
 * @email 846705189@qq.com
 * @date 2014-12-10
 * */
public interface IMenuService {
	/**
	 * 列出全部菜单，这些菜单的层次关系已经维护好了
	 * @param containsResource 是否要列出该menu的资源
	 * @return
	 * */
	public List<Menu> listAll(boolean containsResource);
	
	/**
	 * 列出全部的菜单，但是这些菜单之间的层次关系是乱的
	 * @param containsResource 是否需要列出菜单对应的资源
	 * @return
	 * */
	public List<Menu> listAllWithoutOrg(boolean containsResource);
	
	/**
	 * 添加一个menu
	 * @param menu
	 * */
	public void add(Menu menu);
	
	/**
	 * 删除menu
	 * @param  id 菜单id
	 * */
	public void delete(String id);
	
	/**
	 * 根据角色id来查找所属的menu
	 * @param roleId
	 * */
	public List<Menu> listBy(String roleId);
	
	/**
	 * 查询用户菜单列表
	 * @param user 需要查询的用户
	 * @return 指定用户的菜单列表
	 * */
	public List<Menu> listBy(User user);
	
	/**
	 * 查询用户菜单列表
	 * @param userId 需要查询的用户
	 * @return 指定用户的菜单列表
	 * */
	public List<Menu> listByUserId(String userId);
}
