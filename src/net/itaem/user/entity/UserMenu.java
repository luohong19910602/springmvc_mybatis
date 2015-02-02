package net.itaem.user.entity;

/**
 * 用户-菜单中间表
 * @author luohong
 * @date 2015-01-14
 * @email 846705189@qq.com
 * */
public class UserMenu {

	private String id;
	private String userId;
	private String menuId;
	private String resourceId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
		return "UserMenu [id=" + id + ", userId=" + userId + ", menuId="
				+ menuId + ", resourceId=" + resourceId + "]";
	}
	
}
