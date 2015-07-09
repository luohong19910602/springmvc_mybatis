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

	@Select(value = "select * from sys_menu where _del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "parentId", column = "_parent_id"),
			@Result(property = "name", column = "_name"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "pic", column = "_pic")
	})  
	List<Menu> listAll();  


	/**
	 * 根据id查找menu
	 * @param menuId
	 * @return 
	 * */
	@Select(value = "select * from sys_menu where _id=#{menuId} and _del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "parentId", column = "_parent_id"),
			@Result(property = "name", column = "_name"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "pic", column = "_pic")
	})  
	public Menu findBy(String menuId);

	@Insert("insert into sys_menu (_id, _name, _desc, _created_time, _creator, _parent_id, _pic) "
			+ "values(#{id}, #{name}, #{desc}, #{createdTime}, #{creator}, #{parentId}, #{pic})")
	public void addChild(Menu menu);

	@Insert("insert into sys_menu (_id, _name, _desc, _created_time, _creator, _pic) "
			+ "values(#{id}, #{name}, #{desc}, #{createdTime}, #{creator}, #{pic})")
	public void add(Menu menu);

	@Update("update sys_menu set _del_flag=1 where _id=#{id}")
	void delete(String id);

	/**
	 * 获取角色可以访问的菜单
	 * */
	@Select(value = "select distinct sys_menu._id,sys_menu._name,sys_menu._parent_id,sys_menu._desc,"
			+ "sys_menu._created_time,sys_menu._creator,"
			+ "sys_menu._updated_time,sys_menu._updator,"
			+ "sys_menu._del_flag "
			+ "from sys_menu, sys_role_menu, sys_role "
			+ "where sys_role_menu._menu_id=sys_menu._id "
			+ "and sys_role._id=sys_role_menu._role_id "
			+ "and sys_role._id=#{roleId} "
			+ "and sys_menu._del_flag=0 "
			+ "and sys_role._del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "parentId", column = "_parent_id"),
			@Result(property = "name", column = "_name"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "pic", column = "_pic")
	})  
	List<Menu> listByRoleId(String roleId);

	/**
	 * 获取用户可以访问的菜单
	 * select distinct sys_menu._id,sys_menu._desc,sys_menu._name,sys_menu._creator,sys_menu._created_time,sys_menu._updated_time,sys_menu._updator,sys_menu._parent_id,sys_menu._pic,sys_user._id as _user_id 
from sys_user,sys_role_user,sys_role,sys_role_menu,sys_menu
where sys_user._id=sys_role_user._user_id
and sys_role_user._role_id=sys_role._id
and sys_role._id=sys_role_menu._role_id
and sys_role_menu._menu_id=sys_menu._id

union 
select distinct sys_menu._id,sys_menu._desc,sys_menu._name,sys_menu._creator,sys_menu._created_time,sys_menu._updated_time,sys_menu._updator,sys_menu._parent_id,sys_menu._pic,sys_user._id as _user_id 
from sys_user,sys_user_menu,sys_menu
where sys_user._id=sys_user_menu._user_id
and sys_user_menu._menu_id=sys_menu._id;

	 * */
	@Select(value="select * from sys_user_menu_view where _user_id=#{userId}")
	//	@Select(value = "select distinct sys_menu._id,sys_menu._name,sys_menu._parent_id,sys_menu._desc,"
	//			+ "sys_menu._created_time,sys_menu._creator,"
	//			+ "sys_menu._updated_time,sys_menu._updator,"
	//			+ "sys_menu._del_flag "
	//			+ "from sys_menu, sys_user_menu, sys_user "
	//			+ "where sys_user_menu._menu_id=sys_menu._id "
	//			+ "and sys_user._id=sys_user_menu._user_id "
	//			+ "and sys_user._id=#{userId} "
	//			+ "and sys_menu._del_flag=0 and sys_user._del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "parentId", column = "_parent_id"),
			@Result(property = "name", column = "_name"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "pic", column = "_pic")
	})  
	List<Menu> listByUserId(String userId);

	/**
	 * 查找用户的资源
	 * @param userMenu
	 * @return
	 * */
	@Select(value = "select distinct "
			+ "sys_resource._id,sys_resource._name,sys_resource._url,"
			+ "sys_resource._desc,sys_resource._url,sys_resource._created_time,sys_resource._creator,"
			+ "sys_resource._updated_time,sys_resource._updator "
			+ "from sys_user_menu,sys_menu,sys_resource,sys_user "
			+ "where sys_user_menu._menu_id=sys_menu._id "
			+ "and sys_user._id=sys_user_menu._user_id "
			+ "and sys_user_menu._menu_id=#{menuId} "
			+ "and sys_user_menu._user_id=#{userId}"
			+ "and sys_user_menu._resource_id=sys_resource._id "
			+ "and sys_resource._menu_id=sys_menu._id "
			+ "and sys_menu._del_flag=0 and sys_resource._del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "parentId", column = "_parent_id"),
			@Result(property = "name", column = "_name"),
			@Result(property = "url", column = "_url"),		
			@Result(property = "desc", column = "_desc"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag")
	})  
	public List<net.itaem.resource.entity.Resource> findByUserAndMenu(UserMenu userMenu);

	/**
	 * 查找用户的资源
	 * @param userMenu
	 * @return
	 * */
	@Select(value = "select distinct "
			+ "sys_resource._id,sys_resource._name,sys_resource._url,"
			+ "sys_resource._desc,sys_resource._url,sys_resource._created_time,sys_resource._creator,"
			+ "sys_resource._updated_time,sys_resource._updator "
			+ "from sys_role_menu,sys_menu,sys_resource,sys_role "
			+ "where sys_role_menu._menu_id=sys_menu._id "
			+ "and sys_role._id=sys_role_menu._role_id "
			+ "and sys_role_menu._menu_id=#{menuId} "
			+ "and sys_role_menu._role_id=#{roleId}"
			+ "and sys_role_menu._resource_id=sys_resource._id "
			+ "and sys_resource._menu_id=sys_menu._id "
			+ "and sys_menu._del_flag=0 and sys_resource._del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "parentId", column = "_parent_id"),
			@Result(property = "name", column = "_name"),
			@Result(property = "url", column = "_url"),		
			@Result(property = "desc", column = "_desc"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "pic", column = "_pic")
	})  
	public List<net.itaem.resource.entity.Resource> findByRoleAndMenu(RoleMenu roleMenu);

} 