package net.itaem.view.ligerui;

import net.itaem.view.ILigerFactory;
import net.itaem.view.IToGridJson;
import net.itaem.view.IToTreeJson;

/**
 * 默认liger ui的factory
 * 如果使用dwz,esayui,extjs等开源框架，需要提供例外的factory
 * @author luohong
 * @email 846705189@qq.com
 * @date 2015-01-15
 * */
public class DefaultLigerUiFactory implements ILigerFactory {
	
	@Override
	public IToGridJson createToGridJson() {
		return LigerUiToGridJson.getInstance();
	}

	@Override
	public IToTreeJson createToTreeJson() {
		return LigerUiToTreeJson.getInstance();
	}

}
