package net.itaem.role.entity;

/**
 * 角色与菜单的中间表
 * 
 * 这里精确到菜单下面的url链接，也就是同一个链接，不一样的角色，
 * 可以访问到该菜单的不一样url链接
 * @author luohong
 * @date 2014-12-25
 * @email 846705189@qq.com
 * */
public class RoleMenu {
    
	private String id;  //代理id
	private String roleId;  //角色id
	private String menuId;  //菜单id
	private String resourceId;  //菜单资源id
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	
	@Override
	public String toString() {
		return "RoleMenu [id=" + id + ", roleId=" + roleId + ", menuId="
				+ menuId + ", resourceId=" + resourceId + "]";
	}
	
	
}
