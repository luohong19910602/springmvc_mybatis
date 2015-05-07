package net.itaem.article.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.itaem.article.dao.IArticleDao;
import net.itaem.article.entity.Article;
import net.itaem.article.entity.ArticleMapper;
import net.itaem.article.entity.ArticleTypeMapper;

import org.springframework.stereotype.Repository;

@Repository
public class ArticleDaoImpl implements IArticleDao {
    
	@Resource(name = "articleMapper")
	private ArticleMapper articleMapper;
	@Resource(name = "articleTypeMapper")
	private ArticleTypeMapper articleTypeMapper;
	
	@Override
	public List<Article> listBy(String articleTypeId) {
		return articleMapper.listBy(articleTypeId);
	}

	@Override
	public List<Article> listAll() {
		List<Article> articleList = articleMapper.listAll();
		
		for(Article article: articleList){
			article.setType(articleTypeMapper.findBy(article.getTypeId()));
		}
		return articleList;
	}

	@Override
	public void add(Article article) {
		articleMapper.add(article);
	}

	@Override
	public void delete(String[] ids) {
		for(String id: ids){
			articleMapper.delete(id);
		}
	}
}
