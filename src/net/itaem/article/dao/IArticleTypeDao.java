package net.itaem.article.dao;

import java.util.List;

import net.itaem.article.entity.ArticleType;

/**
 * ArticleType Dao
 * @author luohong 846705189@qq.com 2015-02-01
 * */
public interface IArticleTypeDao {
    public List<ArticleType> listAll();
    
    public void add(ArticleType articleType);

	public void delete(String[] ids);

	public void update(ArticleType articleType);
	
	public List<ArticleType> listByUserId(String userId);

	public ArticleType findById(String type);
}
