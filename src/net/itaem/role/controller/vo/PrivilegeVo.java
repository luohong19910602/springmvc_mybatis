package net.itaem.role.controller.vo;

import net.itaem.privilege.entity.Privilege;

/**
 * 封装了Privilege，加入一些额外字段
 * @author luohong 15013336884 2015-07-10 23:01
 * */
public class PrivilegeVo{
	public static final int YES = 1;
	public static final int NO = 0;

	private Privilege pri;
	private int flag = NO;

	public PrivilegeVo(Privilege pri){
		if(pri != null)
			this.pri = pri;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Privilege getPri() {
		return pri;
	}

	public void setPri(Privilege pri) {
		this.pri = pri;
	}
	
	
}
