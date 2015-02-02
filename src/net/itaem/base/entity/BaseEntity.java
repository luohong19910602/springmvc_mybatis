package net.itaem.base.entity;

/**
 * 公共基础类
 * 所有的entity继承该类，并且这个类复写了hashCode()以及equals()方法，
 * 用来判断两个实体是否相等，使用id来判断
 * @author luohong
 * @date 2014-12-16
 * @email 846705189@qq.com
 * */
public class BaseEntity {
	/**
     * 已经删除
     * */
    public static final int DELETED = 1;  
    
	/**
     * 正常
     * */
    public static final int NORMAL = 0;  
    /**
     * 锁定
     * */
    public static final int LOCK = 0;
	private String id;  //实体ID
    private String createdTime;  //实体创建时间
    private String creator;  //实体创建者
    private String updatedTime;  //实体修改时间
    private String updator;  //实体修改者
    private int delFlag = NORMAL;  //实体删除标志
    
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}
	public String getUpdator() {
		return updator;
	}
	public void setUpdator(String updator) {
		this.updator = updator;
	}
	public int getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", createdTime=" + createdTime
				+ ", creator=" + creator + ", updatedTime=" + updatedTime
				+ ", updator=" + updator + ", delFlag=" + delFlag + "]";
	}
	
}
