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
@Repository(value = "articleTypeMapper")  
public interface ArticleTypeMapper {  

	@Select(value = "select * from sys_article_type where article_type_del_flag=0 order by article_type_sort_flag asc")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "article_type_name"),
			@Result(property = "desc", column = "article_type_desc"),
			@Result(property = "sortFlag", column = "article_type_sort_flag"),		
			@Result(property = "createdTime", column = "article_type_created_time"),
			@Result(property = "creator", column = "article_type_creator"),
			@Result(property = "updatedTime", column = "article_type_updated_time"),
			@Result(property = "updator", column = "article_type_updator"),
			@Result(property = "delFlag", column = "article_type_del_flag"),
			@Result(property = "userId", column = "user_id")
	})  
	List<ArticleType> listAll(); 
	
	@Select(value = "select * from sys_article_type where article_type_del_flag=0 and id=#{id}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "article_type_name"),
			@Result(property = "desc", column = "article_type_desc"),
			@Result(property = "sortFlag", column = "article_type_sort_flag"),
			@Result(property = "createdTime", column = "article_type_created_time"),
			@Result(property = "creator", column = "article_type_creator"),
			@Result(property = "updatedTime", column = "article_type_updated_time"),
			@Result(property = "updator", column = "article_type_updator"),
			@Result(property = "delFlag", column = "article_type_del_flag"),
			@Result(property = "userId", column = "user_id")
	})
	ArticleType findBy(String id);
	
	@Insert("insert into sys_article_type (id,article_type_sort_flag, user_id, article_type_name, "
			+ "article_type_desc, article_type_created_time, article_type_creator, article_type_updated_time, article_type_updator) "
			+ "values(#{id}, #{sortFlag}, #{userId},#{name}, #{desc}, #{createdTime}, #{creator}, "
			+ "#{updatedTime}, #{updator})")
	public void add(ArticleType articleType);
	
	@Update("update sys_article_type set article_type_del_flag='1' where id=#{id}")
	void delete(String id);

	@Update("update sys_article_type set article_type_sort_flag=#{sortFlag},article_type_name=#{name},article_type_desc=#{desc},article_type_updated_time=#{updatedTime},"
			+ "article_type_updator=#{updator} where id=#{id}")
	void update(ArticleType articleType);

	@Select(value = "select * from sys_article_type where article_type_del_flag=0 and user_id=#{userId} order by article_type_sort_flag asc")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "article_type_name"),
			@Result(property = "desc", column = "article_type_desc"),
			@Result(property = "sortFlag", column = "article_type_sort_flag"),
			@Result(property = "createdTime", column = "article_type_created_time"),
			@Result(property = "creator", column = "article_type_creator"),
			@Result(property = "updatedTime", column = "article_type_updated_time"),
			@Result(property = "updator", column = "article_type_updator"),
			@Result(property = "delFlag", column = "article_type_del_flag"),
			@Result(property = "userId", column = "user_id")
	})
	List<ArticleType> listByUserId(String userId);
	
	@Select(value = "select * from sys_article_type,sys_article_article_type "
			+ "where sys_article_type.id=sys_article_article_type.article_type_id"
			+ " and sys_article_article_type.article_id=#{articleTypeId} order by article_type_sort_flag asc")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(property = "name", column = "article_type_name"),
			@Result(property = "desc", column = "article_type_desc"),
			@Result(property = "sortFlag", column = "article_type_sort_flag"),
			@Result(property = "createdTime", column = "article_type_created_time"),
			@Result(property = "creator", column = "article_type_creator"),
			@Result(property = "updatedTime", column = "article_type_updated_time"),
			@Result(property = "updator", column = "article_type_updator"),
			@Result(property = "delFlag", column = "article_type_del_flag"),
			@Result(property = "userId", column = "user_id")
	})
	List<ArticleType> listByArticleId(String articleId);
    
	@Select("select max(article_type_sort_flag) from sys_article_type")
	int maxSortFlag();
} 