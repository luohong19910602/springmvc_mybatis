package net.itaem.role.entity;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 角色Mapper
 * @author luohong
 * @date 2014-12-25
 * @email 846705189@qq.com
 * */
@Resource(name = "roleMapper")
public interface RoleMapper {
	@Select(value = "${sql}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "role_name"),
			@Result(property = "parentId", column = "role_parent_id"),
			@Result(property = "createdTime", column = "role_created_time"),
			@Result(property = "creator", column = "role_creator"),
			@Result(property = "updatedTime", column = "role_updated_time"),
			@Result(property = "updator", column = "role_updator"),
			@Result(property = "delFlag", column = "role_del_flag")
	})  
	List<Role> listAll(@Param(value = "sql") String sql);  
	
	@Update("update sys_role set role_del_flag=1 where id=#{id}")
	void delete(String id);

	@Insert("insert into sys_role(id, role_name, role_parent_id, role_created_time, role_creator) "
			+ "values (#{id}, #{name}, #{parentId}, #{createdTime}, #{creator})")
	void add(Role role);

	@Select(value = "select * from sys_role where id=#{roleId} and role_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "role_name"),
			@Result(property = "parentId", column = "role_parent_id"),
			@Result(property = "createdTime", column = "role_created_time"),
			@Result(property = "creator", column = "role_creator"),
			@Result(property = "updatedTime", column = "role_updated_time"),
			@Result(property = "updator", column = "role_updator"),
			@Result(property = "delFlag", column = "role_del_flag")
	})  
	public Role byId(String roleId);
    
	/**
	  *使用group_concat()来一次性查询出用户的角色列表id
	  *select sys_user.id,sys_user.user_name,GROUP_CONCAT(sys_role.id SEPARATOR ',') 
      *from sys_user, sys_role_user,sys_role 
      *where sys_user.id=sys_role_user.user_id and sys_role_user.role_id=sys_role.id
      *group by sys_user.id
	  * */
	@Select(value = "select distinct sys_role.id, role_name, role_parent_id, role_created_time, role_creator from sys_role,sys_role_user "
			+ "where sys_role.id=sys_role_user.role_id and sys_role_user.user_id=#{userId}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "role_name"),
			@Result(property = "parentId", column = "role_parent_id"),
			@Result(property = "createdTime", column = "role_created_time"),
			@Result(property = "creator", column = "role_creator"),
			@Result(property = "updatedTime", column = "role_updated_time"),
			@Result(property = "updator", column = "role_updator"),
			@Result(property = "delFlag", column = "role_del_flag")
	})  
	List<Role> listByUserId(String userId);
    
//	@Select(value = "select sys_role.id, role_name, role_parent_id, role_created_time, role_creator from sys_role,sys_role_user "
//			+ "where sys_role.id=sys_role_user.role_id and sys_role_user.user_id=#{id}")  
//	@Results(value = { 
//			@Result(id = true, property = "id", column = "id"),  
//			@Result(property = "name", column = "role_name"),
//			@Result(property = "parentId", column = "role_parent_id"),
//			@Result(property = "createdTime", column = "role_created_time"),
//			@Result(property = "creator", column = "role_creator"),
//			@Result(property = "updatedTime", column = "role_updated_time"),
//			@Result(property = "updator", column = "role_updator"),
//			@Result(property = "delFlag", column = "role_del_flag")
//	})  
//	List<Role> listByUserId(String userId);
}
