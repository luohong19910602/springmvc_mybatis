package net.itaem.web.entity;

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
@Resource(name = "navigationMapper")
public interface NavigationMapper {
	
	@Select(value = "select * from sys_navigation where navigation_del_flag = 0 order by navigation_sort_flag asc")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "navigation_name"),
			@Result(property = "desc", column = "navigation_desc"),
			@Result(property = "sortFlag", column = "navigation_sort_flag"),
			@Result(property = "createdTime", column = "navigation_created_time"),
			@Result(property = "articleTypeListStr", column = "navigation_article_type_list"),
			@Result(property = "creator", column = "navigation_creator"),
			@Result(property = "updatedTime", column = "navigation_updated_time"),
			@Result(property = "updator", column = "navigation_updator"),
			@Result(property = "delFlag", column = "navigation_del_flag")
	})  
	List<Navigation> listAll();  
	
	@Update("update sys_navigation set navigation_del_flag=1 where id=#{id}")
	void delete(String id);

	@Insert("insert into sys_navigation(id, navigation_article_type_list,navigation_name, navigation_desc, navigation_sort_flag, navigation_created_time, navigation_creator) "
			+ "values (#{id}, #{articleTypeListStr}, #{name}, #{desc},#{sortFlag}, #{createdTime}, #{creator})")
	void add(Navigation navigation);
	
	@Select(value = "select max(navigation_sort_flag) from sys_navigation where navigation_del_flag = 0")  
	Integer maxSortFlag();

	@Update("update sys_navigation set navigation_article_type_list=#{articleTypeListStr}, "
			+ "navigation_name=#{name}, "
			+ "navigation_desc=#{desc}, "
			+ "navigation_sort_flag=#{sortFlag}, "
			+ "navigation_updated_time=#{updatedTime}, "
			+ "navigation_updator=#{updator} "
			+ "where id=#{id}")
	void update(Navigation nav);

	@Select(value = "select * from sys_navigation where navigation_del_flag = 0 and id=#{id}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "navigation_name"),
			@Result(property = "desc", column = "navigation_desc"),
			@Result(property = "sortFlag", column = "navigation_sort_flag"),
			@Result(property = "createdTime", column = "navigation_created_time"),
			@Result(property = "articleTypeListStr", column = "navigation_article_type_list"),
			@Result(property = "creator", column = "navigation_creator"),
			@Result(property = "updatedTime", column = "navigation_updated_time"),
			@Result(property = "updator", column = "navigation_updator"),
			@Result(property = "delFlag", column = "navigation_del_flag")
	})  
	Navigation findById(String id);
}
