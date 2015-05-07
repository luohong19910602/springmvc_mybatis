package net.itaem.article.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.itaem.article.dao.IArticleDao;
import net.itaem.article.entity.Article;
import net.itaem.article.service.IArticleService;

@Service
public class ArticleServiceImpl implements IArticleService {
    
	@Autowired
	private IArticleDao articleDao;
	
	@Override
	public List<Article> listBy(String articleTypeId) {
		return articleDao.listBy(articleTypeId);
	}

	@Override
	public List<Article> listAll() {
		return articleDao.listAll();
	}

	@Override
	public void add(Article article) {
		articleDao.add(article);
	}

	@Override
	public void delete(String[] ids) {
		articleDao.delete(ids);
	}
}
