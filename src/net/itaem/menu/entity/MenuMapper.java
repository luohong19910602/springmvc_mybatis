package net.itaem.menu.entity;
import java.util.List;

import net.itaem.role.entity.RoleMenu;
import net.itaem.user.entity.UserMenu;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


/** 
 *  MenuMapper类
 *  
 *  
 *  
 * @author luohong
 * @date 2014-12-17
 * @email 846705189@qq.com 
 */  
@Repository(value = "menuMapper")  
public interface MenuMapper {  

	@Select(value = "${sql}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "parentId", column = "menu_parent_id"),
			@Result(property = "name", column = "menu_name"),
			@Result(property = "desc", column = "menu_desc"),
			@Result(property = "createdTime", column = "menu_created_time"),
			@Result(property = "creator", column = "menu_creator"),
			@Result(property = "updatedTime", column = "menu_updated_time"),
			@Result(property = "updator", column = "menu_updator"),
			@Result(property = "delFlag", column = "menu_del_flag"),
			@Result(property = "pic", column = "menu_pic")
	})  
	List<Menu> listAll(@Param(value = "sql") String sql);  
	
	
	/**
	 * 根据id查找menu
	 * @param menuId
	 * @return 
	 * */
	@Select(value = "select * from sys_menu where id=#{menuId} and menu_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "parentId", column = "menu_parent_id"),
			@Result(property = "name", column = "menu_name"),
			@Result(property = "desc", column = "menu_desc"),
			@Result(property = "createdTime", column = "menu_created_time"),
			@Result(property = "creator", column = "menu_creator"),
			@Result(property = "updatedTime", column = "menu_updated_time"),
			@Result(property = "updator", column = "menu_updator"),
			@Result(property = "delFlag", column = "menu_del_flag"),
			@Result(property = "pic", column = "menu_pic")
	})  
	public Menu findBy(String menuId);
	
	@Insert("insert into sys_menu (id, menu_name, menu_desc, menu_created_time, menu_creator, menu_parent_id, menu_pic) "
			+ "values(#{id}, #{name}, #{desc}, #{createdTime}, #{creator}, #{parentId}, #{pic})")
	public void addChild(Menu menu);
	
	@Insert("insert into sys_menu (id, menu_name, menu_desc, menu_created_time, menu_creator, menu_pic) "
			+ "values(#{id}, #{name}, #{desc}, #{createdTime}, #{creator}, #{pic})")
	public void add(Menu menu);
	
	@Update("update sys_menu set menu_del_flag=1 where id=#{id}")
	void delete(String id);

	/**
	 * 获取角色可以访问的菜单
	 * */
	@Select(value = "select distinct sys_menu.id,sys_menu.menu_name,sys_menu.menu_parent_id,sys_menu.menu_desc,"
			+ "sys_menu.menu_created_time,sys_menu.menu_creator,"
			+ "sys_menu.menu_updated_time,sys_menu.menu_updator,"
			+ "sys_menu.menu_del_flag "
			+ "from sys_menu, sys_role_menu, sys_role "
			+ "where sys_role_menu.menu_id=sys_menu.id "
			+ "and sys_role.id=sys_role_menu.role_id "
			+ "and sys_role.id=#{roleId} and sys_menu.menu_del_flag=0 and sys_role.role_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "parentId", column = "menu_parent_id"),
			@Result(property = "name", column = "menu_name"),
			@Result(property = "desc", column = "menu_desc"),
			@Result(property = "createdTime", column = "menu_created_time"),
			@Result(property = "creator", column = "menu_creator"),
			@Result(property = "updatedTime", column = "menu_updated_time"),
			@Result(property = "updator", column = "menu_updator"),
			@Result(property = "delFlag", column = "menu_del_flag"),
			@Result(property = "pic", column = "menu_pic")
	})  
	List<Menu> listByRoleId(String roleId);
	
	/**
	 * 获取用户可以访问的菜单
	 * */
	@Select(value = "select distinct sys_menu.id,sys_menu.menu_name,sys_menu.menu_parent_id,sys_menu.menu_desc,"
			+ "sys_menu.menu_created_time,sys_menu.menu_creator,"
			+ "sys_menu.menu_updated_time,sys_menu.menu_updator,"
			+ "sys_menu.menu_del_flag "
			+ "from sys_menu, sys_user_menu, sys_user "
			+ "where sys_user_menu.menu_id=sys_menu.id "
			+ "and sys_user.id=sys_user_menu.user_id "
			+ "and sys_user.id=#{userId} and sys_menu.menu_del_flag=0 and sys_user.user_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "parentId", column = "menu_parent_id"),
			@Result(property = "name", column = "menu_name"),
			@Result(property = "desc", column = "menu_desc"),
			@Result(property = "createdTime", column = "menu_created_time"),
			@Result(property = "creator", column = "menu_creator"),
			@Result(property = "updatedTime", column = "menu_updated_time"),
			@Result(property = "updator", column = "menu_updator"),
			@Result(property = "delFlag", column = "menu_del_flag"),
			@Result(property = "pic", column = "menu_pic")
	})  
	List<Menu> listByUserId(String userId);
	
	/**
	 * 查找用户的资源
	 * @param userMenu
	 * @return
	 * */
	@Select(value = "select distinct "
			+ "sys_resource.id,sys_resource.resource_name,sys_resource.resource_url,"
			+ "sys_resource.resource_desc,sys_resource.resource_url,sys_resource.resource_created_time,sys_resource.resource_creator,"
			+ "sys_resource.resource_updated_time,sys_resource.resource_updator "
			+ "from sys_user_menu,sys_menu,sys_resource,sys_user "
			+ "where sys_user_menu.menu_id=sys_menu.id "
			+ "and sys_user.id=sys_user_menu.user_id "
			+ "and sys_user_menu.menu_id=#{menuId} "
			+ "and sys_user_menu.user_id=#{userId}"
			+ "and sys_user_menu.resource_id=sys_resource.id "
			+ "and sys_resource.resource_menu_id=sys_menu.id "
			+ "and sys_menu.menu_del_flag=0 and sys_resource.resource_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "parentId", column = "resource_parent_id"),
			@Result(property = "name", column = "resource_name"),
			@Result(property = "url", column = "resource_url"),		
			@Result(property = "desc", column = "resource_desc"),
			@Result(property = "createdTime", column = "resource_created_time"),
			@Result(property = "creator", column = "resource_creator"),
			@Result(property = "updatedTime", column = "resource_updated_time"),
			@Result(property = "updator", column = "resource_updator"),
			@Result(property = "delFlag", column = "resource_del_flag")
	})  
	public List<net.itaem.resource.entity.Resource> findByUserAndMenu(UserMenu userMenu);
	
	/**
	 * 查找用户的资源
	 * @param userMenu
	 * @return
	 * */
	@Select(value = "select distinct "
			+ "sys_resource.id,sys_resource.resource_name,sys_resource.resource_url,"
			+ "sys_resource.resource_desc,sys_resource.resource_url,sys_resource.resource_created_time,sys_resource.resource_creator,"
			+ "sys_resource.resource_updated_time,sys_resource.resource_updator "
			+ "from sys_role_menu,sys_menu,sys_resource,sys_role "
			+ "where sys_role_menu.menu_id=sys_menu.id "
			+ "and sys_role.id=sys_role_menu.role_id "
			+ "and sys_role_menu.menu_id=#{menuId} "
			+ "and sys_role_menu.role_id=#{roleId}"
			+ "and sys_role_menu.resource_id=sys_resource.id "
			+ "and sys_resource.resource_menu_id=sys_menu.id "
			+ "and sys_menu.menu_del_flag=0 and sys_resource.resource_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "parentId", column = "resource_parent_id"),
			@Result(property = "name", column = "resource_name"),
			@Result(property = "url", column = "resource_url"),		
			@Result(property = "desc", column = "resource_desc"),
			@Result(property = "createdTime", column = "resource_created_time"),
			@Result(property = "creator", column = "resource_creator"),
			@Result(property = "updatedTime", column = "resource_updated_time"),
			@Result(property = "updator", column = "resource_updator"),
			@Result(property = "delFlag", column = "resource_del_flag"),
			@Result(property = "pic", column = "resource_pic")
	})  
	public List<net.itaem.resource.entity.Resource> findByRoleAndMenu(RoleMenu roleMenu);
	
} 