package net.itaem.article.entity;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import net.itaem.base.entity.BaseEntity;

/**
 * 文章类别entity
 * @author luohong 846705189@qq.com 2015-02-01
 * 
 * */
public class ArticleType extends BaseEntity implements Comparable<ArticleType>{
    
	private String userId;
	private String name;
	private String desc;
	private int sortFlag;
	
	public int getSortFlag() {
		return sortFlag;
	}
	public void setSortFlag(int sortFlag) {
		this.sortFlag = sortFlag;
	}

	private List<Article> articleList;
	private List<ArticleAndType> articleAndTypeList;
	
	public List<ArticleAndType> getArticleAndTypeList() {
		return articleAndTypeList;
	}
	public void setArticleAndTypeList(List<ArticleAndType> articleAndTypeList) {
		this.articleAndTypeList = articleAndTypeList;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
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
	@Override
	public int compareTo(ArticleType o) {
		return this.getSortFlag() - o.getSortFlag();
	}
}
