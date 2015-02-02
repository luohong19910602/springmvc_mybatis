package net.itaem.privilege.entity;
import java.util.List;

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
 * @author luohong
 * @date 2014-12-17
 * @email 846705189@qq.com 
 */  
@Repository(value = "privilegeMapper")  
public interface PrivilegeMapper {  

	@Select(value = "${sql}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "privilege_name"),
			@Result(property = "desc", column = "privilege_desc"),
			@Result(property = "url", column = "privilege_url"),
			@Result(property = "parentId", column = "privilege_parent_id"),
			@Result(property = "createdTime", column = "privilege_created_time"),
			@Result(property = "creator", column = "privilege_creator"),
			@Result(property = "updatedTime", column = "privilege_updated_time"),
			@Result(property = "updator", column = "privilege_updator"),
			@Result(property = "delFlag", column = "resource_del_flag")
	})  
	List<Privilege> listAll(@Param(value = "sql") String sql);  
	
	@Insert("insert into sys_privilege (id, privilege_name, privilege_url, privilege_desc, privilege_created_time, privilege_creator, privilege_parent_id) "
			+ "values(#{id}, #{name}, #{url}, #{desc}, #{createdTime}, #{creator}, #{parentId})")
	public void addChild(Privilege privilege);
	
	@Insert("insert into sys_privilege (id, privilege_name, privilege_url, privilege_desc, privilege_created_time, privilege_creator) "
			+ "values(#{id}, #{name}, #{url}, #{desc}, #{createdTime}, #{creator})")
	public void add(Privilege privilege);
	
	@Update("update sys_privilege set privilege_del_flag='1' where id=#{id}")
	void delete(String id);

	@Select(value = "select * from sys_privilege where id=#{privilegeId} and privilege_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "privilege_name"),
			@Result(property = "desc", column = "privilege_desc"),
			@Result(property = "url", column = "privilege_url"),
			@Result(property = "parentId", column = "privilege_parent_id"),
			@Result(property = "createdTime", column = "privilege_created_time"),
			@Result(property = "creator", column = "privilege_creator"),
			@Result(property = "updatedTime", column = "privilege_updated_time"),
			@Result(property = "updator", column = "privilege_updator"),
			@Result(property = "delFlag", column = "resource_del_flag")
	})  
	Privilege listBy(String privilegeId);
	
	/**
	 * 获取角色可以访问的权限，这里会获得全部的权限
	 * 但是这些权限并没有归类，所以需要在dao层对权限进行归类处理
	 * */
	@Select(value = "select sys_privilege.id,sys_privilege.privilege_parent_id,sys_privilege.privilege_name,sys_privilege.privilege_url,sys_privilege.privilege_desc, sys_privilege.privilege_created_time,sys_privilege.privilege_creator,sys_privilege.privilege_updated_time,sys_privilege.privilege_updator,sys_privilege.privilege_del_flag "
			+ "from "
			+ "    sys_privilege, sys_role_privilege "
			+ "where "
			+ "    sys_role_privilege.privilege_id=sys_privilege.id "
			+ "    and sys_role_privilege.role_id=#{roleId}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "parentId", column = "privilege_parent_id"),
			@Result(property = "name", column = "privilege_name"),
			@Result(property = "url", column = "privilege_url"),
			@Result(property = "desc", column = "privilege_desc"),
			@Result(property = "createdTime", column = "privilege_created_time"),
			@Result(property = "creator", column = "privilege_creator"),
			@Result(property = "updatedTime", column = "privilege_updated_time"),
			@Result(property = "updator", column = "privilege_updator"),
			@Result(property = "delFlag", column = "privilege_del_flag")
	})  
	List<Privilege> listByRoleId(String roleId);
	
	@Select(value = "select sys_privilege.id,sys_privilege.privilege_parent_id,sys_privilege.privilege_name,sys_privilege.privilege_url,sys_privilege.privilege_desc, sys_privilege.privilege_created_time,sys_privilege.privilege_creator,sys_privilege.privilege_updated_time,sys_privilege.privilege_updator,sys_privilege.privilege_del_flag "
			+ "from sys_user,sys_privilege,sys_user_privilege "
			+ "where sys_user.id=sys_user_privilege.user_id and sys_privilege.id=sys_user_privilege.privilege_id and sys_user.id=#{userId} and sys_user.user_del_flag=0 and sys_privilege.privilege_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "parentId", column = "privilege_parent_id"),
			@Result(property = "name", column = "privilege_name"),
			@Result(property = "url", column = "privilege_url"),
			@Result(property = "desc", column = "privilege_desc"),
			@Result(property = "createdTime", column = "privilege_created_time"),
			@Result(property = "creator", column = "privilege_creator"),
			@Result(property = "updatedTime", column = "privilege_updated_time"),
			@Result(property = "updator", column = "privilege_updator"),
			@Result(property = "delFlag", column = "privilege_del_flag")
	})  
	List<Privilege> listByUserId(String userId);
    
	@Update("update sys_privilege set privilege_name=#{name},privilege_url=#{url},privilege_desc=#{desc} where id=#{id}")
	void update(Privilege privilege);
} 