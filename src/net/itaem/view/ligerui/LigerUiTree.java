package net.itaem.view.ligerui;
import java.util.ArrayList;
import java.util.List;

import net.itaem.view.ITree;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**  
 * 这里是liger ui树的插件实现类
 * 
 * 在每次add、delete之后，都需要计算树的level
 * 
 * 
 * @author 骆宏  
 * @date 2014-08-19 19:39 am  
 * @email 846705189@qq.com  
 * */  
public class LigerUiTree implements ITree{  

	//定义一个level，用来保存树的层次  
	private int level = 1;
	//定义一个url，用来保存当前节点的url  
	private String url;  
	//定义一个id，用来保存当前节点id  
	private String id;  
	//定义一个isexpend，用来保存节点展开状态  
	private boolean isexpand;  
	//定义一个name，用来保存节点的名称  
	private String name;  
	//定义一个parent，用来保存节点的父亲节点  
	private ITree parent;  
	//定义一个children，用来保存当前节点的所有子节点  
	private List<ITree> children = new ArrayList<ITree>();
	//定义一个nodeType，用来保存结点类型
	private String nodeType = LEAF;
	//定义一个pic，用来保存图片的url地址
	private String pic;
	//用来缓存树的json数据
	private String jsonCache;
	//用来保存用户的操作状态，如果树已经构建好，并且没有删除、添加，那么继续使用jsonCache
	private boolean hasChange;

	public LigerUiTree(){  

	}  

	/**  
	 * 定义一个基本的构造方法，该构造方法的参数都不能为空  
	 * @param id 节点id  
	 * @param name 节点name  
	 * @param url 节点url  
	 * */  
	public LigerUiTree(String id, String name, String url){  
		if(id == null || name == null || url == null) throw new RuntimeException("id name url都不能为空");  

		this.id = id;  
		this.name = name;  
		this.url = url; 

		hasChange = true;
	}  

	public LigerUiTree(String id, String name, String url, ITree parent) {  
		this(id, name, url);  
		this.parent = parent;
		hasChange = true;
	}  

	public LigerUiTree(String id, String name, String url, List<ITree> children) {  
		this(id, name, url);  
		this.children = children;  
		hasChange = true;
	}  

	@Override  
	public void setUrl(String url) {  
		this.url = url;  
		hasChange = true;
	}  

	@Override  
	public void setId(String id) {  
		this.id = id;  
		hasChange = true;
	}  

	@Override  
	public void setIsexpand(boolean isexpand) {  
		this.isexpand = isexpand;  
		hasChange = true;
	}  

	@Override  
	public void setName(String name) {  
		this.name = name;  
		hasChange = true;
	}  

	@Override
	public void setParent(ITree parent) {  
		this.parent = parent;  
		hasChange = true;
	}  

	/**  
	 * 这里同时会计算树的层次  
	 * 并且这里会同时维护parant - children之间的关联管理，也就是在设置当前节点的子节点时，同时会指点这些子节点的父亲节点为当前节点  
	 * */  
	@Override
	public void setChildren(List<ITree> children) {  
		if(children == null || children.size() == 0) return;   //如果为null，do nothing

		this.children = children;  //设置当前结点的子节点为children
		int max = 0;
		ITree child = null;
		for(int i=0; i < children.size(); i++){
			child = children.get(i);
			child.setParent(this);
			if(max < child.level()) max = child.level();
		}

		level += max;
		nodeType = MENU;	
		hasChange = true;
	}  

	@Override  
	public int level() {  
		//每次要计算树的高度，都必须遍历整棵树的，然后确定树的高度，由于树随时可以被改变，所以这里不适合使用缓存模式  
		return level;   
	}  

	@Override  
	public List<ITree> children() {  
		return children;  
	}  

	@Override  
	public ITree parent() {  
		return parent;  
	}  

	@Override  
	public String nodeType() {  
		return nodeType;
	}  

	@Override  
	public String url() {  
		return url;  
	}  

	@Override  
	public String id() {  
		return id;  
	}  

	@Override  
	public boolean isexpand() {  
		return isexpand;  
	}  

	@Override  
	public String name(){  
		return name;  
	}  

	@Override  
	public String toTreeJson() {  
		if(hasChange && jsonCache == null){  
			JSONObject json = new JSONObject();
			//生成这个节点的基本数据  
			json.put("text", name);  
			json.put("isexpand", isexpand);  
            json.put("id", id);
            json.put("icon", pic);
            
			if(url != null && !"".equals(url))
				json.put("url", url);  

			if(parent != null){  
				json.put("pid", parent.id());     
			}

			//生成这个节点的子菜单数据  
			JSONArray childrenJson = new JSONArray();  
			if(children != null && children.size() != 0){  
				for(ITree child: children){  
					//让每个子menu递归的去生成json数据  
					childrenJson.add(toJson(child));  
				}  
				json.put("children", childrenJson);  
			}
			jsonCache = json.toString();
			return jsonCache;
		}else
			return jsonCache;
	}  

