package net.itaem.role.entity;

/**
 * 角色与权限的中间表
 * 
 * @author luohong
 * @date 2014-12-25
 * @email 846705189@qq.com
 * */
public class RolePrivilege {
    
	private String id;  //代理id
	private String roleId;  //角色id
	private String privilegeId;
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
	public String getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}
	@Override
	public String toString() {
		return "RolePrivilege [id=" + id + ", roleId=" + roleId
				+ ", privilegeId=" + privilegeId + "]";
	}
	
}
