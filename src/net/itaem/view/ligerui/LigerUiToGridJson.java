package net.itaem.view.ligerui;

import java.util.List;

import net.itaem.article.entity.Article;
import net.itaem.article.entity.ArticleType;
import net.itaem.menu.entity.Menu;
import net.itaem.privilege.entity.Privilege;
import net.itaem.role.entity.Role;
import net.itaem.user.entity.User;
import net.itaem.view.IToGridJson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 将数据变成liger ui grid组件的json字符串
 * 由于这个方法都是线程安全的，并且都是一些工具方法，所以这里使用单例模式，来实现更加高效的内存管理
 * @author luohong
 * @email 846705189@qq.com
 * @date 2014-12-29
 * */
public class LigerUiToGridJson implements IToGridJson {

	private static final LigerUiToGridJson instance = new LigerUiToGridJson();

	private LigerUiToGridJson(){}

	public static LigerUiToGridJson getInstance(){
		return instance;
	}

	/**
	 * 
	 * @param privilegeList
	 * @return
	 * */
	public String privilegeListToGrid(List<Privilege> privilegeList, int total){
		if(privilegeList == null || total == 0) return new JSONObject().toString();

		JSONObject json = new JSONObject();
		JSONArray children = new JSONArray();
		for(Privilege child: privilegeList){
			children.add(privilegeToGrid(child));
		}

		json.put("Rows", children);
		json.put("Total", total);

		return json.toString();
	}

	public String userListToGrid(List<User> userList){
		JSONObject json = new JSONObject();

		JSONArray children = new JSONArray();

		for(User user: userList){
			children.add(userToGrid(user));
		}

		json.put("Rows", children);

		json.put("Total", "11");
		return json.toString();
	}

	public String userToGrid(User user) {
		JSONObject json = new JSONObject();

		json.put("id", user.getId());
		json.put("name", user.getName());
		json.put("email", user.getEmail());
		json.put("qq", user.getQq());
		json.put("address", user.getAddress());
		json.put("currentAddress", user.getCurrentAddress());
		json.put("blog", user.getBlog());
		json.put("tel", user.getTel());
		json.put("birthday", user.getBirthday());
		json.put("loginName", user.getLoginName());

		return json.toString();
	}


	public String menuListToGrid(List<Menu> menuList){
		JSONObject json = new JSONObject();

		JSONArray children = new JSONArray();

		for(Menu menu: menuList){
			children.add(menuToGrid(menu));
		}

		json.put("Rows", children);
		return json.toString();
	}

	public String menuToGrid(Menu menu){
		JSONObject json = new JSONObject();

		json.put("id", menu.getId());
		json.put("name", menu.getName());
		json.put("desc", menu.getDesc());
		json.put("url", "");

		JSONArray children = new JSONArray();

		//递归遍历子节点menu
		if(menu.getChildren() != null && menu.getChildren().size() > 0){
			for(Menu child: menu.getChildren()){
				children.add(menuToGrid(child));
			}		
		}
		//递归遍历资源
		if(menu.getResourceList() != null && menu.getResourceList().size() > 0){
			for(net.itaem.resource.entity.Resource resource: menu.getResourceList()){
				children.add(resourceToGrid(resource));
			}
		}

		//如果有节点或者子资源，那么久加入到children中
		if(children.size() > 0)
			json.put("children", children);

		return json.toString();
	}

	public String resourceToGrid(net.itaem.resource.entity.Resource resource){
		JSONObject json = new JSONObject();

		json.put("id", resource.getId());
		json.put("name", resource.getName());
		json.put("url", resource.getUrl());
		json.put("desc", resource.getDesc());

		return json.toString();
	}
	/**
	 * 将Privilege变成liger ui grid json数据
	 * @param privilegeList
	 * @return
	 * */
	public String privilegeToGrid(Privilege privilege){
		JSONObject json = new JSONObject();

		json.put("id", privilege.getId());
		json.put("name", privilege.getName());
		json.put("url", privilege.getUrl());
		json.put("desc", privilege.getDesc());

		if(privilege.getChildren() != null && privilege.getChildren().size() > 0){
			JSONArray children = new JSONArray();

			for(Privilege child: privilege.getChildren()){
				children.add(privilegeToGrid(child));
			}

			json.put("children", children);
		}
		return json.toString();
	}

	/**
	 * 将role
	 * */
	public String roleListToGrid(List<Role> roleList) {

		JSONObject json = new JSONObject();

		JSONArray children = new JSONArray();

		for(Role role: roleList){
			children.add(roleToGrid(role));
		}

		json.put("Rows", children);

		return json.toString();
	}

	public String roleToGrid(Role role) {
		JSONObject json = new JSONObject();

		json.put("id", role.getId());
		json.put("name", role.getName());


		if(role.getChildren() == null){
			return json.toString();			
		}else{
			JSONArray children = new JSONArray();
			for(Role child: role.getChildren()){
				children.add(roleToGrid(child));
			}
			json.put("children", children.toString());

			return json.toString();
		}

	}

	@Override
	public String articleTypeListToGrid(List<ArticleType> articleTypeList) {
		if(articleTypeList == null || articleTypeList.size() == 0){
			return new JSONObject().toString();
		}else{
			JSONObject json = new JSONObject();
			JSONArray articleTypeListJson = new JSONArray();
			for(ArticleType at: articleTypeList){
				JSONObject articleTypeJson = new JSONObject();
				articleTypeJson.put("id", at.getId());
				articleTypeJson.put("name", at.getName());
				articleTypeJson.put("desc", at.getDesc());
				articleTypeListJson.add(articleTypeJson);
			}
			json.put("Rows", articleTypeListJson);
			json.put("Total", articleTypeList.size());
			return json.toString();
		}
	}

	@Override
	public String articleListToGrid(List<Article> articleList) {
		JSONObject json = new JSONObject();

		JSONArray children = new JSONArray();

		for(Article article: articleList){
			children.add(articleToGrid(article));
		}

		json.put("Rows", children);

		return json.toString();
	}

	private Object articleToGrid(Article article) {
		JSONObject json = new JSONObject();

		json.put("id", article.getId());
		json.put("title", article.getTitle());
		json.put("summary", article.getSummary());		
		
		if(article.getType() != null)
			json.put("typeId", article.getType().getName());

		return json.toString();
	}

}