	/**  
	 * 递归入口  
	 * @see MenuVo#toJson()  
	 * */  
	private String toJson(ITree tree){  
		JSONObject json = new JSONObject();  
		if(tree.children() != null && tree.children().size() != 0){  
			//生成这个菜单节点的基本数据  
			json.put("text", tree.name());  
			json.put("id", tree.id());
			json.put("icon", tree.pic());
			
			if(tree.parent() != null){  
				json.put("pid", tree.parent().id());  
			}  

			json.put("isexpand", tree.isexpand());  

			//生成这个菜单节点的子菜单数据  
			JSONArray childrenJson = new JSONArray();  
			if(tree.children() != null){  
				for(ITree child: tree.children()){  
					//让每个子menu递归的去生成json数据  
					childrenJson.add(toJson(child));  
				}  
				json.put("children", childrenJson);  
			}  
		}else{   //这个节点不是菜单，是菜单下面的一个具体子节点，该节点已经没有子节点了  
			json.put("id", tree.id());  
			if(tree.parent() != null){  
				json.put("pid", tree.parent().id());  
			}  
			json.put("text", tree.name());  
			json.put("url", tree.url());  
			json.put("icon", tree.pic());
		}  
		return json.toString();  
	}  

	@Override  
	public List<ITree> route() {  
		List<ITree> route = new ArrayList<ITree>();  
		ITree current = this;  
		while(current != null){  
			route.add(current);  
			current = current.parent();  
		}  
		java.util.Collections.reverse(route);  
		return route;  
	}  

	@Override  
	public ITree subTree(int position) {  
		if(position < 0) throw new RuntimeException("position 小于0");
		if(children != null && children.size() > 0 && position <= children.size()-1){
			return children.get(position);
		}
		return null;
	}  

	/**
	 * 生成hashCode
	 * */
	@Override  
	public int hashCode() {  
		return id.hashCode() * 37 + 5; 
	}  

	/**
	 * 比较两个菜单是否相等
	 * */
	@Override  
	public boolean equals(Object obj) {  
		return id.equals(((ITree)obj).id()); 
	}  

	/**  
	 * 返回节点的基本信息  
	 * @return  
	 * */  
	@Override  
	public String toString() {  
		return "LigerUiTree [" + "id=" + id + ", name=" + name 
				+ ", level=" + level + ", url=" + url  
				+ ", nodeType=" + nodeType() + ", isexpand=" + isexpand + ",  pic=" + pic + "]";  
	}


	@Override
	public boolean addSubTree(ITree subTree) {
		if(subTree == null) return false;
		nodeType = MENU;
		subTree.setParent(this);

		boolean addedFlag = children.add(subTree);

		calculateLevel0(subTree);

		hasChange = true;
		return addedFlag;
	}

	@Override
	public void addSubTree(int position, ITree subTree) {
		if(position < 0 || position >= children.size()) return;
		children.add(position, subTree);

		calculateLevel0(subTree);
		if(children.size() > 0)
			nodeType = MENU;

		hasChange = true;
	}  

	/**
	 * 增加一个结点，计算level，分为四种情况
	 * */
	private void calculateLevel0(ITree subTree){
		if(this.isLeaf() && subTree.isLeaf()){
			level = 2;
		}else if(this.isMenu() && subTree.isMenu()){
			level += subTree.level();
		}else if(this.isLeaf() && subTree.isMenu()){
			level = subTree.level() + 1;
		}else{
			//is menu, so add a new leaf, the level not change	
		}
	}


	@Override
	public boolean deleteSubTree(ITree subTree) {
		boolean deletedFlag = false;
		for(int i=0; i<children.size(); i++){
			if(children.get(i).equals(subTree)){
				children.remove(i);
				break;
			}
		}

		if(children.size() > 0)
			nodeType = MENU;


		calculateLevel();

		hasChange = true;
		return deletedFlag;
	}

	@Override
	public boolean deleteSubTree(int position) {
		if(position < 0 || children == null || children.size() == 0 || position >= children.size()) return false;
		ITree tree = children.remove(position);
		if(children.size() > 0) 
			nodeType = MENU;

		calculateLevel();

		hasChange = true;
		if(tree == null) return false;
		else return true;
	}


	/**
	 * 计算输的层次，每次删除一个结点，需要遍历当前所有子节点，看看当前的子节点中，最大的level，然后将这个值+1即可
	 * */
	private void calculateLevel(){
		//设置level，遍历所有的children树，然后取最大值  
		int max = -1;  

		for(int i=0; i<children.size(); i++){  
			children.get(i).setParent(this);   //维护parent-children的相互关联关系  
			if(children.get(i).level() > max) max = children.get(i).level();  
		}  

		//如果添加的节点都是叶子节点，那么当前层次为2  
		//否则计算最大的树层次 = 子节点最大的层次 + 1  
		if(max != -1){  
			level = max + 1;  
		}else{  
			level = 2;     
		}
	}

	@Override
	public boolean isMenu() {
		return nodeType.equals(ITree.MENU);
	}

	@Override
	public boolean isLeaf() {
		return nodeType.equals(ITree.LEAF);
	}

	@Override
	public String pic() {
		return pic;
	}

	@Override
	public void setPic(String pic) {
		this.pic = pic;
	}
}