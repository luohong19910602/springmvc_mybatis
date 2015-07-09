package net.itaem.base.entity;

import java.util.Map;

/**
 * 翻页对象
 * 这里面将一个sql按照如下格式来划分：
 * 
 * select * from xxx
 * where ${whereSql}
 * order by &{orderBySql}
 * limit ${limitSql}
 * 
 * 
 * @author luohong
 * @date 2015-01-15
 * */
public class Page {

	/**
	 * 默认可以选择的翻页选项
	 * */
	public final static int[] SIZE_OPTIONS = new int[]{10, 20, 30, 40, 50};

	/**
	 * 默认每页显示的记录数据
	 * */
	public static final int DEFAULT_SIZE = 10;

	private int page = 1;  //页数
	private int size = DEFAULT_SIZE;  //每页记录数
	private int offset;  //数据库记录开始的地方，默认为0
	private int totalPage;  //总页码数
	private int totalSize;  //总记录数

	private String sortname;  //排序的名字
	private String sortorder;  //排序顺序

	/**
	 * 构建查询的sql
	 * 这里面包含了where,order by,limit三部分的sql
	 * 
	 * @return a search sql
	 * */
	public String buildSql(){
		return buildWhereSql() + buildOrderBySql() + buildLimitSql();
	}
	
	public String buildWhereSql(){
		if(searchMap != null){
			String whereSql = ""; 
			for(String name: searchMap.keySet()){	    		
				whereSql += name + " like %" + searchMap.get(name) + "%" + " and "; 
			}

			return " where " + whereSql.substring(0, whereSql.length() - 4);
		}
		return "";
	}

	public String buildOrderBySql(){
		if(sortname != null && sortorder != null)
			return " order by " + sortname + " " + sortorder;
		return "";
	}

	public String buildLimitSql(){
		return " limit " + offset + ", " + size;
	}


	private Map<String, String> searchMap;  //查询条件，这几个条件是 && 的关系

	public Map<String, String> getSearchMap() {
		return searchMap;
	}

	public void setSearchMap(Map<String, String> searchMap) {
		this.searchMap = searchMap;
	}

	public String getSortname() {
		return sortname;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public String getSortorder() {
		return sortorder;
	}

	public void setSortorder(String sortorder) {
		this.sortorder = sortorder;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
		offset = (this.page - 1) * size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}


	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getOffset() {
		return offset;
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

	/**
	 * 输出翻页信息
	 * */
	@Override
	public String toString(){
		return "page[page:"+page+",size:"+size+",total:" + totalSize+ ",totalPage:" + totalPage + ",oderBy:" + sortname + " " + sortorder + ",search map:" + searchMap + "]";
	}

}
