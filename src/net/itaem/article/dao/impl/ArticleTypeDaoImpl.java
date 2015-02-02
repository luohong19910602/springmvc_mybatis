package net.itaem.article.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import net.itaem.article.dao.IArticleTypeDao;
import net.itaem.article.entity.ArticleType;
import net.itaem.article.entity.ArticleTypeMapper;

/**
 * @author luohong 846705189@qq.com 2015-02-01
 * */
@Repository
public class ArticleTypeDaoImpl implements IArticleTypeDao {
    
	@Resource(name = "articleTypeMapper")
	private ArticleTypeMapper articleTypeMapper;
    
	@Override
	public List<ArticleType> listAll() {
		return articleTypeMapper.listAll();
	}
    
}
