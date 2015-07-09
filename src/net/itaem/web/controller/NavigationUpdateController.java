package net.itaem.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.article.entity.ArticleType;
import net.itaem.article.service.IArticleTypeService;
import net.itaem.base.controller.BaseController;
import net.itaem.user.entity.User;
import net.itaem.util.DateUtil;
import net.itaem.util.JsonUtil;
import net.itaem.web.entity.Navigation;
import net.itaem.web.service.INavigationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 更新navigation Controller
 * @author luohong 15013336884 846705189@qq.com
 * */
@Controller
public class NavigationUpdateController extends BaseController {

	@Autowired
	private INavigationService navService;
	@Autowired
	private IArticleTypeService typeService;

	/**
	 * 跳转到更新navigation的界面
	 * @param id
	 * */
	@RequestMapping("/navigation/update.do")
	public String update(String id, HttpServletRequest req){
		Navigation nav = navService.findById(id);
		
		String articleTypeListStr = null;
		
		if(nav != null)
			articleTypeListStr = navService.findById(id).getArticleTypeListStr();
		String[] articleTypeList = null;
		if(articleTypeListStr != null)
			articleTypeList = articleTypeListStr.split(Navigation.ARTICLE_TYPE_SEPORATOR);		

		//文章类别
		List<ArticleType> typeList = typeService.listAll();
		StringBuilder typeBuilder = new StringBuilder();
		typeBuilder.append("<p style='vertical-align:middle'>");

		if(typeList != null){
			for(ArticleType type: typeList){
				boolean hasChecked = false;
				if(articleTypeList != null){
					for(String articleType: articleTypeList){
						if(type.getId().equals(articleType)){
							hasChecked = true;
							break;
						}
					}
				}

				if(hasChecked){
					typeBuilder.append("<label style='vertical-align:middle'>" + type.getName() + "</label>");
					typeBuilder.append("<input checked='checked' name='articleTypeList' style='vertical-align:middle' value='" + type.getId() + "' type='checkbox' id='articleTypeList'/>");
					typeBuilder.append("&nbsp;");
					typeBuilder.append("&nbsp;");
					typeBuilder.append("&nbsp;");
				}else{
					typeBuilder.append("<label style='vertical-align:middle'>" + type.getName() + "</label>");
					typeBuilder.append("<input name='articleTypeList' style='vertical-align:middle' value='" + type.getId() + "' type='checkbox' id='articleTypeList'/>");
					typeBuilder.append("&nbsp;");
					typeBuilder.append("&nbsp;");
					typeBuilder.append("&nbsp;");
				}
			}
		}

		typeBuilder.append("</p>");
		req.setAttribute("type", typeBuilder.toString());
		nav = navService.findById(id);
		if(nav != null)
			req.setAttribute("navigation", nav);
		return "navigation/update";
	}


	/**
	 * 更新navigation
	 * @param nav
	 * */
	@RequestMapping("/navigation/updateSubmit.do")
	public void updateSubmit(Navigation nav, HttpServletRequest req, HttpServletResponse resp) throws IOException{
		User user = super.getLoginUser(req);
		if(user != null){
			nav.setUpdator(user.getName());
		}
		nav.setCreatedTime(DateUtil.getNowDate(null));

		//获取关联的文章类别，然后存入数据库中
		String[] types = req.getParameterValues("articleTypeList");
		StringBuilder sb = new StringBuilder();
		if(types != null)
			for(int i=0; i<types.length; i++){
				if(i != types.length-1)
					sb.append(types[i] + Navigation.ARTICLE_TYPE_SEPORATOR);
				else
					sb.append(types[i]);
			}
		nav.setArticleTypeListStr(sb.toString());
		navService.update(nav);
		println(resp, JsonUtil.createJson("success", "更新成功"));
	}


}
