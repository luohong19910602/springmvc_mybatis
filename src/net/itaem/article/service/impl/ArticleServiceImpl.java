package net.itaem.article.service.impl;

import java.util.List;

import net.itaem.article.dao.IArticleDao;
import net.itaem.article.entity.Article;
import net.itaem.article.entity.ArticleAndType;
import net.itaem.article.service.IArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public Article findById(String id) {
		// TODO Auto-generated method stub
		return articleDao.findById(id);
	}

	@Override
	public List<Article> findByUserId(String userId) {
		// TODO Auto-generated method stub
		return articleDao.findByUserId(userId);
	}

	@Override
	public void update(Article article) {
		articleDao.update(article);
	}

	@Override
	public Article top(String articleTypeId) {
	    return articleDao.top(articleTypeId);	
	}

	@Override
	public void setTop(ArticleAndType articleAndType) {
		articleDao.setTop(articleAndType);
	}

	@Override
	public void cancelTop(ArticleAndType aat) {
		articleDao.cancelTop(aat);
	}
}
