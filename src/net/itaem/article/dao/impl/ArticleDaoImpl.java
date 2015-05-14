package net.itaem.article.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import net.itaem.article.dao.IArticleDao;
import net.itaem.article.entity.Article;
import net.itaem.article.entity.ArticleAndType;
import net.itaem.article.entity.ArticleAndTypeMapper;
import net.itaem.article.entity.ArticleMapper;
import net.itaem.article.entity.ArticleTypeMapper;

import org.springframework.stereotype.Repository;

@Repository
public class ArticleDaoImpl implements IArticleDao {
    
	@Resource(name = "articleMapper")
	private ArticleMapper articleMapper;
	
	@Resource(name = "articleTypeMapper")
	private ArticleTypeMapper articleTypeMapper;
	
	@Resource(name = "articleAndTypeMapper")
	private ArticleAndTypeMapper articleAndTypeMapper;
	
	@Override
	public List<Article> listBy(String articleTypeId) {
		return articleMapper.listBy(articleTypeId);
	}

	@Override
	public List<Article> listAll() {
		List<Article> articleList = articleMapper.listAll();
		
		for(Article article: articleList){
			article.setArticleTypeList(articleTypeMapper.listByArticleId(article.getId()));
		}
		return articleList;
	}

	@Override
	public void add(Article article) {
		articleMapper.add(article);
		if(article.getArticleAndTypeList() != null && article.getArticleAndTypeList().size() > 0){
			for(ArticleAndType aat: article.getArticleAndTypeList()){
		    	articleAndTypeMapper.add(aat);
		    }
		}
	}

	@Override
	public void delete(String[] ids) {
		for(String id: ids){
			articleMapper.delete(id);
			articleAndTypeMapper.deleteByArticleId(id);
		}
	}

	@Override
	public Article findById(String id) {
		return articleMapper.findById(id);
	}

	@Override
	public List<Article> findByUserId(String userId) {
		return articleMapper.findByUserId(userId);
	}

	@Override
	public void update(Article article) {
		articleMapper.update(article);
		if(article.getArticleAndTypeList() != null && article.getArticleAndTypeList().size() > 0){
			articleAndTypeMapper.deleteByArticleId(article.getId());
			//删除原来的关联关系
			for(ArticleAndType aat: article.getArticleAndTypeList()){
		    	articleAndTypeMapper.add(aat);
		    }
		}
	}

	@Override
	public Article top(String articleTypeId) {
		return articleMapper.top(articleTypeId);
	}

	/**
	 * 第一步移除原来的top文章
	 * 第二部设置当前的article为top文章
	 * */
	@Override
	public void setTop(ArticleAndType articleAndType) {
		articleAndTypeMapper.seUnTop(articleAndType);
		articleAndTypeMapper.setTop(articleAndType);
	}
	
	/**
	 * 取消某个文章类别的置顶
	 * */
	@Override
	public void cancelTop(ArticleAndType articleAndType){
		articleAndTypeMapper.seUnTop(articleAndType);
	}
}
