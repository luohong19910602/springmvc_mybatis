package net.itaem.user.entity;

import java.util.List;

import net.itaem.base.entity.BaseEntity;
import net.itaem.role.entity.Role;

/**
 * 资源实体类
 * @author luohong
 * @date 2014-12-16
 * @email 846705189@qq.com
 * */
public class User extends BaseEntity{
	/**
	 * 超级用户
	 * */
	public static final int SUPER_USER = 1;

	/**
	 * 不是超级用户
	 * */
	public static final int NOT_SUPER_USER = 0;

	private String name;  //用户名字
	private String email;  //邮箱
	private String tel;  //电话
	private String loginName;  //登录名
	private String password;  //密码
	private String blog;  //博客地址
	private String address;  //家庭住址
	private String currentAddress;  //目前居住地
	private String birthday;  //生日
	private String qq;  //qq
	private String lastedLoginTime;  //上次登录时间
	private int loginCount;  //登录总次数
	private String roleNames;  //用户角色，这里使用','来分割每个角色名字
	private int superUserFlag = NOT_SUPER_USER;  //标识符，标识用户是否是超级用户
	/**
	 * 用户的角色列表
	 * */
	private List<Role> roleList;

	/**
	 * 获取用户的角色列表
	 * */
	public String getRoleNames(){
		return roleNames;
	}

	
	

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		if(roleList == null) return;
		
		this.roleList = roleList;
		StringBuilder sb = new StringBuilder();
		for(Role role: roleList){
			sb.append(role.getName() + ",");
		}
		
		roleNames = sb.substring(0, sb.length() - 1);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(String currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getLastedLoginTime() {
		return lastedLoginTime;
	}

	public void setLastedLoginTime(String lastedLoginTime) {
		this.lastedLoginTime = lastedLoginTime;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public int getSuperUserFlag() {
		return superUserFlag;
	}

	public void setSuperUserFlag(int superUserFlag) {
		this.superUserFlag = superUserFlag;
	}

	@Override
	public String toString() {
		return super.toString() + "User [name=" + name + ", email=" + email + ", tel=" + tel
				+ ", loginName=" + loginName + ", password=" + password
				+ ", blog=" + blog + ", address=" + address
				+ ", currentAddress=" + currentAddress + ", birthday="
				+ birthday + ", qq=" + qq + ", lastedLoginTime="
				+ lastedLoginTime + ", loginCount=" + loginCount
				+ ", superUserFlag=" + superUserFlag + "]";
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}


}
