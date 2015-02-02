package net.itaem.role.entity;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

/**
 * Role-Menu中间表的Mapper
 * 这里同时记录了角色id，资源id，菜单id，通过这三个id，共同确定一条resource
 * 
 * @author luohong
 * @date 2014-12-25
 * @email 846705189@qq.com
 * */
@Resource(name = "roleMenuMapper")
public interface RoleMenuMapper {
	/**
	 * 插入一条记录
	 * */
	@Insert("insert into sys_role_menu (id, role_id, menu_id,resource_id) "
			+ "values(#{id}, #{roleId}, #{menuId},#{resourceId})")
	public void add(RoleMenu roleMenu);
	
	/**
	 * 删除角色可以访问的resource
	 * 
	 * */
	@Delete("delete from sys_role_menu where "
			+ "role_id=#{roleId} and resource_id=#{resourceId} and menu_id=#{menuId}")
	public void deleteResource(RoleMenu roleMenu);
    
	/**
	 * 删除用户可以访问的menu
	 * */
	@Delete("delete from sys_role_menu where "
			+ "role_id=#{roleId} and menu_id=#{menuId}")
	public void deleteMenu(RoleMenu roleMenu);
}
