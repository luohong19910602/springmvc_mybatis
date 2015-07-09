package net.itaem.user.entity;
import java.util.List;

import net.itaem.base.entity.Page;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

	@Select(value = "select * from sys_user where _login_name=#{loginName} and _password=#{password}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "email", column = "_email"),
			@Result(property = "tel", column = "_tel"),
			@Result(property = "loginName", column = "_login_name"),
			@Result(property = "blog", column = "_blog"),
			@Result(property = "address", column = "_address"),
			@Result(property = "currentAddress", column = "_current_address"),
			@Result(property = "password", column = "_password"),
			@Result(property = "birthday", column = "_birthday"),
			@Result(property = "qq", column = "_qq"),
			@Result(property = "lastedLoginTime", column = "_lasted_login_time"),
			@Result(property = "loginCount", column = "_login_count"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "superUserFlag", column = "_super_user_flag")
	})  
    User exists(User user);

	/**
	 * 获取角色的所属用户列表
	 * 
	 * */
	@Select(value = "select distinct sys_user._id,_name,_email,_tel,"
			+ "_login_name,_password,_blog,_address,"
			+ "_current_address,_birthday,_qq,_login_count,"
			+ "_created_time,_creator,_updated_time,_updator,"
			+ "_del_flag "
			+ "from sys_user,sys_role_user "
			+ "where sys_user._id=sys_role_user._user_id and _role_id=#{roleId}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "email", column = "_email"),
			@Result(property = "tel", column = "_tel"),
			@Result(property = "loginName", column = "_login_name"),
			@Result(property = "password", column = "_password"),
			@Result(property = "blog", column = "_blog"),
			@Result(property = "address", column = "_address"),
			@Result(property = "currentAddress", column = "_current_address"),
			@Result(property = "birthday", column = "_birthday"),
			@Result(property = "qq", column = "_qq"),
			@Result(property = "lastedLoginTime", column = "_lasted_login_time"),
			@Result(property = "loginCount", column = "_login_count"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "superUserFlag", column = "_super__flag")
	})  
	List<User> listByRoleId(String roleId);
    
	/**
	 * 计算总用户数量
	 * @return 总用户数量
	 * */
	@Select(value = "select count(_id) from sys_user where _del_flag=0") 
	public int countAll();
	
	/**
	 * 分页查询用户
	 * */
	@Select(value = "select * from sys_user where _del_flag=0 limit #{offset}, #{size}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "email", column = "_email"),
			@Result(property = "tel", column = "_tel"),
			@Result(property = "loginName", column = "_login_name"),
			@Result(property = "blog", column = "_blog"),
			@Result(property = "address", column = "_address"),
			@Result(property = "currentAddress", column = "_current_address"),
			@Result(property = "password", column = "_password"),
			@Result(property = "birthday", column = "_birthday"),
			@Result(property = "qq", column = "_qq"),
			@Result(property = "lastedLoginTime", column = "_lasted_login_time"),
			@Result(property = "loginCount", column = "_login_count"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "superUserFlag", column = "_super__flag")
	}) 
	List<User> listAll(Page page);

	@Insert(value = "insert into sys_user (_id,_name,_email,_tel,"
			+ "_login_name,_password,"
			+ "_blog,_address,_current_address,_birthday,"
			+ "_qq,_login_count,_created_time,_creator) "
			+ "values(#{id}, #{name}, #{email}, #{tel}, #{loginName}, #{password}, #{blog}, #{address}, "
			+ "#{currentAddress}, #{birthday}, #{qq}, #{loginCount}, #{createdTime}, #{creator})")
	void add(User user);

	@Select(value = "select * from sys_user where _id=#{userId} and _del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "email", column = "_email"),
			@Result(property = "tel", column = "_tel"),
			@Result(property = "loginName", column = "_login_name"),
			@Result(property = "blog", column = "_blog"),
			@Result(property = "address", column = "_address"),
			@Result(property = "currentAddress", column = "_current_address"),
			@Result(property = "password", column = "_password"),
			@Result(property = "birthday", column = "_birthday"),
			@Result(property = "qq", column = "_qq"),
			@Result(property = "lastedLoginTime", column = "_lasted_login_time"),
			@Result(property = "loginCount", column = "_login_count"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "superUserFlag", column = "_super__flag")
	}) 
	User listBy(String userId);
    
	/**
	 * @param loginName 登录名
	 * @return 如果loginName已经注册了，那么返回1
	 * */
	@Select(value = "select count(sys_user._login_name) from sys_user where sys_user._login_name=#{loginName} and _del_flag=0")  
	int countLoginName(String loginName);

	@Delete(value = "delete from sys_user where _id=#{id}")
	void delete(String id);
	
	@Update(value = "update sys_user set _name=#{name},_email=#{email},_tel=#{tel},"
			+ "_login_name=#{loginName},_password=#{password},"
			+ "_blog=#{blog},_address=#{address},_current_address=#{currentAddress},_birthday=#{birthday},"
			+ "_qq=#{qq},_login_count=#{loginCount},_updated_time=#{updatedTime},_updator=#{updator} "
			+ "where _id=#{id}")
	void update(User user);
} 