package net.itaem.article.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import net.itaem.article.dao.IArticleDao;
import net.itaem.article.entity.Article;
import net.itaem.article.entity.ArticleMapper;

@Repository
public class ArticleDaoImpl implements IArticleDao {
    
	@Resource(name = "articleMapper")
	private ArticleMapper articleMapper;
	
	@Override
	public List<Article> listAll(String articleTypeId) {
		return articleMapper.listAll(articleTypeId);
	}

}
