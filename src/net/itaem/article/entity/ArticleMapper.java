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
			+ "where sys_article._id=sys_article_article_type._article_id "
			+ "and sys_article_article_type._article_type_id=#{articleTypeId} "
			+ "and sys_article._del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "title", column = "_title"),
			@Result(property = "content", column = "_content"),
			@Result(property = "url", column = "_url"),
			@Result(property = "viewCount", column = "_view_count"),
			@Result(property = "reference", column = "_reference"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "summary", column = "_summary"),			
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "userId", column = "_user_id")
	})  
	List<Article> listBy(String articleTypeId);  

	@Select(value = "select * from sys_article where _del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "title", column = "_title"),
			@Result(property = "content", column = "_content"),
			@Result(property = "url", column = "_url"),
			@Result(property = "viewCount", column = "_view_count"),
			@Result(property = "reference", column = "_reference"),
			@Result(property = "summary", column = "_summary"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator")
	})  
	List<Article> listAll();
	
	@Update("update sys_article set _del_flag='1' where _id=#{id}")
	void delete(String id);
	
	@Insert("insert into sys_article(_id,_summary,_user_id,_title,_content,_created_time,_creator,_updated_time,_updator)"
			+ " values(#{id},#{summary},#{userId},#{title},#{content},#{createdTime},#{creator},#{updatedTime},#{updator})")
	void add(Article article);

	@Select(value = "select * from sys_article "
			+ "where _id=#{id} "
			+ "and _del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "title", column = "_title"),
			@Result(property = "content", column = "_content"),
			@Result(property = "url", column = "_url"),
			@Result(property = "summary", column = "_summary"),
			@Result(property = "viewCount", column = "_view_count"),
			@Result(property = "reference", column = "_reference"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "userId", column = "_id")
	})  
	Article findById(String id);
	
	/**
	 * 根据用户id查找所有文章
	 * */
	@Select(value = "select * from sys_article "
			+ "where _user_id=#{userId} "
			+ "and _del_flag=0")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "title", column = "_title"),
			@Result(property = "content", column = "_content"),
			@Result(property = "url", column = "_url"),
			@Result(property = "viewCount", column = "_view_count"),
			@Result(property = "reference", column = "_reference"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "summary", column = "_summary"),
			@Result(property = "userId", column = "_user_id"),	
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "top", column = "_top")
			
	})  
	List<Article> findByUserId(String userId);

	@Update("update sys_article set "
			+ "_title=#{title},"
			+ "_summary=#{summary},"
			+ "_content=#{content}"
			+ " where _id=#{id}")
	void update(Article article);
    
	@Select(value = "select * "
			+ "from sys_article,sys_article_article_type "
			+ "where sys_article._id=sys_article_article_type._article_id "
			+ "and sys_article_article_type._article_type_id=#{articleTypeId} "
			+ "and sys_article_article_type._top=1")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "——id"),  
			@Result(property = "title", column = "_title"),
			@Result(property = "content", column = "_content"),
			@Result(property = "url", column = "_url"),
			@Result(property = "viewCount", column = "_view_count"),
			@Result(property = "reference", column = "_reference"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "summary", column = "_summary"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "userId", column = "_user_id"),
			@Result(property = "top", column = "_top")
	})  
	Article top(String articleTypeId);
    
	
	void setTop(ArticleAndType articleAndType);
} 