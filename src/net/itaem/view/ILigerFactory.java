package net.itaem.view;


/**
 * 这里使用工厂设计模式
 * 
 * @author luohong
 * @email 846705189@qq.com
 * @date 2015-01-15
 * */
public interface ILigerFactory {
	
	public IToGridJson createToGridJson();
	
	public IToTreeJson createToTreeJson();
}
