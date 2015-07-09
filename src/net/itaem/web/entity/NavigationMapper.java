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
	
	@Select(value = "select * from sys_navigation where _del_flag = 0 order by _sort_flag asc")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "sortFlag", column = "_sort_flag"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "articleTypeListStr", column = "_article_type_list"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag")
	})  
	List<Navigation> listAll();  
	
	@Update("update sys_navigation set _del_flag=1 where _id=#{id}")
	void delete(String id);

	@Insert("insert into sys_navigation(_id, _article_type_list,_name, _desc, _sort_flag, _created_time, _creator) "
			+ "values (#{id}, #{articleTypeListStr}, #{name}, #{desc},#{sortFlag}, #{createdTime}, #{creator})")
	void add(Navigation navigation);
	
	@Select(value = "select max(_sort_flag) from sys_navigation where _del_flag = 0")  
	Integer maxSortFlag();

	@Update("update sys_navigation set _article_type_list=#{articleTypeListStr}, "
			+ "_name=#{name}, "
			+ "_desc=#{desc}, "
			+ "_sort_flag=#{sortFlag}, "
			+ "_updated_time=#{updatedTime}, "
			+ "_updator=#{updator} "
			+ "where _id=#{id}")
	void update(Navigation nav);

	@Select(value = "select * from sys_navigation where _del_flag = 0 and _id=#{id}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "sortFlag", column = "_sort_flag"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "articleTypeListStr", column = "_article_type_list"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag")
	})  
	Navigation findById(String id);
}
