package net.itaem.article.entity;

import java.util.List;

import net.itaem.base.entity.BaseEntity;

/**
 * 文章entity
 * @author luohong 846705189@qq.com 2015-02-01
 * 
 * */
public class Article extends BaseEntity {
	private String title;  //文章标题
    private String url;  //文章访问url
    private String content;  //文章内容
    private int viewCount;    //访问次数
    private int reference;  //转载次数
    private String userId;  //文章所属用户
    private String summary; //文章简介
    
    private boolean isTop;
    
    public boolean isTop() {
		return isTop;
	}
	public void setTop(boolean isTop) {
		this.isTop = isTop;
	}
	private List<ArticleType> articleTypeList;  //文章类别集合
    private List<ArticleAndType> articleAndTypeList;  //中间表
    
	public List<ArticleAndType> getArticleAndTypeList() {
		return articleAndTypeList;
	}
	public void setArticleAndTypeList(List<ArticleAndType> articleAndTypeList) {
		this.articleAndTypeList = articleAndTypeList;
	}
	public List<ArticleType> getArticleTypeList() {
		return articleTypeList;
	}
	public void setArticleTypeList(List<ArticleType> articleTypeList) {
		this.articleTypeList = articleTypeList;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	public int getReference() {
		return reference;
	}
	public void setReference(int reference) {
		this.reference = reference;
	}
	@Override
	public String toString() {
		return "Article [title=" + title + ", url=" + url + ", content="
				+ content + ", viewCount=" + viewCount + ", reference="
				+ reference + ", userId=" + userId + ", summary=" + summary
				+ ", isTop=" + isTop + ", articleTypeList=" + articleTypeList
				+ ", articleAndTypeList=" + articleAndTypeList + "]";
	}
	
	
}
