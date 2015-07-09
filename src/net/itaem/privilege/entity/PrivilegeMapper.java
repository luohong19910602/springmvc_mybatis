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

	@Select(value = "select * from sys_privilege where _del_flag = 0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "url", column = "_url"),
			@Result(property = "parentId", column = "_parent_id"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag")
	})  
	List<Privilege> listAll();  

	@Insert("insert into sys_privilege (_id, _name, _url, _desc, _created_time, _creator, _parent_id) "
			+ "values(#{id}, #{name}, #{url}, #{desc}, #{createdTime}, #{creator}, #{parentId})")
	public void addChild(Privilege privilege);

	@Insert("insert into sys_privilege (_id, _name, _url, _desc, _created_time, _creator) "
			+ "values(#{id}, #{name}, #{url}, #{desc}, #{createdTime}, #{creator})")
	public void add(Privilege privilege);

	@Update("update sys_privilege set _del_flag='1' where _id=#{id}")
	void delete(String id);

	@Select(value = "select * from sys_privilege where _id=#{privilegeId} and _del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "url", column = "_url"),
			@Result(property = "parentId", column = "_parent_id"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "resource_del_flag")
	})  
	Privilege listBy(String privilegeId);

	/**
	 * 获取角色可以访问的权限，这里会获得全部的权限
	 * 但是这些权限并没有归类，所以需要在dao层对权限进行归类处理
	 * */
	@Select(value = "select sys_privilege._id,sys_privilege._parent_id,sys_privilege._name,"
			+ "sys_privilege._url,sys_privilege._desc, "
			+ "sys_privilege._created_time,sys_privilege._creator,sys_privilege._updated_time,"
			+ "sys_privilege._updator,sys_privilege._del_flag "
			+ "from "
			+ "    sys_privilege, sys_role_privilege "
			+ "where "
			+ "    sys_role_privilege._privilege_id=sys_privilege._id "
			+ "    and sys_role_privilege._role_id=#{roleId}")  
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
	List<Privilege> listByRoleId(String roleId);

	/**
	 * 查找用户权限视图
	 * 
	 * 创建视图的sql
	 * 
	 * 
	 * */
	@Select(value = "select * from sys_user_privilege_view where _user_id=#{userId}")  
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
	List<Privilege> listByUserId(String userId);

	@Update("update sys_privilege set _name=#{name},_url=#{url},_desc=#{desc} where _id=#{id}")
	void update(Privilege privilege);
} 