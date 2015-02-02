package net.itaem.resource.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.itaem.privilege.entity.Privilege;
import net.itaem.privilege.service.IPrivilegeService;
import net.itaem.resource.entity.Resource;
import net.itaem.resource.service.IResourceService;
import net.itaem.util.JsonUtil;
import net.itaem.util.ResponseUtil;
import net.itaem.util.UUIDUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Resource Controller
 * 
 * @author luohong
 * @email 846705189@qq.com
 * @date 2014-12-23
 * */
@Controller
@RequestMapping("/resource")
public class ResourceController {

	@Autowired
	private IResourceService resourceService;

	@Autowired
	private IPrivilegeService privilegeService;
	
	/**
	 * 跳转到menu对应的url资源list界面
	 * @param menuId
	 * @param req
	 * @return
	 * */
	@RequestMapping("/openResource.do")
	public String openResource(String menuId, HttpServletRequest req){
		req.setAttribute("menuId", menuId);
		return "resource/list";
	}

	/**
	 * 取出menu对应的url资源，使用json来包装数据
	 * @param menuId
	 * @param req
	 * @param resp
	 * @throws IOException
	 * */
	@RequestMapping("/openResourceJson.do")
	public void openResourceJson(String menuId, HttpServletRequest req, HttpServletResponse resp) throws IOException{
		List<Resource> resourceList = resourceService.listBy(menuId);

		JSONArray menuJsonArray = new JSONArray();
		menuJsonArray.addAll(resourceList);
        
		JSONObject json = new JSONObject();
        
		json.put("Rows", menuJsonArray);
		json.put("Total", resourceList.size());
        
		ResponseUtil.println(resp, json);
	}

	/**
	 * 跳转到添加资源界面
	 * @return
	 * */
	@RequestMapping("/add.do")
	public String add(){
		return "resource/add";
	}

	/**
	 * 添加资源
	 * 这里的资源直接从权限而来
	 * @param resourceIdList
	 * @param desc
	 * @param menuId
	 * @throws IOException 
	 * */
	@RequestMapping("/addSubmit.do")
	public void addSubmit(String privilegeIdList, String menuId, HttpServletResponse resp, HttpServletRequest req) throws IOException{
        
		if(privilegeIdList != null && !"".equals(privilegeIdList)){
			Resource[] resources = createResources(privilegeIdList.split(";"), menuId);
			/**
			 * 添加资源
			 * */
			resourceService.add(resources);
		}
		ResponseUtil.println(resp, JsonUtil.createJson("success", "add a resource is successful"));
	}

	/**
	 * 根据权限的id以及menu，创建新的资源
	 * @param privilegIds
	 * @param menuId
	 * */
	private Resource[] createResources(String[] privilegeIds, String menuId) {
		Resource[] resources = new Resource[privilegeIds.length];
		
		int index = 0;
		
		for(String privilegeId: privilegeIds){
			Privilege pri = privilegeService.listBy(privilegeId);
			if(pri != null){
				Resource res = new Resource();
				if(pri.getName() != null)
					res.setName(pri.getName());
				if(pri.getUrl() != null)
					res.setUrl(pri.getUrl());
				res.setCreator("luohong");
				res.setMenuId(menuId);
				if(pri.getDesc() != null)
					res.setDesc(pri.getDesc());
				res.setCreatedTime(UUIDUtil.uuid());
				res.setId(UUIDUtil.uuid());
				resources[index++] = res;
			}
		}
		
		return resources;
	}

	/**
	 * 删除资源
	 * @param id
	 * @param name
	 * @param desc
	 * @param url
	 * @param menuId
	 * @throws IOException 
	 * */
	@RequestMapping("/delete.do")
	@Transactional
	public void deleteResource(String idsStr, HttpServletResponse resp) throws IOException{
		if(idsStr == null) return;
		
		String[] ids = idsStr.split(",");
		
		resourceService.delete(ids);

		ResponseUtil.println(resp, JsonUtil.createJson("success", "delete resources is successful"));
	}
}
