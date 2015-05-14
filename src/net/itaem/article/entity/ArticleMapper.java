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
	@Select(value = "select * from sys_article,sys_article_article_type "
			+ "where sys_article.id=sys_article_article_type.article_id "
			+ "and sys_article_article_type.article_type_id=#{articleTypeId} "
			+ "and sys_article.article_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "title", column = "article_title"),
			@Result(property = "content", column = "article_content"),
			@Result(property = "url", column = "article_url"),
			@Result(property = "viewCount", column = "article_view_count"),
			@Result(property = "reference", column = "article_reference"),
			@Result(property = "createdTime", column = "article_created_time"),
			@Result(property = "creator", column = "article_creator"),
			@Result(property = "summary", column = "article_summary"),			
			@Result(property = "updatedTime", column = "article_updated_time"),
			@Result(property = "updator", column = "article_updator"),
			@Result(property = "userId", column = "user_id")
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
			@Result(property = "summary", column = "article_summary"),
			@Result(property = "createdTime", column = "article_created_time"),
			@Result(property = "creator", column = "article_creator"),
			@Result(property = "updatedTime", column = "article_updated_time"),
			@Result(property = "updator", column = "article_updator")
	})  
	List<Article> listAll();
	
	@Update("update sys_article set article_del_flag='1' where id=#{id}")
	void delete(String id);
	
	@Update("update sys_article set article_del_flag='1' where article_type_id=#{typeId}")
	void deleteByTypeId(String typeId);
	
	@Insert("insert into sys_article(id,article_summary,user_id,article_title,article_content,article_created_time,article_creator,article_updated_time,article_updator)"
			+ " values(#{id},#{summary},#{userId},#{title},#{content},#{createdTime},#{creator},#{updatedTime},#{updator})")
	void add(Article article);

	@Select(value = "select * from sys_article "
			+ "where id=#{id} "
			+ "and article_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "title", column = "article_title"),
			@Result(property = "content", column = "article_content"),
			@Result(property = "url", column = "article_url"),
			@Result(property = "summary", column = "article_summary"),
			@Result(property = "viewCount", column = "article_view_count"),
			@Result(property = "reference", column = "article_reference"),
			@Result(property = "createdTime", column = "article_created_time"),
			@Result(property = "creator", column = "article_creator"),
			@Result(property = "updatedTime", column = "article_updated_time"),
			@Result(property = "updator", column = "article_updator"),
			@Result(property = "userId", column = "user_id")
	})  
	Article findById(String id);
	
	/**
	 * 根据用户id查找所有文章
	 * */
	@Select(value = "select * from sys_article "
			+ "where user_id=#{userId} "
			+ "and article_del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "title", column = "article_title"),
			@Result(property = "content", column = "article_content"),
			@Result(property = "url", column = "article_url"),
			@Result(property = "viewCount", column = "article_view_count"),
			@Result(property = "reference", column = "article_reference"),
			@Result(property = "createdTime", column = "article_created_time"),
			@Result(property = "creator", column = "article_creator"),
			@Result(property = "summary", column = "article_summary"),
			@Result(property = "updatedTime", column = "article_updated_time"),
			@Result(property = "updator", column = "article_updator"),
			@Result(property = "userId", column = "user_id")
	})  
	List<Article> findByUserId(String userId);

	@Update("update sys_article set "
			+ "article_title=#{title},"
			+ "article_summary=#{summary},"
			+ "article_content=#{content}"
			+ " where id=#{id}")
	void update(Article article);
    
	@Select(value = "select * "
			+ "from sys_article,sys_article_article_type "
			+ "where sys_article.id=sys_article_article_type.article_id "
			+ "and sys_article_article_type.article_type_id=#{articleTypeId} "
			+ "and sys_article_article_type.article_top=1")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "title", column = "article_title"),
			@Result(property = "content", column = "article_content"),
			@Result(property = "url", column = "article_url"),
			@Result(property = "viewCount", column = "article_view_count"),
			@Result(property = "reference", column = "article_reference"),
			@Result(property = "createdTime", column = "article_created_time"),
			@Result(property = "creator", column = "article_creator"),
			@Result(property = "summary", column = "article_summary"),
			@Result(property = "updatedTime", column = "article_updated_time"),
			@Result(property = "updator", column = "article_updator"),
			@Result(property = "userId", column = "user_id")
	})  
	Article top(String articleTypeId);
    
	
	void setTop(ArticleAndType articleAndType);
} 