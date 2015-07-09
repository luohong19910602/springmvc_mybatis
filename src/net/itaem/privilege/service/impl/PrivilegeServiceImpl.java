package net.itaem.privilege.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.itaem.privilege.dao.IPrivilegeDao;
import net.itaem.privilege.entity.Privilege;
import net.itaem.privilege.service.IPrivilegeService;
import net.itaem.role.dao.IRoleDao;
import net.itaem.role.entity.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PrivilegeServiceImpl implements IPrivilegeService {

	@Autowired
	private IPrivilegeDao privilegeDao;

	@Autowired
	private IRoleDao roleDao;

	@Override
	public List<Privilege> listAll() {
		return privilegeDao.listAll();
	}

	@Transactional
	@Override
	public void add(Privilege privilege) {
		privilegeDao.add(privilege);
	}

	@Transactional
	@Override
	public void delete(String[] ids) {
		privilegeDao.delete(ids);
	}


	@Override
	public Privilege listBy(String privilegeId) {
		return privilegeDao.listBy(privilegeId);
	}
	@Override
	public List<Privilege> listByRoleId(String roleId) {
		return privilegeDao.listByRoleId(roleId);
	}
	@Override
	public List<Privilege> listAllWithoutOrg() {
		List<Privilege> privilegeList = privilegeDao.listAll();

		List<Privilege> result = new ArrayList<Privilege>();  //直接通过深度遍历来取出菜单的数据

		//使用广度遍历
		if(privilegeList != null){
			for(Privilege privilege: privilegeList){
				result.addAll(allPrivilege(privilege));
			}
		}
		return result;
	}

	private List<Privilege> allPrivilege(Privilege parent) {
		List<Privilege> result = new ArrayList<Privilege>();  //直接通过深度遍历来取出菜单的数据

		result.add(parent);

		if(parent.getChildren() != null && parent.getChildren().size() > 0){  //取出子menu
			for(Privilege child: parent.getChildren()){
				result.addAll(allPrivilege(child));
			}
		}

		return result;
	}

	/**
	 * 列出用户的全部权限
	 * 
	 * */
	@Override
	public List<Privilege> listByUserId(String userId) {
		List<Privilege> privilegeList = privilegeDao.listByUserId(userId);
		
		List<Privilege> typeList = new ArrayList<Privilege>();  
		 
		if(privilegeList != null && privilegeList.size() > 0){  
			//找到所有的权限类别
			for(Privilege pri: privilegeList){
				if(pri.getParentId() != null){
					Privilege type = privilegeDao.listBy(pri.getParentId());
					
					if(type != null)
						if(!typeList.contains(type))
							typeList.add(type);
				}
			}
			
			//将权限按照类别信息分类
			for(Privilege pri: privilegeList){
				for(Privilege type: typeList){
					if(type.getId().equals(pri.getParentId())){
						type.addSubPrivilege(pri);
					}
				}
			}
		}
		
		return typeList;
//		//角色权限
//		List<Role> roleList = roleDao.listByUserId(userId);
//		List<Privilege> result = new ArrayList<Privilege>();
//
//		if(roleList != null && roleList.size() > 0){
//			for(Role role: roleList){
//				List<Privilege> priList = listByRoleId(role.getId());
//				if(priList != null && priList.size() > 0){
//					for(Privilege pri: priList){
//						if(!result.contains(pri)){
//							result.add(pri);			
//						}			
//					}
//				}
//			}
//		}
//
//		//用户权限
//		List<Privilege> priList = privilegeDao.listByUserId(userId);
//
//		if(priList != null && priList.size() > 0){
//			for(Privilege pri: priList){
//				if(!result.contains(pri)){
//					result.add(pri);			
//				}else{
//					result.get(result.indexOf(pri)).addSubPrivilegeList(pri.getChildren());;
//				}
//			}
//		}
//
//		return result;
	}

	@Override
	public void update(Privilege privilege) {
		privilegeDao.update(privilege);
	}


}
