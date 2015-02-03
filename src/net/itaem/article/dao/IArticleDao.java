package net.itaem.article.dao;

import java.util.List;

import net.itaem.article.entity.Article;

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
	public List<Article> listAll(String articleTypeId);
}
