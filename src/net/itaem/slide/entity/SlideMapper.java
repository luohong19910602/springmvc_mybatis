package net.itaem.slide.entity;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


/** 
 *  SlideMapper类
 *  
 * @author luohong
 * @date 2015-05-14
 * @email 846705189@qq.com
 */  
@Repository(value = "slideMapper")  
public interface SlideMapper {  
	@Select(value = "select * from sys_slide where _del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "title", column = "_title"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "imgUrl", column = "_image_url"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
	})  
	List<Slide> listAll();  
	
	@Insert("insert into sys_slide (_id, _title, _image_url, "
			+ "_desc, _created_time, _creator) "
			+ "values(#{id}, #{title}, #{imgUrl}, #{desc}, #{createdTime}, #{creator})")
	public void add(Slide slide);
	
	@Update("update sys_slide set _del_flag='1' where _id=#{id}")
	public void delete(String id);
} 