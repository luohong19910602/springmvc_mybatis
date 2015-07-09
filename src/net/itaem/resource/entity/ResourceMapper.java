package net.itaem.resource.entity;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
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
@Repository(value = "resourceMapper")  
public interface ResourceMapper {  

	/**
	 * 获取指定菜单的资源列表
	 * @param menuId 菜单id
	 * @return the menu owner resource list
	 * */
	@Select(value = "select * from sys_resource where _menu_id =#{menuId} and _del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "url", column = "_url"),
			@Result(property = "menuId", column = "_menu_id"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "pic", column = "_pic")	
	})  
	List<Resource> listAll(String menuId);  
	
	@Insert("insert into sys_resource (_id, _name, _url, _desc, _created_time, _creator, _menu_id) "
			+ "values(#{id}, #{name}, #{url}, #{desc}, #{createdTime}, #{creator}, #{menuId})")
	public void add(Resource resource);
	
	@Update("update sys_resource set _del_flag='1' where _id=#{id}")
	public void delete(String id);
	
	@Select(value = "select * from sys_resource where _id=#{id} and _del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "url", column = "_url"),
			@Result(property = "menuId", column = "_menu_id"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "pic", column = "_pic")	
	})  
	net.itaem.resource.entity.Resource findBy(String id);
} 