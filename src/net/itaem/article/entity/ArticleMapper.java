package net.itaem.article.entity;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


/** 
 *  
 * @author luohong
 * @date 2015-02-02
 * @email 846705189@qq.com 
 */  
@Repository(value = "articleMapper")  
public interface ArticleMapper {  

	/**
	 * 列出某个类别的全部article
	 * @param articleTypeId 文章类别
	 * @return
	 * */
	@Select(value = "select * from sys_article "
			+ "where article_type_id=#{articleTypeId} "
			+ "and article_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "title", column = "article_title"),
			@Result(property = "content", column = "article_content"),
			@Result(property = "url", column = "article_url"),
			@Result(property = "viewCount", column = "article_view_count"),
			@Result(property = "reference", column = "article_reference"),
			@Result(property = "typeId", column = "article_type_id"),
			@Result(property = "createdTime", column = "article_created_time"),
			@Result(property = "creator", column = "article_creator"),
			@Result(property = "updatedTime", column = "article_updated_time"),
			@Result(property = "updator", column = "article_updator")
	})  
	List<Article> listBy(String articleTypeId);  

	@Select(value = "select * from sys_article where article_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "title", column = "article_title"),
			@Result(property = "content", column = "article_content"),
			@Result(property = "url", column = "article_url"),
			@Result(property = "viewCount", column = "article_view_count"),
			@Result(property = "reference", column = "article_reference"),
			@Result(property = "typeId", column = "article_type_id"),
			@Result(property = "createdTime", column = "article_created_time"),
			@Result(property = "creator", column = "article_creator"),
			@Result(property = "updatedTime", column = "article_updated_time"),
			@Result(property = "updator", column = "article_updator")
	})  
	List<Article> listAll();
	
	@Update("update sys_article set article_del_flag='1' where id=#{id}")
	void delete(String id);
	
	@Insert("insert into sys_article(id,article_title,article_content,article_type_id,article_created_time,article_creator,article_updated_time,article_updator)"
			+ " values(#{id},#{title},#{content},#{typeId},#{createdTime},#{creator},#{updatedTime},#{updator})")
	void add(Article article);
} 