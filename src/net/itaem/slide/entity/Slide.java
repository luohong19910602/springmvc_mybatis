package net.itaem.slide.entity;

import net.itaem.base.entity.BaseEntity;

public class Slide extends BaseEntity{
    private String title;
    private String desc;
    private String imgUrl;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	@Override
	public String toString() {
		return "Slide [title=" + title + ", desc=" + desc + ", imgUrl="
				+ imgUrl + "]";
	}
}
