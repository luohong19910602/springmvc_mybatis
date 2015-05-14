package net.itaem.article.entity;

/**
 * 文章与文章类别多对多
 * */

public class ArticleAndType {
    private String id;
    private String articleId;
    private String articleTypeId;
    private int top;  //置顶标识符
    
    public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public ArticleAndType(String id, String articleId, String articleTypeId){
    	this.id = id;
    	this.articleId = articleId;
    	this.articleTypeId = articleTypeId;
    }
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getArticleTypeId() {
		return articleTypeId;
	}
	public void setArticleTypeId(String articleTypeId) {
		this.articleTypeId = articleTypeId;
	}
}
