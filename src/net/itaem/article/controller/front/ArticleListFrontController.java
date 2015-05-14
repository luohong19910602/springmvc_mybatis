package net.itaem.article.controller.front;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.article.entity.Article;
import net.itaem.article.entity.ArticleType;
import net.itaem.article.service.IArticleService;
import net.itaem.article.service.IArticleTypeService;
import net.itaem.base.controller.BaseController;
import net.itaem.slide.entity.Slide;
import net.itaem.slide.service.ISlideService;
import net.itaem.web.entity.Navigation;
import net.itaem.web.service.INavigationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 前台文章首页
 * 这里会列出所有的文章类别以及文章详细信息
 * 
 * @author luohong 846705189@qq.com 15013336884
 * @Date 2015-05-12
 * */
@Controller
public class ArticleListFrontController extends BaseController {

	@Autowired
	IArticleTypeService artilceTypeService;

	@Autowired
	IArticleService artilceService;

	@Autowired
	private INavigationService navService;
	
	@Autowired
	private ISlideService slideService;


	/**
	 * 输出文章列表数据
	 * @index 选中的文章类别
	 * @navIndex 选中的导航
	 * 
	 * @throws IOException 
	 * @throws ServletException 
	 * */
	@RequestMapping("/article/front/index.do")
	public void index(Integer index, Integer navIndex, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Navigation> navList = setNavigation(navIndex, req);
        setSlide(req);
		if(index == null) index = 0;
		if(navIndex == null) navIndex = 0;
		String typeListStr = navList.get(navIndex).getArticleTypeListStr();
		setArticleType(index, navIndex, typeListStr, req);
		
		req.getRequestDispatcher("/front/article/index.jsp").forward(req, resp);   
	}

	/**
	 * 浏览文章
	 * @param id 文章id
	 * @param index 文章类别下标
	 * @param navIndex 导航下标
	 * @throws IOException 
	 * @throws ServletException 
	 * */
	@RequestMapping("/article/front/detail.do")
	public void detail(String id, Integer index, Integer navIndex, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		//设置导航
		List<Navigation> navList = setNavigation(navIndex, req);
		setSlide(req);
		//设置文章类别
		if(index == null) index = 0;
		if(navIndex == null) navIndex = 0;
		String typeListStr = navList.get(navIndex).getArticleTypeListStr();
		if(typeListStr != null && !"".equals(typeListStr)){
			String[] types = typeListStr.split(Navigation.ARTICLE_TYPE_SEPORATOR);  //分割文章类别
			if(types != null && types.length > 0){
				StringBuilder sb = new StringBuilder();

				List<ArticleType> typeList = new ArrayList<ArticleType>();
				for(String type: types){
					ArticleType articleType = artilceTypeService.findById(type);
					if(articleType != null)
						typeList.add(articleType);
				}

				if(typeList != null && typeList.size() > 0){
					for(int i=0; i<typeList.size(); i++){
						if(index == i)
							sb.append("<li class='active'><a href='" + super.getBaseURL(req) + "/article/front/index.do?navIndex=" + navIndex + "&index=" +i + "'>" + typeList.get(i).getName() + "</a></li>");
						else
							sb.append("<li><a href='" + super.getBaseURL(req) + "/article/front/index.do?navIndex=" +navIndex + "&index=" + i + "'>" + typeList.get(i).getName() + "</a></li>");
					}
					req.setAttribute("type", sb.toString());
				}
			}
		}
		
		//设置文章详细信息
		Article article = artilceService.findById(id);
		StringBuilder articleBuilder = new StringBuilder();
		if(article != null){
			articleBuilder.append("<div class='row-fluid'>");
			articleBuilder.append(article.getContent());
			articleBuilder.append("</div>");
		}
		req.setAttribute("article", articleBuilder.toString());
		
		req.getRequestDispatcher("/front/article/detail.jsp").forward(req, resp);
	}

	@RequestMapping("/navigation.do")
	public void navigation(Integer navIndex, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		List<Navigation> navList = setNavigation(navIndex, req);
		setSlide(req);
		if(navIndex == null)
			navIndex = 0;
		String typeListStr = navList.get(navIndex).getArticleTypeListStr();
		setArticleType(0, navIndex, typeListStr, req);
		req.getRequestDispatcher("/front/article/index.jsp").forward(req, resp);
	}

	/**
	 * 设置navigation
	 * @param navIndex 选中第几个导航
	 * */
	private List<Navigation> setNavigation(Integer navIndex, HttpServletRequest req) {
		//导航数据
		List<Navigation> navList = navService.listAll();
		if(navList != null && navList.size() > 0){
			StringBuilder navBuilder = new StringBuilder();
			for(int i=0;i<navList.size(); i++){
				if(navIndex == null){
					navIndex = 0;
				}

				if(navIndex == i){
					navBuilder.append("<li class='active'><a href='" + super.getBaseURL(req) + "/navigation.do?navIndex=" + i + "'>" + navList.get(i).getName() + "</a></li>");
				}else{
					navBuilder.append("<li><a href='" + super.getBaseURL(req) + "/navigation.do?navIndex=" + i + "'>" + navList.get(i).getName() + "</a></li>");
				}
			}
			req.setAttribute("nav", navBuilder.toString());
		}

		return navList;
	}

