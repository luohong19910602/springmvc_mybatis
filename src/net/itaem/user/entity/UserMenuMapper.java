package net.itaem.user.entity;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

/**
 * user-Menu中间表的Mapper
 * 这里同时记录了用户id，资源id，菜单id，通过这三个id，共同确定一条resource
 * 
 * @author luohong
 * @date 2014-12-25
 * @email 846705189@qq.com
 * */
@Resource(name = "userMenuMapper")
public interface UserMenuMapper {
	/**
	 * 插入一条记录
	 * */
	@Insert("insert into sys_user_menu (_id, _user_id, _menu_id, _resource_id) "
			+ "values(#{id}, #{userId}, #{menuId},#{resourceId})")
	public void add(UserMenu userMenu);
	
	/**
	 * 删除usermenu
	 * 
	 * */
	@Delete("delete from sys_user_menu where _user_id=#{userId} and _resource_id=#{resourceId} and _menu_id=#{menuId}")
	public void delete(UserMenu userMenu);
  
}
