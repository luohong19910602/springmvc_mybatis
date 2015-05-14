package net.itaem.web.entity;

import net.itaem.base.entity.BaseEntity;

/**
 * 导航实体，用于首页
 * */
public class Navigation extends BaseEntity implements Comparable<Navigation>{
	public static final String ARTICLE_TYPE_SEPORATOR = "!@!";
	private String name;  //名字
	private String desc;  //备注
	private int sortFlag;   //排序标志，系统会更具当前的标志默认生成下一个sortFlag
	private String articleTypeListStr;  //导航关联的文章类别，使用!@!分割

	public String getArticleTypeListStr() {
		return articleTypeListStr;
	}

	public void setArticleTypeListStr(String articleTypeListStr) {
		this.articleTypeListStr = articleTypeListStr;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getSortFlag() {
		return sortFlag;
	}

	public void setSortFlag(int sortFlag) {
		this.sortFlag = sortFlag;
	}

	@Override
	public int compareTo(Navigation o) {
		return 0;
	}

}
