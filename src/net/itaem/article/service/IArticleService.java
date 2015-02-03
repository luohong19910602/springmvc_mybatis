package net.itaem.article.service;

import java.util.List;

import net.itaem.article.entity.Article;

public interface IArticleService {

	/**
	 * 列出某个类别的全部article
	 * @param articleTypeId 文章类别
	 * @return
	 * */
	public List<Article> listAll(String articleTypeId);
}
