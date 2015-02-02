package net.itaem.resource.entity;

import net.itaem.base.entity.BaseEntity;

/**
 * 资源实体类
 * @author luohong
 * @date 2014-12-16
 * @email 846705189@qq.com
 * */
public class Resource extends BaseEntity{
    
	private String name;  //资源名字
    private String url;  //资源的访问URL
    private String desc;  //资源介绍
    private String menuId;  //资源所属菜单id
	private String pic;  //资源图标
    
    public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
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
	
	
	@Override
	public String toString() {
		return super.toString() + "Resource [name=" + name + ", url=" + url + ", desc=" + desc + ", menuId=" + menuId
				+ ", pic=" + pic +  "]";
	}
    
}
