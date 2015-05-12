package net.itaem.user.entity;
import java.util.List;

import net.itaem.base.entity.Page;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


/** 
 *  UserMapper类
 *  
 * @author luohong
 * @date 2014-12-24
 * @email 846705189@qq.com 
 */  
@Repository(value = "userMapper")  
public interface UserMapper {  

	@Select(value = "${sql}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "user_name"),
			@Result(property = "email", column = "user_email"),
			@Result(property = "tel", column = "user_tel"),
			@Result(property = "loginName", column = "user_login_name"),
			@Result(property = "blog", column = "user_blog"),
			@Result(property = "address", column = "user_address"),
			@Result(property = "currentAddress", column = "user_current_address"),
			@Result(property = "password", column = "user_password"),
			@Result(property = "birthday", column = "user_birthday"),
			@Result(property = "qq", column = "user_qq"),
			@Result(property = "lastedLoginTime", column = "user_lasted_login_time"),
			@Result(property = "loginCount", column = "user_login_count"),
			@Result(property = "createdTime", column = "user_created_time"),
			@Result(property = "creator", column = "user_creator"),
			@Result(property = "updatedTime", column = "user_updated_time"),
			@Result(property = "updator", column = "user_updator"),
			@Result(property = "delFlag", column = "user_del_flag"),
			@Result(property = "superUserFlag", column = "user_super_user_flag")
	})  
    User exists(@Param(value = "sql") String sql);

	/**
	 * 获取角色的所属用户列表
	 * 
	 * */
	@Select(value = "select distinct sys_user.id,user_name,user_email,user_tel,"
			+ "user_login_name,user_password,user_blog,user_address,"
			+ "user_current_address,user_birthday,user_qq,user_login_count,"
			+ "user_created_time,user_creator,user_updated_time,user_updator,"
			+ "user_del_flag "
			+ "from sys_user,sys_role_user "
			+ "where sys_user.id=sys_role_user.user_id and role_id=#{roleId}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "user_name"),
			@Result(property = "email", column = "user_email"),
			@Result(property = "tel", column = "user_tel"),
			@Result(property = "loginName", column = "user_login_name"),
			@Result(property = "password", column = "user_password"),
			@Result(property = "blog", column = "user_blog"),
			@Result(property = "address", column = "user_address"),
			@Result(property = "currentAddress", column = "user_current_address"),
			@Result(property = "birthday", column = "user_birthday"),
			@Result(property = "qq", column = "user_qq"),
			@Result(property = "lastedLoginTime", column = "user_lasted_login_time"),
			@Result(property = "loginCount", column = "user_login_count"),
			@Result(property = "createdTime", column = "user_created_time"),
			@Result(property = "creator", column = "user_creator"),
			@Result(property = "updatedTime", column = "user_updated_time"),
			@Result(property = "updator", column = "user_updator"),
			@Result(property = "delFlag", column = "user_del_flag"),
			@Result(property = "superUserFlag", column = "user_super_user_flag")
	})  
	List<User> listByRoleId(String roleId);
    
	/**
	 * 计算总用户数量
	 * @return 总用户数量
	 * */
	@Select(value = "select count(id) from sys_user where user_del_flag=0") 
	public int countAll();
	
	/**
	 * 分页查询用户
	 * */
	@Select(value = "select * from sys_user where user_del_flag=0 limit #{offset}, #{size}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "user_name"),
			@Result(property = "email", column = "user_email"),
			@Result(property = "tel", column = "user_tel"),
			@Result(property = "loginName", column = "user_login_name"),
			@Result(property = "blog", column = "user_blog"),
			@Result(property = "address", column = "user_address"),
			@Result(property = "currentAddress", column = "user_current_address"),
			@Result(property = "password", column = "user_password"),
			@Result(property = "birthday", column = "user_birthday"),
			@Result(property = "qq", column = "user_qq"),
			@Result(property = "lastedLoginTime", column = "user_lasted_login_time"),
			@Result(property = "loginCount", column = "user_login_count"),
			@Result(property = "createdTime", column = "user_created_time"),
			@Result(property = "creator", column = "user_creator"),
			@Result(property = "updatedTime", column = "user_updated_time"),
			@Result(property = "updator", column = "user_updator"),
			@Result(property = "delFlag", column = "user_del_flag"),
			@Result(property = "superUserFlag", column = "user_super_user_flag")
	}) 
	List<User> listAll(Page page);

	@Insert(value = "insert into sys_user (id,user_name,user_email,user_tel,"
			+ "user_login_name,user_password,"
			+ "user_blog,user_address,user_current_address,user_birthday,"
			+ "user_qq,user_login_count,user_created_time,user_creator) "
			+ "values(#{id}, #{name}, #{email}, #{tel}, #{loginName}, #{password}, #{blog}, #{address}, "
			+ "#{currentAddress}, #{birthday}, #{qq}, #{loginCount}, #{createdTime}, #{creator})")
	void add(User user);

	@Select(value = "select * from sys_user where id=#{userId} and user_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "user_name"),
			@Result(property = "email", column = "user_email"),
			@Result(property = "tel", column = "user_tel"),
			@Result(property = "loginName", column = "user_login_name"),
			@Result(property = "blog", column = "user_blog"),
			@Result(property = "address", column = "user_address"),
			@Result(property = "currentAddress", column = "user_current_address"),
			@Result(property = "password", column = "user_password"),
			@Result(property = "birthday", column = "user_birthday"),
			@Result(property = "qq", column = "user_qq"),
			@Result(property = "lastedLoginTime", column = "user_lasted_login_time"),
			@Result(property = "loginCount", column = "user_login_count"),
			@Result(property = "createdTime", column = "user_created_time"),
			@Result(property = "creator", column = "user_creator"),
			@Result(property = "updatedTime", column = "user_updated_time"),
			@Result(property = "updator", column = "user_updator"),
			@Result(property = "delFlag", column = "user_del_flag"),
			@Result(property = "superUserFlag", column = "user_super_user_flag")
	}) 
	User listBy(String userId);
    
	/**
	 * @param loginName 登录名
	 * @return 如果loginName已经注册了，那么返回1
	 * */
	@Select(value = "select count(sys_user.user_login_name) from sys_user where sys_user.user_login_name=#{loginName} and user_del_flag=0")  
	int countLoginName(String loginName);

	@Delete(value = "delete from sys_user where id=#{id}")
	void delete(String id);
	
	@Update(value = "update sys_user set user_name=#{name},"
			+ "user_email=#{email},"
			+ "user_tel=#{tel},"
			+ "user_login_name=#{loginName},"
			+ "user_password=#{password},"
			+ "user_blog=#{blog},"
			+ "user_address=#{address},"
			+ "user_current_address=#{currentAddress},"
			+ "user_birthday=#{birthday},"
			+ "user_qq=#{qq},"
			+ "user_login_count=#{loginCount},"
			+ "user_updated_time=#{updatedTime},"
			+ "user_updator=#{updator} "
			+ "where id=#{id}")
	void update(User user);
} 