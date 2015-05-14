package net.itaem.article.service;

import java.util.List;

import net.itaem.article.entity.Article;
import net.itaem.article.entity.ArticleAndType;

public interface IArticleService {

	/**
	 * 列出某个类别的全部article
	 * @param articleTypeId 文章类别
	 * @return
	 * */
	public List<Article> listBy(String articleTypeId);
	
	public List<Article> listAll();
	
	public void add(Article article);
	
	public void delete(String[] ids);
	
	public Article findById(String id);
	
	public void update(Article article);
	
	public List<Article> findByUserId(String userId);

	public Article top(String articleTypeId);

	/**
	 * 将文章设置为置顶文章
	 * */
	public void setTop(ArticleAndType articleAndType);

	public void cancelTop(ArticleAndType aat);
}
