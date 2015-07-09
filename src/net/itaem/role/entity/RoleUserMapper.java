package net.itaem.role.entity;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

/**
 * Role-User中间表的Mapper
 * 
 * @author luohong
 * @date 2014-12-25
 * @email 846705189@qq.com
 * */
@Resource(name = "roleUserMapper")
public interface RoleUserMapper {
	
	/**
	 * 插入一条记录
	 * */
	@Insert("insert into sys_role_user(_id, _role_id, _user_id) "
			+ "values(#{id}, #{roleId}, #{userId})")
	public void add(RoleUser roleUser);
	
	/**
	 * 删除一个RoleUser
	 * 
	 * */
	@Delete("delete from sys_role_user where _role_id=#{roleId} and _user_id=#{userId}")
	public void delete(RoleUser roleUser);
	
	@Delete("delete from sys_role_user where _user_id=#{userId}")
	public void deleteByUserId(String userId);
  
}
