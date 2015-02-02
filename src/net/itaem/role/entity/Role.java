package net.itaem.role.entity;

import java.util.ArrayList;
import java.util.List;

import net.itaem.base.entity.BaseEntity;
import net.itaem.menu.entity.Menu;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 角色实体类
 * 在角色这一端维护了menu-role之间的多对多关系
 * 
 * @author luohong
 * @date 2014-12-16
 * @email 846705189@qq.com
 * */
public class Role extends BaseEntity{
	private String name;  //角色名字 
    private String parentId;  //父亲角色id
    private List<Menu> menuList;  //可以访问的菜单
	private Role parent;  //父亲角色
	private List<Role> children;  //子角色
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	public Role getParent() {
		return parent;
	}
	public void setParent(Role parent) {
		this.parent = parent;
	}
	public List<Role> getChildren() {
		return children;
	}
	public void setChildren(List<Role> children) {
		this.children = children;
	}
	
	public void add(Role child){
		if(children == null){
			children = new ArrayList<Role>();
		}
		children.add(child);
	}
	
	@Override
	public String toString() {
		return super.toString() + "Role [name=" + name + ", parentId=" + parentId + ", menuList="
				+ menuList + ", parent=" + parent + ", children=" + children
				+ "]";
	}
	
	public String buildString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
	public static void main(String[] args) {
		//System.out.println(new Role().buildString());
		ToStringStyle style = ToStringStyle.SIMPLE_STYLE;
		StringBuffer sb = new StringBuffer();
		
		style.append(sb, "hello", "hello", true);
		style.append(sb, "hello", "hello", true);
		
		System.out.println(sb.toString());
	}
}
