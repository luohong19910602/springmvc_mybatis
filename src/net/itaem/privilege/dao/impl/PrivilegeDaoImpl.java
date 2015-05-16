package net.itaem.privilege.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import net.itaem.privilege.dao.IPrivilegeDao;
import net.itaem.privilege.entity.Privilege;
import net.itaem.privilege.entity.PrivilegeMapper;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author luohong
 * @email 846705189@qq.com
 * @date 2014-12-29
 * */
@Repository
public class PrivilegeDaoImpl implements IPrivilegeDao {

	@Resource(name = "privilegeMapper")
	private PrivilegeMapper privilegeMapper;

	@Override
	public List<Privilege> listAll() {
		String sql = "select * from sys_privilege where privilege_del_flag = 0";
		List<Privilege> privilegeList = privilegeMapper.listAll(sql);  
		List<Privilege> parentList = new ArrayList<Privilege>();  

		if(privilegeList != null && privilegeList.size() > 0){  
			Iterator<Privilege> privilegeIterator = privilegeList.iterator();

			List<Privilege> removedPrivilege = new ArrayList<Privilege>();  
			while(privilegeIterator.hasNext()){
				Privilege privilege = privilegeIterator.next();
				//设置menu的resource
				if(privilege.getParentId() == null){
					parentList.add(privilege);
					removedPrivilege.add(privilege);
				}
			}


			privilegeList.removeAll(removedPrivilege);

			if(privilegeList.size() > 0){  
				privilegeIterator = parentList.iterator();
				while(privilegeIterator.hasNext()){
					Privilege privilege = privilegeIterator.next();
					organizePrivilege(privilege, privilegeList);
				}
			}
		}

		return parentList;
	}

	private void organizePrivilege(Privilege privilege, List<Privilege> privilegeList) {
		if(privilegeList == null || privilegeList.size() == 0) return;  //break out

		List<Privilege> removedPrivilege = new ArrayList<Privilege>();

		for(Privilege pri: privilegeList){

			if(pri.getParentId() != null && pri.getParentId().equals(privilege.getId())){
				privilege.addSubPrivilege(pri);
				removedPrivilege.add(pri);
			}

		}

		privilegeList.removeAll(removedPrivilege); 

		if(privilegeList.size() == 0) return;

		/**
		 * 对上一层已经找到父亲menu的菜单进行递归调用
		 * source由原来的变成 source - 已经找到父亲menu的剩余菜单
		 * */
		for(Privilege pri: removedPrivilege){
			organizePrivilege(pri, privilegeList);
		}		
	}


	@Override
	public void add(Privilege privilege) {

		if(privilege.getParentId() != null && !privilege.getParentId().equals("")){
			privilegeMapper.addChild(privilege);
		}else{
			privilegeMapper.add(privilege);
		}
	}

	@Override
	public void delete(String[] ids) {
		for(String id: ids){

			privilegeMapper.delete(id);
		}
	}

	@Override
	public Privilege listBy(String privilegeId) {
		return privilegeMapper.listBy(privilegeId);
	}

	/**
	 * 这里需要查询出用户可以访问的全部权限，并且将权限按照类别划分好
	 * */
	@Override
	public List<Privilege> listByRoleId(String roleId) {
		List<Privilege> privilegeList = privilegeMapper.listByRoleId(roleId);
		List<Privilege> typeList = new ArrayList<Privilege>();  
 
		if(privilegeList != null && privilegeList.size() > 0){  
			for(Privilege pri: privilegeList){
				if(pri.getParentId() != null){
					Privilege type = privilegeMapper.listBy(pri.getParentId());
					if(type != null)
						if(!typeList.contains(type))
							typeList.add(type);
				}
			}
			
			
			for(Privilege pri: privilegeList){
				for(Privilege type: typeList){
					if(type.getId().equals(pri.getParentId())){
						type.addSubPrivilege(pri);
					}
				}
			}
		}

		return typeList;
	}
    
	/**
	 * 列出用户的全部权限
	 * 包括角色的权限
	 * */
	@Override
	public List<Privilege> listByUserId(String userId) {
		List<Privilege> privilegeList = privilegeMapper.listByUserId(userId);
		List<Privilege> typeList = new ArrayList<Privilege>();  
        
		if(privilegeList != null && privilegeList.size() > 0){  
			for(Privilege pri: privilegeList){
				if(pri.getParentId() != null){
					Privilege type = privilegeMapper.listBy(pri.getParentId());
					if(type != null)
						if(!typeList.contains(type))
							typeList.add(type);
				}
			}
			
			for(Privilege pri: privilegeList){
				for(Privilege type: typeList){
					if(type.getId().equals(pri.getParentId())){
						type.addSubPrivilege(pri);
					}
				}
			}
		}

		return typeList;
	}

	@Override
	public void update(Privilege privilege) {
		privilegeMapper.update(privilege);
	}

}