	/**
	 * 设置选中的文章类别
	 * @param index 选中的文章类别
	 * @paran navIndex 选中的导航
	 * */
	private void setArticleType(Integer index, Integer navIndex, String typeListStr, HttpServletRequest req){
		if(typeListStr != null && !"".equals(typeListStr)){
			String[] types = typeListStr.split(Navigation.ARTICLE_TYPE_SEPORATOR);  //分割文章类别
			if(types != null && types.length > 0){
				StringBuilder sb = new StringBuilder();

				List<ArticleType> typeList = new ArrayList<ArticleType>();
				for(String type: types){
					ArticleType articleType = artilceTypeService.findById(type);
					if(articleType != null)
						typeList.add(articleType);
				}

				if(typeList != null && typeList.size() > 0){
					Collections.sort(typeList);
					for(int i=0; i<typeList.size(); i++){
						if(index == i)
							sb.append("<li class='active'><a href='" + super.getBaseURL(req) + "/article/front/index.do?navIndex=" + navIndex + "&index=" +i + "'>" + typeList.get(i).getName() + "</a></li>");
						else
							sb.append("<li><a href='" + super.getBaseURL(req) + "/article/front/index.do?navIndex=" +navIndex + "&index=" + i + "'>" + typeList.get(i).getName() + "</a></li>");
					}
					req.setAttribute("type", sb.toString());

					setArtcile(index, navIndex, typeList.get(index).getId(), req);
				}
			}
		}
	}

	/**
	 * 
	 * tip:如果只有一个文章，那么默认会把这个文章当做置顶文章
	 * 
	 * @param top置顶的文章
	 * @param articleList 该类别下面的文章
	 * 
	 * */
	private void setArtcile(Integer articleTypeIndex, Integer navIndex, String articleTypeId, HttpServletRequest req){
		List<Article> articleList = artilceService.listBy(articleTypeId);
		if(articleList != null && articleList.size() > 0){
			
			//只有一个文章，默认为置顶文章
			if(articleList.size() == 1){
				StringBuilder topBuilder = new StringBuilder();
				topBuilder.append("<div class='row-fluid'>");
				topBuilder.append(articleList.get(0).getContent());
				topBuilder.append("</div>");
				req.setAttribute("article", topBuilder.toString());
				return;
			}
			
			StringBuilder articleBuilder = new StringBuilder();
			articleBuilder.append("<div class='row-fluid'>");
			int flag = 0;
			//找到top置顶文章
			Article top = artilceService.top(articleTypeId);
			for(Article article: articleList){
				if(top == null || !article.getId().equals(top.getId())){
					articleBuilder.append("<div class='span4 bs-docs-example'>");
					articleBuilder.append("<h2>" + article.getTitle() + "</h2>");
					String summary = article.getSummary();
					articleBuilder.append("<p>" + summary + "</p>");
					articleBuilder.append("<p><a class='btn' href='" + 
					    super.getBaseURL(req) + "/article/front/detail.do?navIndex=" +navIndex + ""
					    		+ "&index=" + articleTypeIndex + "&id=" + article.getId() +  "'>查看详情</a></p>");
					articleBuilder.append("</div>");
					flag++;
					if(flag % 3 == 0 && flag - 1 != articleList.size()){	
						articleBuilder.append("</div>");
						articleBuilder.append("<div class='row-fluid'>");
					}
				}
			}
			
			articleBuilder.append("</div>");
			
			if(top != null){
				StringBuilder topBuilder = new StringBuilder();
				topBuilder.append("<div class='row-fluid'>");
				topBuilder.append(top.getContent());
				topBuilder.append("</div>");
				articleBuilder.insert(0, topBuilder.toString());
			}
			
			
			req.setAttribute("article", articleBuilder.toString());
		}
	}
	
	/**
	 * 设置slide
	 * */
	private void setSlide(HttpServletRequest req){
	    List<Slide> slideList = slideService.listAll();
	    if(slideList != null && slideList.size() > 0){
	    	StringBuilder slideBuilder = new StringBuilder();
	    	slideBuilder.append("<ol class='carousel-indicators'>");
	    	
	    	for(int i=0; i<slideList.size(); i++){
	    		if(i == 0)
	    		    slideBuilder.append("<li class='active' data-slide-to='0' data-target='#carousel-193625'></li>");
	    		else{
	    			slideBuilder.append("<li data-slide-to='" + i + "' data-target='#carousel-193625'></li>");
	    		}
	    	}
	    	slideBuilder.append("</ol>");
	    	
	    	
	    	slideBuilder.append("<div class='carousel-inner'>");
	    	
	    	for(int i=0; i<slideList.size(); i++){
	    		if(i == 0){
	    			slideBuilder.append("<div class='item active'>");
	    			slideBuilder.append("<img src='"+slideList.get(0).getImgUrl()+"' />");
	    			slideBuilder.append("<div class='carousel-caption'>");
	    			slideBuilder.append("<h4>" + slideList.get(0).getTitle() + "</h4>");
	    			slideBuilder.append("<p>"+slideList.get(0).getDesc()+"</p>");
	    			slideBuilder.append("</div>");
	    			slideBuilder.append("</div>");
	    		}else{
	    			slideBuilder.append("<div class='item'>");
	    			slideBuilder.append("<img src='"+slideList.get(i).getImgUrl()+"' />");
	    			slideBuilder.append("<div class='carousel-caption'>");
	    			slideBuilder.append("<h4>" + slideList.get(i).getTitle() + "</h4>");
	    			slideBuilder.append("<p>"+slideList.get(i).getDesc()+"</p>");
	    			slideBuilder.append("</div>");
	    			slideBuilder.append("</div>");
	    		}
	    	}
	    	slideBuilder.append("</div>");
	    	System.out.println(slideBuilder.toString());
	    	req.setAttribute("slide", slideBuilder.toString());
	    }
	}

}
