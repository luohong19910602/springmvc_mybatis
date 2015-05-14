package net.itaem.article.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.article.entity.Article;
import net.itaem.article.entity.ArticleType;
import net.itaem.article.service.IArticleService;
import net.itaem.article.service.IArticleTypeService;
import net.itaem.base.controller.BaseController;
import net.itaem.user.entity.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 获取全部文章controller
 * */
@Controller
public class ArticleListController extends BaseController {

	@Autowired
	IArticleService articleService;

	@Autowired
	IArticleTypeService articleTypeService;

	@RequestMapping("/article/list.do")
	public String list(){
		return "article/list";
	}

	/**
	 * android移动端列表
	 * */
	@RequestMapping("/article/listByAndroid.do")
	public String listByAndroid(){
		return "article/android/list";
	}

	/**
	 * 获取全部文章
	 * 这里面会按照文章类别来展示数据，并且同时计算出没有不属于任何文章类别的文章集合，最
	 * 后加入为之类别中，这部分数据也需要展示
	 * @throws IOException 
	 * */
	@RequestMapping("/article/listJson.do")
	public void listJson(HttpServletResponse resp) throws IOException{
		//列出全部的文章列表
		List<Article> allArticleList = articleService.listAll();
		//属于某个文章分类的文章列表
		List<Article> articleHasType = new ArrayList<Article>();

		List<ArticleType> articleTypeList = articleTypeService.listAll(); 
		JSONObject result = new JSONObject();

		if(articleTypeList != null && articleTypeList.size() > 0){
			JSONArray jsonArray = new JSONArray();
			for(ArticleType articleType: articleTypeList){
				List<Article> temp = articleService.listBy(articleType.getId());
				Article top = articleService.top(articleType.getId());

				//统计已经属于某个文章分类的全部文章
				articleHasType.addAll(temp);

				if(temp != null && temp.size() > 0){
					for(Article art: temp){
						if(top == null || !top.getId().equals(art.getId())){
							JSONObject json = new JSONObject();
							json.put("typeId", articleType.getId());
							json.put("id", art.getId());
							json.put("title", art.getTitle());
							json.put("summary", art.getSummary());
							json.put("top", 0);
							json.put("typeName", articleType.getName());
							jsonArray.add(json);
						}else{
							JSONObject json = new JSONObject();
							json.put("typeId", articleType.getId());
							json.put("id", art.getId());
							json.put("title", art.getTitle());
							json.put("summary", art.getSummary());
							json.put("top", 1);
							json.put("typeName", articleType.getName());
							jsonArray.add(json);
						}
					}
				}
			}

			allArticleList.removeAll(articleHasType);
			if(allArticleList != null && allArticleList.size() > 0){
				for(Article art: allArticleList){
					JSONObject json = new JSONObject();
					json.put("typeId", "");
					json.put("id", art.getId());
					json.put("title", art.getTitle());
					json.put("summary", art.getSummary());
					json.put("top", 0);
					json.put("typeName", "未知类别");
					jsonArray.add(json);
				}
			}
			result.put("Rows", jsonArray);
			println(resp, result.toString());	
		}
	}


	/**
	 * 移动端获取全部文章
	 * @throws IOException 
	 * */
	@RequestMapping("/article/listJsonByAndroid.do")
	public void listJsonByAndroid(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		User u = super.getLoginUser(req);
		if(u == null) return;

		List<Article> articleList = articleService.findByUserId(u.getId());
		println(resp, gridJson.articleListToGrid(articleList));
	}


	/**
	 * 列出某个文章类别下面的所有文章
	 * @throws IOException 
	 * */
	@RequestMapping("/article/listByType.do")
	public void listByTypeId(HttpServletRequest req, HttpServletResponse resp, String typeId) throws IOException{
		List<Article> articleList = articleService.listBy(typeId);
		System.out.println(gridJson.articleListToGrid(articleList));
		println(resp, gridJson.articleListToGrid(articleList));
	}
}
