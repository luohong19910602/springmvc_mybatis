package net.itaem.role.entity;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

/**
 * Role-Privilege中间表的Mapper
 * @author luohong
 * @date 2014-12-25
 * @email 846705189@qq.com
 * */
@Resource(name = "rolePrivilegeMapper")
public interface RolePrivilegeMapper {
	/**
	 * 插入一条记录
	 * */
	@Insert("insert into sys_role_privilege(_id, _role_id, _privilege_id) "
			+ "values(#{id}, #{roleId}, #{privilegeId})")
	public void add(RolePrivilege rolePrivilege);
	
	/**
	 * 删除RolePrivilege
	 * 
	 * */
	@Delete("delete from sys_role_privilege where _role_id=#{roleId} and _privilege_id=#{privilegeId}")
	public void delete(RolePrivilege rolePrivilege);
  
}
