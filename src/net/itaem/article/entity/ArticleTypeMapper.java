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

	@Select(value = "select * from sys_article_type where _del_flag=0 order by _sort_flag asc")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "sortFlag", column = "_sort_flag"),		
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "userId", column = "_user_id")
	})  
	List<ArticleType> listAll(); 
	
	@Select(value = "select * from sys_article_type where _del_flag=0 and _id=#{id}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "sortFlag", column = "_sort_flag"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "userId", column = "_user_id")
	})
	ArticleType findBy(String id);
	
	@Insert("insert into sys_article_type (_id,_sort_flag, _user_id, _name, "
			+ "_desc, _created_time, _creator, _updated_time, _updator) "
			+ "values(#{id}, #{sortFlag}, #{userId},#{name}, #{desc}, #{createdTime}, #{creator}, "
			+ "#{updatedTime}, #{updator})")
	public void add(ArticleType articleType);
	
	@Update("update sys_article_type set _del_flag='1' where _id=#{id}")
	void delete(String id);

	@Update("update sys_article_type set _sort_flag=#{sortFlag},_name=#{name},_desc=#{desc},_updated_time=#{updatedTime},"
			+ "_updator=#{updator} where _id=#{id}")
	void update(ArticleType articleType);

	@Select(value = "select * from sys_article_type where _del_flag=0 and _user_id=#{userId} order by _sort_flag asc")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "sortFlag", column = "_sort_flag"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "userId", column = "_user_id")
	})
	List<ArticleType> listByUserId(String userId);
	
	@Select(value = "select * from sys_article_type,sys_article_article_type "
			+ "where sys_article_type._id=sys_article_article_type._id"
			+ " and sys_article_article_type._article_id=#{articleTypeId} order by _sort_flag asc")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "_id"),  
			@Result(property = "name", column = "_name"),
			@Result(property = "desc", column = "_desc"),
			@Result(property = "sortFlag", column = "_sort_flag"),
			@Result(property = "createdTime", column = "_created_time"),
			@Result(property = "creator", column = "_creator"),
			@Result(property = "updatedTime", column = "_updated_time"),
			@Result(property = "updator", column = "_updator"),
			@Result(property = "delFlag", column = "_del_flag"),
			@Result(property = "userId", column = "_user_id")
	})
	List<ArticleType> listByArticleId(String articleId);
    
	@Select("select max(_sort_flag) from sys_article_type")
	int maxSortFlag();
} 