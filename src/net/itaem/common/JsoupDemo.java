package net.itaem.common;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 抓取所有我个人csdn博文
 * 
 * */
public class JsoupDemo {

	public static class Article{
		private String title;  //标题
		private String desc;  //简介
		private String content;  //内容
		private String viewCount;  //浏览次数
		private String url;  //原文链接
		private String commentCount;  //评论次数

		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getCommentCount() {
			return commentCount;
		}
		public void setCommentCount(String commentCount) {
			this.commentCount = commentCount;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getViewCount() {
			return viewCount;
		}
		public void setViewCount(String viewCount) {
			this.viewCount = viewCount;
		}
		@Override
		public String toString() {
			return "Article [title=" + title + ", desc=" + desc + ", content="
					+ content + ", viewCount=" + viewCount + ", url=" + url
					+ ", commentCount=" + commentCount + "]";
		}
	}

	public static final String CSDN_CONTEXT = "http://blog.csdn.net";

	public static void main(String[] args) throws IOException {
		List<String> pageList = parseAllArticlePageList("http://blog.csdn.net/u010469003");
		List<Article> articleList = new ArrayList<JsoupDemo.Article>();
		for(String page: pageList){
			articleList.addAll(parseArticleList(page));
		}

	}

	/**
	 * 拿到一个csdn用户的所有文章翻页内容，这里面只是拿到url 
	 * @throws IOException 
	 * */
	public static List<String> parseAllArticlePageList(String url) throws IOException{
		if(url == null || "".equals(url)){
			return new ArrayList<String>();
		}

		List<String> urls = new ArrayList<String>();
		Document doc = doc(url);

		Elements arcticlePageList = doc.select("#papelist").select("a");
		urls.add(url);
		for(Element page: arcticlePageList){

			urls.add(CSDN_CONTEXT + page.attr("href"));
		}
		return urls;
	}

	/**
	 * 解析url，拿到Document
	 * @param url
	 * @return Document对象
	 * @throws IOException 
	 * */
	public static Document doc(String url) throws IOException{
		Document doc = Jsoup.connect(url).header("User-Agent", 
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.130 Safari/537.36")
				.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
				.header("Accept-Encoding", "gzip, deflate, sdch")
				.header("Cache-Control", "max-age=0")  
				.header("Connection", "keep-alive").get();  
		return doc;
	}

	/**
	 * 文章列表
	 * @param url 文章页码url
	 * @return url 文章页码对应的文章
	 * */
	public static List<Article> parseArticleList(String url){
		try {  
			Elements arcticleListDiv = doc(url).select("#article_list");
			List<Article> articleList = new ArrayList<Article>();
			for (Element e : arcticleListDiv) {  
				Elements articleListDiv = e.select(".article_item");

				for(Element article: articleListDiv){
					Article art = new Article();

					art.setTitle(article.select(".article_title").select("h1").text().trim());
					art.setDesc(article.select(".article_description").text().trim());

					String urlStr = CSDN_CONTEXT + article.select(".article_manage").get(0).select(".link_view").select("a").attr("href").trim();
					art.setUrl(urlStr);

					String linkViews = article.select(".article_manage").get(0).select(".link_view").text().trim();
					linkViews = linkViews.substring(linkViews.indexOf("(")+1, linkViews.lastIndexOf(")"));
					art.setViewCount(linkViews);

					String linkComments = article.select(".article_manage").get(0).select(".link_comments").text().trim();
					linkComments = linkComments.substring(linkComments.indexOf("(")+1, linkComments.lastIndexOf(")"));
					art.setCommentCount(linkComments);

					art.setContent(parseArticleContent(urlStr));
					articleList.add(art);
					
					System.out.println(art);
				}
			}  
			return articleList;
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
		return new ArrayList<JsoupDemo.Article>();
	}

	/**
	 * 文章内容
	 * @throws IOException 
	 * 
	 * */
	public static String parseArticleContent(String url) throws IOException{
		return doc(url).select("#article_content").text().toString().trim();
	}
}