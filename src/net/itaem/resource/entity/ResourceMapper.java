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
	@Select(value = "select * from sys_resource where resource_menu_id =#{menuId} and resource_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "resource_name"),
			@Result(property = "desc", column = "resource_desc"),
			@Result(property = "url", column = "resource_url"),
			@Result(property = "menuId", column = "resource_menu_id"),
			@Result(property = "createdTime", column = "resource_created_time"),
			@Result(property = "creator", column = "resource_creator"),
			@Result(property = "updatedTime", column = "resource_updated_time"),
			@Result(property = "updator", column = "resource_updator"),
			@Result(property = "delFlag", column = "resource_del_flag"),
			@Result(property = "pic", column = "resource_pic")	
	})  
	List<Resource> listAll(String menuId);  
	
	@Insert("insert into sys_resource (id, resource_name, resource_url, resource_desc, resource_created_time, resource_creator, resource_menu_id) "
			+ "values(#{id}, #{name}, #{url}, #{desc}, #{createdTime}, #{creator}, #{menuId})")
	public void add(Resource resource);
	
	@Update("update sys_resource set resource_del_flag='1' where id=#{id}")
	public void delete(String id);
	
	@Select(value = "select * from sys_resource where id=#{id} and resource_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "resource_name"),
			@Result(property = "desc", column = "resource_desc"),
			@Result(property = "url", column = "resource_url"),
			@Result(property = "menuId", column = "resource_menu_id"),
			@Result(property = "createdTime", column = "resource_created_time"),
			@Result(property = "creator", column = "resource_creator"),
			@Result(property = "updatedTime", column = "resource_updated_time"),
			@Result(property = "updator", column = "resource_updator"),
			@Result(property = "delFlag", column = "resource_del_flag"),
			@Result(property = "pic", column = "resource_pic")	
	})  
	net.itaem.resource.entity.Resource findBy(String id);
} 