package net.itaem.base.entity;

/**
 * 翻页对象
 * 这里保存翻页需要的几个信息
 * @author luohong
 * @date 2015-01-15
 * */
public class Page {
	
	private int page = 1;  //页数
	private int size = DEFAULT_SIZE;  //每页记录数
	private int offset;  //数据库记录开始的地方，默认为0
	private int totalPage;
	private int totalSize;

	/**
	 * 默认每页显示的记录数据
	 * */
	public static final int DEFAULT_SIZE = 10;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getOffset() {
		return (page - 1) * size;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}	
}
