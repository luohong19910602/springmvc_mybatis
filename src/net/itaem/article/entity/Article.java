package net.itaem.article.entity;

import net.itaem.base.entity.BaseEntity;

import org.apache.commons.lang.builder.ToStringBuilder;

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
    private ArticleType type;  //文章所属类别
    private String typeId;  //文章类别
    private String userId;  //文章所属用户
    private String summary; //文章简介
    
    
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
	public ArticleType getType() {
		return type;
	}
	public void setType(ArticleType type) {
		this.type = type;
	}
	public String getTypeId() {
		return typeId;
	}
	public void setTypeId(String typeId) {
		this.typeId = typeId;
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
				+ reference + ", type=" + type + ", typeId=" + typeId
				+ ", userId=" + userId + ", summary=" + summary + "]";
	}
}
