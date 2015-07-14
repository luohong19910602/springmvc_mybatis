package net.itaem.autogeneratecode.privilege;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.itaem.util.JdbcUtils;
import net.itaem.util.UUIDUtil;

/**
 * 生成所有的权限信息
 * 这里面使用注解来给某个controller添加信息，然后系统自动根据注解信息来生成所有的privilege信息
 * 
 * 每次执行该代码时，会delete原来的权限信息
 * 
 * 注解
 * 
 * */
public class AutomaticGeneratePrivilege {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		createPrivilege();
	}

	private static String basePath() throws IOException{
		File directory = new File("");// 参数为空
		String courseFile = directory.getCanonicalPath();		
		String path = courseFile + File.separator + "src" + File.separator + "net" + File.separator + "itaem";
		return path;	
	}

	/**
	 * 创建所有的权限信息
	 * 这里面会扫描所有的controller，然后将GeneratePrivilege注解的信息读取出来，然后保存在数据库中
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * */
	public static void createPrivilege() throws IOException, ClassNotFoundException{
		String path = basePath();
		File directory = new File(path);
		if(directory.isDirectory()){
			File[] children = directory.listFiles();
			for(File child: children){
				File controller = new File(child, "controller");
				if(controller.isDirectory()){
					File[] controllerChildren = controller.listFiles();
					for(File file: controllerChildren){
						if(file.isDirectory()){							
							File[] end = file.listFiles();
							for(File e: end){
								if(e.isDirectory()) continue;
								Class<?> clazz = Class.forName("net.itaem." + child.getName() + "." + controller.getName() + "." + file.getName() + "." + ""+ e.getName().replace(".java", ""));
								generatePrivilege(clazz);
							}
						}else{
							Class<?> clazz = Class.forName("net.itaem." + child.getName() + "." + controller.getName() + "." + ""+ file.getName().replace(".java", ""));
							generatePrivilege(clazz);
						}
					}
				}
			}
			
			//数据数据到数据库中
	        flush();
		}
	}
	
	/**
	 * 记录下所有的权限信息，然后一次性添加到数据库中
	 * @param pri 权限信息
	 * */
	private static void cache(Privilege pri){
		if(priMap.containsKey(pri.type)){
			priMap.get(pri.type).add(pri);
		}else{
			List<Privilege> priList = new ArrayList<Privilege>();
			priList.add(pri);
			priMap.put(pri.type, priList);
		}
	}
	
	/**
	 * 输出数据到数据库中
	 * 这里会删除原来的权限信息
	 * */
	private static void flush(){
		JdbcUtils.init("jdbc:mysql://localhost/luohong_spring", "root", "1234");
		
		//删除原来的权限信息
		JdbcUtils.executeUpdate("delete from sys_privilege");
		
		//直接删除原来的全部权限信息，重新加入
		for(String type: priMap.keySet()){
			String tid = UUIDUtil.uuid();
			System.out.println("插入权限类别：" + type);
			JdbcUtils.executeUpdate("insert into sys_privilege(_id, _name) values('"+tid+"', '"+type+"')");
			
			List<Privilege> priList = priMap.get(type);
			for(Privilege pri: priList){
				
				System.out.println("插入权限信息:" + pri.name + ", " + pri.uri + "," + pri.desc);
				String pid = UUIDUtil.uuid();
				JdbcUtils.executeUpdate("insert into sys_privilege(_id, _parent_id, _name, _url, _desc) values('"+pid+"', '"+tid + "','" + pri.name+"', '"+pri.uri+"', '"+pri.desc+"')");
			}
		}
	}
	
	/**使用map来收集信息*/
	static Map<String, List<Privilege>> priMap = new HashMap<String, List<Privilege>>();
	
	/**
	 * 生成privilege
	 * @param clazz
	 * */
	private static void generatePrivilege(Class<?> clazz){
		Method[] methods = clazz.getMethods();
        for(Method method: methods){
        	GeneratePrivilege gp = null;
        	
        	if((gp = method.getAnnotation(GeneratePrivilege.class)) != null){
        		String name = gp.name();
        		String uri = gp.uri();
        		String type = gp.type();
        		String desc = gp.desc();
        		
        		Privilege pri = new Privilege(type, name, uri, desc);
        		cache(pri);
        	}else{
        		continue;
        	}
        }
	}
	
	
	/**
	 * 内部信使类
	 * */
	static class Privilege{
		public String name;
		public String uri;
		public String desc;
		public String type;
		
		public Privilege(String type, String name, String uri, String desc){
			this.name = name;
			this.type = type;
			this.uri = uri;
			this.desc = desc;
		}
	}
}
