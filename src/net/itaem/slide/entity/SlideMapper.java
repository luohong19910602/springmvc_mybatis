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
	@Select(value = "select * from sys_slide where slide_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "title", column = "slide_title"),
			@Result(property = "desc", column = "slide_desc"),
			@Result(property = "imgUrl", column = "slide_image_url"),
			@Result(property = "createdTime", column = "slide_created_time"),
			@Result(property = "creator", column = "slide_creator"),
			@Result(property = "updatedTime", column = "slide_updated_time"),
			@Result(property = "updator", column = "slide_updator"),
			@Result(property = "delFlag", column = "slide_del_flag"),
	})  
	List<Slide> listAll();  
	
	@Insert("insert into sys_slide (id, slide_title, slide_image_url, "
			+ "slide_desc, slide_created_time, slide_creator) "
			+ "values(#{id}, #{title}, #{imgUrl}, #{desc}, #{createdTime}, #{creator})")
	public void add(Slide slide);
	
	@Update("update sys_slide set slide_del_flag='1' where id=#{id}")
	public void delete(String id);
} 