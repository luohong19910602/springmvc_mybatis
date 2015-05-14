package net.itaem.article.service;

import java.util.List;

import net.itaem.article.entity.ArticleType;

public interface IArticleTypeService {
	
	public List<ArticleType> listAll();
	
	public void add(ArticleType articleType);
	
	public void delete(String[] ids);

	public void update(ArticleType articleType);
	
	public List<ArticleType> listByUserId(String userId);

	public ArticleType findById(String type);
}
