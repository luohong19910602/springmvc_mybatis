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
@Repository(value = "articleAndTypeMapper")  
public interface ArticleAndTypeMapper {  

	@Select(value = "select * from sys_article_article_type "
			+ "where article_type_id=#{articleTypeId}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(id = true, property = "articleId", column = "article_id"),  
			@Result(id = true, property = "articleTypeId", column = "article_type_id")
	})  
	List<ArticleAndType> listByArticleTypeId(String articleTypeId);  
    
	@Select(value = "select * from sys_article_article_type "
			+ "where article_id=#{articleId}")  
	@Results(value = { 
			@Result(id = true, property = "id", column = "id"),  
			@Result(id = true, property = "articleId", column = "article_id"),  
			@Result(id = true, property = "articleTypeId", column = "article_type_id")
	})  
	List<ArticleAndType> listByArticleId(String articleId);  
    
	@Insert("insert into sys_article_article_type(id,article_id,article_type_id)"
			+ " values(#{id},#{articleId}, #{articleTypeId})")
	void add(ArticleAndType articleAndType);

	@Update("update sys_article_article_type set article_top=1 where article_id=#{articleId} and article_type_id=#{articleTypeId}")
	void setTop(ArticleAndType articleAndType);
	
	@Update("update sys_article_article_type set article_top=0 where article_type_id=#{articleTypeId}")
	void seUnTop(ArticleAndType articleAndType);
	
} 