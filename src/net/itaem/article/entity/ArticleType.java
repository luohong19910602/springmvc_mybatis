package net.itaem.article.entity;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import net.itaem.base.entity.BaseEntity;

/**
 * 文章类别entity
 * @author luohong 846705189@qq.com 2015-02-01
 * 
 * */
public class ArticleType extends BaseEntity {

	private String name;
	private String desc;
	private List<Article> articleList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public List<Article> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}