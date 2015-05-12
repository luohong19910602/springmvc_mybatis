package net.itaem.article.controller.type;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.article.entity.ArticleType;
import net.itaem.article.service.IArticleTypeService;
import net.itaem.base.controller.BaseController;
import net.itaem.user.entity.User;
import net.itaem.util.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文章类别管理Controller
 * */
@Controller
public class ArticleTypeListController extends BaseController {

	@Autowired
	private IArticleTypeService articleTypeService;
	
	/**
	 * 获取全部的文章类别列表
	 * */
	@RequestMapping("/articleType/list.do")
	public String list(){
		return "article/type/articleTypeList";
	}
	
	/**
	 * 跳转到文章列表界面
	 * */
	@RequestMapping("/articleType/listByAndroid.do")
	public String listByAndroid(){
		System.out.println("by android");
		return "article/android/articleTypeList";
	}

	@RequestMapping("/articleType/listJson.do")
	public void listJson(HttpServletResponse resp) throws IOException{
		List<ArticleType> articleTypeList = articleTypeService.listAll();
		println(resp, gridJson.articleTypeListToGrid(articleTypeList));
	}
	
	/**
	 * 列出移动端用户的全部文章列表
	 * */
	@RequestMapping("/articleType/listJsonByAndroid.do")
	public void listJsonByAndroid(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		User u = super.getLoginUser(req);
		if(u == null){
			println(resp, JsonUtil.createJson("error", "请登录"));
			return;
		}
		List<ArticleType> articleTypeList = articleTypeService.listByUserId(u.getId());
		println(resp, gridJson.articleTypeListToGrid(articleTypeList));
	}
	
	/**
	 * 列出某个用户的文章类别
	 * @throws IOException 
	 * */
	@RequestMapping("/articleType/listJsonByUserId.do")
	public void listJsonByUserId(String userId, HttpServletResponse resp) throws IOException{
		System.out.println("the user id is " + userId);
		
		List<ArticleType> articleTypeList = articleTypeService.listByUserId(userId);
		System.out.println("the article type list is " + articleTypeList);
		if(articleTypeList == null || articleTypeList.size() == 0){
			println(resp, "");
			return;
		}
		
		StringBuilder sb = new StringBuilder();
		for(ArticleType articleType: articleTypeList){
			sb.append(articleType.getId() + ":");
			sb.append(articleType.getName() + ",");
		}
		
		System.out.println(sb.toString());
		println(resp, sb.subSequence(0, sb.length() - 1).toString());
	}

	/**
	 * 获取文章类型列表
	 * 
	 * */
	@RequestMapping("/articleType/listNameJson.do")
	public void listTypeNameJson(HttpServletResponse resp) throws IOException{
		List<ArticleType> articleTypeList = articleTypeService.listAll();

		StringBuilder sb = new StringBuilder();
		for(ArticleType articleType: articleTypeList){
			sb.append(articleType.getId() + ":");
			sb.append(articleType.getName() + ",");
		}

		println(resp, sb.subSequence(0, sb.length() - 1).toString());
	}
}
