package net.itaem.privilege.entity;

import java.util.ArrayList;
import java.util.List;

import net.itaem.base.entity.BaseEntity;

/**
 * 权限实体类
 * 这个权限之间有层次关系
 * 由于权限存在着类别，所以每个权限都会属于某个权限类别
 * 并且一个权限只能属于一个类别，一个类别下面不存在子类别
 * 为了编程更加简单，这里将类别也存在同一个表，唯一不同的就是，类别没有url，默认数据库为空
 * @author luohong
 * @date 2014-12-29
 * @email 846705189@qq.com
 * 
 * */
public class Privilege extends BaseEntity {
	
	private String name;  //资源名字
	private String url;  //资源的访问URL
	private String desc;  //资源介绍
	
	private String parentId;
	private List<Privilege> children;
	private Privilege parent;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public List<Privilege> getChildren() {
		return children;
	}
	public void setChildren(List<Privilege> children) {
		this.children = children;
	}
	public Privilege getParent() {
		return parent;
	}
	public void setParent(Privilege parent) {
		this.parent = parent;
	}

	/**
	 * 添加子权限
	 * @Param child 子权限
	 * */
	public void addSubPrivilege(Privilege child){
		if(children == null){
			children = new ArrayList<Privilege>();
		}
		if(!children.contains(child))
			children.add(child);
	}

	/**
	 * 添加子权限列表
	 * @param children 子权限列表
	 * 
	 * */
	public void addSubPrivilegeList(List<Privilege> children){
		if(children == null){
			children = new ArrayList<Privilege>();
		}
		for(Privilege child: children){
			addSubPrivilege(child);
		}
	}
	@Override
	public String toString() {
		return "Privilege [name=" + name + ", url=" + url + ", desc=" + desc
				+ ", parentId=" + parentId + ", children=" + children
				+ ", parent=" + parent + "]";
	}
}
