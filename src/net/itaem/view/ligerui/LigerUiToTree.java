package net.itaem.view.ligerui;

import net.itaem.menu.entity.Menu;
import net.itaem.privilege.entity.Privilege;
import net.itaem.resource.entity.Resource;
import net.itaem.role.entity.Role;
import net.itaem.view.IToTree;
import net.itaem.view.ITree;

/**
 * 工厂类，实现数据库的Menu，Role，Privilege与LigerUi Tree的转换
 * 在将Menu变成LigerUi Tree过程中，需要递归遍历一个menu下面的子menu以及resource
 * 在将Role变成LigerUi Tree过程中，需要递归遍历一个privilege下面的子privilege
 * 在将Privilege变成
 * @author luohong
 * @email 846705189@qq.com
 * @date 2014-12-18
 * */
public class LigerUiToTree implements IToTree {

	private static LigerUiToTree instance = new LigerUiToTree();

	public static LigerUiToTree getInstance(){
		return instance;
	}

	private LigerUiToTree(){

	}

	/***
	 * 将数据库的Menu变成符合LigerUi Tree组件
	 * 并且去掉没有resource和没有子菜单的菜单，
	 * 因为这种菜单没有必要选择出来
	 * 
	 * @param Menu
	 * @return
	 * */
	public ITree menuToTreeAndDeleteNoResource(Menu menu){

		//该menu没有子menu，也没有resource，那么不需要显示出来
		if((menu.getChildren() == null || menu.getChildren().size() == 0) &&
				(menu.getResourceList() == null || menu.getResourceList().size() ==0))
			return null;

		ITree tree = new LigerUiTree();  

		tree.setId(menu.getId());
		tree.setName(menu.getName());
		tree.setPic("http://localhost/springmvc_mybatis/ligerUI/lib/ligerUI/skins/icons/archives.gif");

		if(menu.getChildren() != null && menu.getChildren().size() > 0){
			//遍历子菜单
			for(Menu child: menu.getChildren()){
				ITree childTree = menuToTreeAndDeleteNoResource(child);
				if(childTree != null)
					tree.addSubTree(childTree);  //组织好数据
			}
		}

		if(menu.getResourceList() != null && menu.getResourceList().size() !=0){
			//遍历这个菜单的资源
			for(Resource res: menu.getResourceList()){
				tree.addSubTree(resourceToTree(res));  			
			}
		}
		return tree;
	}

	/***
	 * 将数据库的Menu变成符合LigerUi Tree组件
	 * @param Menu
	 * @return
	 * */
	public ITree menuToTree(Menu menu){
		ITree tree = new LigerUiTree();  

		tree.setId(menu.getId());
		tree.setName(menu.getName());
		tree.setPic("http://localhost/springmvc_mybatis/ligerUI/lib/ligerUI/skins/icons/archives.gif");

		//递归遍历menu
		if(menu.getChildren() != null && menu.getChildren().size() > 0){
			//遍历每个子menu的children以及resource
			for(Menu child: menu.getChildren()){
				ITree childTree = menuToTree(child);
				tree.addSubTree(childTree);  //组织好数据
			}
		}

		//递归遍历resource list
		if(menu.getResourceList() != null && menu.getResourceList().size() > 0){
			for(Resource res: menu.getResourceList()){
				tree.addSubTree(resourceToTree(res));  			
			}
		}

		return tree;
	}

	@Override
	public ITree roleToTree(Role role) {
		ITree tree = new LigerUiTree();

		tree.setId(role.getId());
		tree.setName(role.getName());
		tree.setPic("http://localhost/springmvc_mybatis/ligerUI/lib/ligerUI/skins/icons/memeber.gif"); //默认图片

		//sub tree
		if(role.getChildren() != null && role.getChildren().size() > 0){
			for(Role child: role.getChildren()){
				ITree childTree = roleToTree(child);
				tree.addSubTree(childTree);
			}
		}

		return tree;
	}


	public ITree privilegeToTree(Privilege pri) {
		ITree tree = new LigerUiTree();

		tree.setId(pri.getId());
		tree.setName(pri.getName());
		tree.setUrl(pri.getUrl());

		if(pri.getChildren() != null && pri.getChildren().size() > 0){
			for(Privilege child: pri.getChildren()){
				tree.addSubTree(privilegeToTree(child));
			}
		}
		return tree;
	}



	/**
	 * 将resource变成Tree
	 * */
	private static ITree resourceToTree(Resource res){
		ITree childTree = new LigerUiTree();

		childTree.setId(res.getId());
		childTree.setName(res.getName());
		childTree.setUrl(res.getUrl());
		childTree.setPic(res.getPic());

		return childTree;
	}

}
