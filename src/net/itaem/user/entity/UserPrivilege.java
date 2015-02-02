package net.itaem.user.entity;

/**
 * 用户-权限中间表
 * @author luohong
 * @date 2015-01-14
 * @email 846705189@qq.com
 * */
public class UserPrivilege {

	private String id;
	private String userId;
	private String privilegeId;
	
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
	public String getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}
	@Override
	public String toString() {
		return "UserPrivilege [id=" + id + ", userId=" + userId
				+ ", privilegeId=" + privilegeId + "]";
	}
	
	
}
