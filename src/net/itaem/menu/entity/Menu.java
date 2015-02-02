package net.itaem.menu.entity;

import java.util.ArrayList;
import java.util.List;

import net.itaem.base.entity.BaseEntity;
import net.itaem.resource.entity.Resource;

/**
 * 菜单实体类
 * 
 * @author luohong
 * @date 2014-12-16
 * @email 846705189@qq.com
 * */
public class Menu extends BaseEntity{
	private String name;  //菜单名字
	private Menu parent;  //父亲菜单
	private List<Menu> children;  //子菜单
	private String desc;  //菜单介绍
	private String parentId;
	private List<String> childrenIdList;
	private List<Resource> resourceList;
	private String pic;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Menu getParent() {
		return parent;
	}

	public void setParent(Menu parent) {
		this.parent = parent;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<String> getChildrenIdList() {
		return childrenIdList;
	}

	public void setChildrenIdList(List<String> childrenIdList) {
		this.childrenIdList = childrenIdList;
	}

	public List<Resource> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}



	/**
	 * 添加菜单资源
	 * @param resource
	 * */
	public void addResource(Resource resource){
		if(resourceList == null){
			resourceList = new ArrayList<Resource>();
		}

		if(!resourceList.contains(resource)){
			resourceList.add(resource);
		}
	}



	/**
	 * 添加菜单资源
	 * @param resList
	 * */
	public void addResourceList(List<Resource> resList){
		if(resourceList == null)
			resourceList = new ArrayList<Resource>();
        
		if(resList != null && resList.size() > 0){
			for(Resource res: resList){
				if(!resourceList.contains(res)){
					resourceList.add(res);
				}
			}
		}
	}


	@Override
	public String toString() {
		return super.toString() + "Menu [name=" + name + ", parent=" + parent + ", children="
				+ children + ", desc=" + desc + ", parentId=" + parentId
				+ ", childrenIdList=" + childrenIdList + ", resourceList="
				+ resourceList + ", pic= " + pic + "]";
	}

	/**
	 * 添加子菜单
	 * */
	public void addSubMenu(Menu menu) {
		if(children == null){
			children = new ArrayList<Menu>();
		}
		if(menu != null){
			if(!children.contains(menu)){
				children.add(menu);
			}
		}

	}

	/**
	 * 添加多个子菜单
	 * @param menuList
	 * */
	public void addSubMenu(List<Menu> menuList){
		if(children == null){
			children = new ArrayList<Menu>();
		}

		if(menuList != null){
			for(Menu menu: menuList){
				if(!children.contains(menu)){
					children.add(menu);
				}
			}
		}
	}

	/**
	 * 递归合并menu
	 * 将一个menu的子menu添加到menu对象中，同时资源列表也是
	 * 
	 * @param that
	 * */
	public void merge(Menu that){
		if(this.equals(that)){
			if(that.getChildren() != null && that.getChildren().size() > 0){
				addSubMenu(that.getChildren());
			}

			if(that.getResourceList() != null && that.getResourceList().size() > 0){
				addResourceList(that.getResourceList());
			}

			if(getChildren() != null && getChildren().size() > 0 
					&& that.getChildren() != null && that.getChildren().size() > 0){

				for(Menu m1: getChildren()){
					for(Menu m2: that.getChildren()){
						if(m1.equals(m2)){ 
							m1.merge(m2);
						}
					}
				}
			}	

		}
	}

	public static void main(String[] args) {
		Menu m1 = new Menu();
		m1.setName("menu1");

		Menu m2 = new Menu();
		m2.setName("menu2");

		m1.setId("1");
		m2.setId("1");

		Menu m3 = new Menu();
		m3.setId("3");
		List<Resource> resList = new ArrayList<Resource>();
		Resource res = new Resource();
		res.setName("res");
		resList.add(res);
		m3.setResourceList(resList);

		m2.addSubMenu(m3);

		m1.merge(m2);

		System.out.println("m1 == m2?" + m1.equals(m2));
	}
}
