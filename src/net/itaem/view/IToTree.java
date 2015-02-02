package net.itaem.view;

import net.itaem.menu.entity.Menu;
import net.itaem.privilege.entity.Privilege;
import net.itaem.role.entity.Role;

/**
 * 实现菜单、角色、权限-->Liger Ui Tree转换
 * 
 * @author luohong
 * @date 2014-12-24
 * @email 846705189@qq.com
 * */
public interface IToTree {

	/**
	 * 将Menu变成一个Tree
	 * @param menu
	 * @return
	 * */
	public ITree menuToTree(Menu menu);
	
	/**
	 * 将Role变成一个Tree
	 * @param role
	 * @return
	 * */
	public ITree roleToTree(Role role);
	
	/**
	 * 将一个Privilege变成一个Tree
	 * @param containsSelf 转变成树时，是否是把自己当做子树，因为ligerui的树组件，选择子子节点时，默认会勾上父节点，但是时间上没有选中
	 * @param privilege
	 * @return
	 * */
	public ITree privilegeToTree(Privilege privilege);
}
