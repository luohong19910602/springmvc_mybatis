package net.itaem.role.entity;

/**
 * 角色与用户中间类
 * 
 * @author luohong
 * @date 2014-12-25
 * @email 846705189@qq.com
 * */
public class RoleUser {
    
	private String id;  //代理id
	private String roleId;  //角色id
	private String userId;
	
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "RoleUser [id=" + id + ", roleId=" + roleId + ", userId="
				+ userId + "]";
	}
}
