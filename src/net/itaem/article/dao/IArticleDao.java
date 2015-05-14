package net.itaem.article.dao;

import java.util.List;

import net.itaem.article.entity.Article;
import net.itaem.article.entity.ArticleAndType;

/**
 * 文章dao
 * 
 * */
public interface IArticleDao {
	/**
	 * 列出某个类别的全部article
	 * @param articleTypeId 文章类别
	 * @return
	 * */
	public List<Article> listBy(String articleTypeId);
	/**
	 * 获取全部文章
	 * */
	public List<Article> listAll();

	public void add(Article article);

	public void delete(String[] ids);

	public Article findById(String id);
	
	public List<Article> findByUserId(String userId);

	public void update(Article article);
	
	/**
	 * 找到置顶的文章
	 * @param articleTypeId 文章类别id
	 * @return 返回置顶文章
	 * */
	public Article top(String articleTypeId);
	
	public void setTop(ArticleAndType articleAndType);
	
	public void cancelTop(ArticleAndType articleAndType);
}
