package net.itaem.role.entity;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Insert;
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
	
	@Select(value = "select * from sys_role where _del_flag = 0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "parentId", column = "_parent_id"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag")
	})  
	List<Role> listAll();  
	
	@Update("update sys_role set _del_flag=1 where id=#{id}")
	void delete(String id);

	@Insert("insert into sys_role(_id, _name, _parent_id, _created_time, _creator) "
			+ "values (#{id}, #{name}, #{parentId}, #{createdTime}, #{creator})")
	void add(Role role);

	@Select(value = "select * from sys_role where _id=#{roleId} and _del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "parentId", column = "_parent_id"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag")
	})  
	public Role byId(String roleId);
    
	/**
	  *使用group_concat()来一次性查询出用户的角色列表id
	  *select sys_user.id,sys_user.user_name,GROUP_CONCAT(sys_role.id SEPARATOR ',') 
      *from sys_user, sys_role_user,sys_role 
      *where sys_user.id=sys_role_user.user_id and sys_role_user._id=sys_role.id
      *group by sys_user.id
	  * */
	@Select(value = "select distinct sys_role._id, _name, _parent_id, _created_time, _creator "
			+ "from sys_role,sys_role_user "
			+ "where sys_role._id=sys_role_user._role_id "
			+ "and sys_role_user._user_id=#{userId} and sys_role._del_flag=0")
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "parentId", column = "_parent_id"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag")
	})  
	List<Role> listByUserId(String userId);
}
