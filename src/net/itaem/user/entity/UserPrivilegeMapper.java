package net.itaem.user.entity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;


/** 
 *  UserPrivilegeMapper类
 *  
 * @author luohong
 * @date 2014-12-24
 * @email 846705189@qq.com 
 */  
@Repository(value = "userPrivilegeMapper")  
public interface UserPrivilegeMapper {  

	@Insert(value = "insert into sys_user_privilege (_id,_user_id,_privilege_id) "
			+ "values(#{id}, #{userId}, #{privilegeId})")
	void add(UserPrivilege userPrivilege);
	
	
	@Delete(value = "delete from sys_user_privilege where _user_id=#{userId} and _privilege_id=#{privilegeId}")
	void delete(UserPrivilege userPrivilege);
	
	
} 