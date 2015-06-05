package net.itaem.autogeneratecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import net.itaem.department.entity.Department;

/**
 * 自动代码生成器
 * 1、代码生成器需要做的功能：
 * 给出Entity，生成Mybatics Mapper，生成成Dao层，service层，以及controller层，以及jsp文件
 * 
 * 生成的这些文件中，全部都是骨架代码，开发时需要根据具体要求添加业务逻辑代码即可
 * @author luohong 846705189@qq.com 15013336884
 * */
public class AutomaticGenerateCode {
    
	public static void main(String[] args) throws IOException{
		generateMybaticsMapper(Department.class);
		generateDao(Department.class);
		generateService(Department.class);
		generateController(Department.class);
		generateJsp(Department.class);	
	}

	/**
	 * 生成mybatics的mapper类
	 * @param clazz
	 * */
	public static void generateMybaticsMapper(Class<?> clazz) throws IOException{
		String path = path(clazz);
		String mapperDirectoryName = path.substring(0, path.lastIndexOf("\\")) + File.separator + "entity";
		File mapperDirectory = new File(mapperDirectoryName);
		if(!mapperDirectory.exists()){
			mapperDirectory.mkdir();
		}

		String mapperJavaFileName = mapperDirectory.getCanonicalPath() + File.separator + clazz.getSimpleName() + "Mapper.java";
		File mapperJavaFile = new File(mapperJavaFileName);
		StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append("package net.itaem." + clazz.getSimpleName().toLowerCase() + ".entity;");
		contentBuilder.append("\n\n");
		contentBuilder.append("import java.util.*;\n");
		contentBuilder.append("import org.apache.ibatis.annotations.Insert;\n");
		contentBuilder.append("import org.apache.ibatis.annotations.Select;\n");
		contentBuilder.append("import org.apache.ibatis.annotations.Results;\n");
		contentBuilder.append("import org.springframework.stereotype.Repository;\n");
		contentBuilder.append("import org.apache.ibatis.annotations.Update;\n");
		contentBuilder.append("\n\n");
		contentBuilder.append("");

		contentBuilder.append("@Repository(value = \"" + clazz.getSimpleName().substring(0, 1).toLowerCase() + clazz.getSimpleName().substring(1) + "Mapper\"" + ")\n");
		contentBuilder.append("public interface " + clazz.getSimpleName() + "Mapper"+"{\n\n");
		contentBuilder.append("    @Select(value = \"请替换成您需要的sql\")\n");
		contentBuilder.append("    @Results(value = {})\n");
		contentBuilder.append("    public List<"+clazz.getSimpleName()+"> listAll();");
		contentBuilder.append("\n\n");

		contentBuilder.append("    @Select(value = \"请替换成您需要的sql\")\n");
		contentBuilder.append("    @Results(value = {})\n");
		contentBuilder.append("    public "+clazz.getSimpleName()+" listBy(String id);");
		contentBuilder.append("\n\n");

		contentBuilder.append("    @Insert(\"\")\n");
		contentBuilder.append("    public void add(" + clazz.getSimpleName().substring(0,1).toUpperCase() + clazz.getSimpleName().substring(1) + " " + clazz.getSimpleName() + ");");
		contentBuilder.append("\n\n");

		contentBuilder.append("    @Update(\"\")\n");
		contentBuilder.append("    public void delete(String id);");
		contentBuilder.append("\n\n");

		contentBuilder.append("    @Update(\"\")\n");
		contentBuilder.append("    public void update(" + clazz.getSimpleName().substring(0,1).toUpperCase() + clazz.getSimpleName().substring(1) + " " + clazz.getSimpleName() + ");");
		contentBuilder.append("\n}");
		println(mapperJavaFile, contentBuilder.toString());
	}

	/**
	 * 生成Dao代码
	 * @param clazz
	 * */
	public static void generateDao(Class<?> clazz) throws IOException{
		generateDaoInterface(clazz);
		generateDaoImplement(clazz);	
	}

	private static void generateDaoInterface(Class<?> clazz) throws IOException{
		String path = path(clazz);
		String daoDirectoryName = path.substring(0, path.lastIndexOf("\\")) + File.separator + "dao";
		File daoDirectory = new File(daoDirectoryName);
		if(!daoDirectory.exists()){
			daoDirectory.mkdir();
		}
		String daoJavaFileName = daoDirectory.getCanonicalPath() + File.separator + "I" + clazz.getSimpleName() + "Dao.java";
		File daoJavaFile = new File(daoJavaFileName);
		StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append("package net.itaem." + clazz.getSimpleName().toLowerCase() + ".dao;");
		contentBuilder.append("\n\n");
		contentBuilder.append("import java.util.*;\n");
		contentBuilder.append("import net.itaem." + clazz.getSimpleName().toLowerCase() + ".entity." + clazz.getSimpleName() + ";\n");
		contentBuilder.append("\n\n");
		contentBuilder.append("");
		contentBuilder.append("public interface "+"I" + clazz.getSimpleName() + "Dao"+"{\n\n");
		contentBuilder.append("    public List<"+clazz.getSimpleName()+"> listAll();");
		contentBuilder.append("\n\n");
		contentBuilder.append("    public "+clazz.getSimpleName()+" listBy(String id);");
		contentBuilder.append("\n\n");
		contentBuilder.append("    public void add(" + clazz.getSimpleName().substring(0,1).toUpperCase() + clazz.getSimpleName().substring(1) + " " + clazz.getSimpleName() + ");");
		contentBuilder.append("\n\n");
		contentBuilder.append("    public void delete(String id);");
		contentBuilder.append("\n\n");
		contentBuilder.append("    public void update(" + clazz.getSimpleName().substring(0,1).toUpperCase() + clazz.getSimpleName().substring(1) + " " + clazz.getSimpleName() + ");");
		contentBuilder.append("\n}");
		println(daoJavaFile, contentBuilder.toString());
	}

	private static void generateDaoImplement(Class<?> clazz) throws IOException {
		String path = path(clazz);
		String daoDirectoryName = path.substring(0, path.lastIndexOf("\\")) + File.separator + "dao" + File.separator + "impl";

		File daoDirectory = new File(daoDirectoryName);
		if(!daoDirectory.exists()){
			daoDirectory.mkdir();
		}

		String daoJavaFileName = daoDirectory.getCanonicalPath() + File.separator + clazz.getSimpleName() + "DaoImpl.java";

		File daoJavaFile = new File(daoJavaFileName);
		StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append("package net.itaem." + clazz.getSimpleName().toLowerCase() + ".dao.impl;");
		contentBuilder.append("\n\n");
		contentBuilder.append("import java.util.*;\n");
		contentBuilder.append("import net.itaem." + clazz.getSimpleName().toLowerCase() + ".entity." + clazz.getSimpleName() + ";\n");
		contentBuilder.append("import net.itaem." + clazz.getSimpleName().toLowerCase() + ".dao.I" + clazz.getSimpleName() + "Dao" + ";\n");
		contentBuilder.append("import net.itaem." + clazz.getSimpleName().toLowerCase() + ".entity." + clazz.getSimpleName() + "Mapper" + ";\n");

		contentBuilder.append("import org.springframework.stereotype.Repository;\n");
		contentBuilder.append("import javax.annotation.Resource;\n");

		contentBuilder.append("\n\n");
		contentBuilder.append("");

		contentBuilder.append("@Repository\n");
		contentBuilder.append("public class "+ clazz.getSimpleName() + "DaoImpl implements I" + clazz.getSimpleName() + "Dao" +"{\n\n");

		String mapperName = clazz.getSimpleName().substring(0, 1).toLowerCase() + clazz.getSimpleName().substring(1) + "Mapper";
		contentBuilder.append("    @Resource(name = \"" + mapperName + "\")\n");
		contentBuilder.append("    private " + clazz.getSimpleName() + "Mapper " + mapperName + ";\n\n");
		contentBuilder.append("    public List<"+clazz.getSimpleName()+"> listAll(){\n");
		contentBuilder.append("        return " + mapperName+ ".listAll()" + ";");
		contentBuilder.append("\n    }\n\n");

		contentBuilder.append("    public "+clazz.getSimpleName()+" listBy(String id){\n");
		contentBuilder.append("        return " + mapperName + ".listBy(id)" + ";");
		contentBuilder.append("\n    }\n\n");

		contentBuilder.append("    public void add(" + clazz.getSimpleName() + " " + clazz.getSimpleName().substring(0,1).toLowerCase() + clazz.getSimpleName().substring(1) + "){\n");
		contentBuilder.append("        " + mapperName + ".add(" + clazz.getSimpleName().substring(0,1).toLowerCase() + clazz.getSimpleName().substring(1) + ");" + "");
		contentBuilder.append("\n    }\n\n");

		contentBuilder.append("    public void delete(String id){\n");
		contentBuilder.append("        " + mapperName + ".delete(id);");
		contentBuilder.append("\n    }\n\n");

		contentBuilder.append("    public void update(" + clazz.getSimpleName() + " " + clazz.getSimpleName().substring(0,1).toLowerCase() + clazz.getSimpleName().substring(1) + "){\n");
		contentBuilder.append("        " + mapperName + ".update(" + clazz.getSimpleName().substring(0,1).toLowerCase() + clazz.getSimpleName().substring(1) + ");" + "");
		contentBuilder.append("\n    }\n");
		contentBuilder.append("}");
		println(daoJavaFile, contentBuilder.toString());
	}

	/**
	 * 生成Service代码
	 * @param clazz
	 * */
	public static void generateService(Class<?> clazz) throws IOException{
		generateServiceInterface(clazz);
		generateServiceImplement(clazz);	
	}

	private static void generateServiceInterface(Class<?> clazz) throws IOException{
		String path = path(clazz);
		String serviceDirectoryName = path.substring(0, path.lastIndexOf("\\")) + File.separator + "service";
		File serviceDirectory = new File(serviceDirectoryName);
		if(!serviceDirectory.exists()){
			serviceDirectory.mkdir();
		}
		String serviceJavaFileName = serviceDirectory.getCanonicalPath() + File.separator + "I" + clazz.getSimpleName() + "Service.java";
		File serviceJavaFile = new File(serviceJavaFileName);
		StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append("package net.itaem." + clazz.getSimpleName().toLowerCase() + ".service;");
		contentBuilder.append("\n\n");
		contentBuilder.append("import java.util.*;\n");
		contentBuilder.append("import net.itaem." + clazz.getSimpleName().toLowerCase() + ".entity." + clazz.getSimpleName() + ";\n");
		contentBuilder.append("\n\n");
		contentBuilder.append("");
		contentBuilder.append("public interface "+"I" + clazz.getSimpleName() + "Service"+"{\n\n");
		contentBuilder.append("    public List<"+clazz.getSimpleName()+"> listAll();");
		contentBuilder.append("\n\n");
		contentBuilder.append("    public "+clazz.getSimpleName()+" listBy(String id);");
		contentBuilder.append("\n\n");
		contentBuilder.append("    public void add(" + clazz.getSimpleName().substring(0,1).toUpperCase() + clazz.getSimpleName().substring(1) + " " + clazz.getSimpleName() + ");");
		contentBuilder.append("\n\n");
		contentBuilder.append("    public void delete(String id);");
		contentBuilder.append("\n\n");
		contentBuilder.append("    public void update(" + clazz.getSimpleName().substring(0,1).toUpperCase() + clazz.getSimpleName().substring(1) + " " + clazz.getSimpleName() + ");");
		contentBuilder.append("\n}");
		println(serviceJavaFile, contentBuilder.toString());
	}

	private static void generateServiceImplement(Class<?> clazz) throws IOException {
		String path = path(clazz);
		String serviceDirectoryName = path.substring(0, path.lastIndexOf("\\")) + File.separator + "service" + File.separator + "impl";

		File serviceDirectory = new File(serviceDirectoryName);
		if(!serviceDirectory.exists()){
			serviceDirectory.mkdir();
		}

		String serviceJavaFileName = serviceDirectory.getCanonicalPath() + File.separator + clazz.getSimpleName() + "ServiceImpl.java";

		File daoJavaFile = new File(serviceJavaFileName);
		StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append("package net.itaem." + clazz.getSimpleName().toLowerCase() + ".service.impl;");
		contentBuilder.append("\n\n");
		contentBuilder.append("import java.util.*;\n");
		contentBuilder.append("import net.itaem." + clazz.getSimpleName().toLowerCase() + ".entity." + clazz.getSimpleName() + ";\n");
		contentBuilder.append("import net.itaem." + clazz.getSimpleName().toLowerCase() + ".service.I" + clazz.getSimpleName()+ "Service" + ";\n");
		contentBuilder.append("import net.itaem." + clazz.getSimpleName().toLowerCase() + ".dao.I" + clazz.getSimpleName()+ "Dao" + ";\n");
		contentBuilder.append("import org.springframework.stereotype.Service;\n");
		contentBuilder.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		contentBuilder.append("\n\n");

		contentBuilder.append("@Service\n");
		contentBuilder.append("public class "+ clazz.getSimpleName() + "ServiceImpl implements I" + clazz.getSimpleName() + "Service" + "{\n\n");
		String daoName = clazz.getSimpleName().substring(0,1).toLowerCase() + clazz.getSimpleName().substring(1) + "Dao";
		contentBuilder.append("    @Autowired\n");
		contentBuilder.append("    private I" + clazz.getSimpleName() + "Dao " + daoName + ";\n\n");

		contentBuilder.append("    public List<"+clazz.getSimpleName()+"> listAll(){\n");
		contentBuilder.append("        return " + daoName + ".listAll()" + ";");
		contentBuilder.append("\n    }\n\n");

		contentBuilder.append("    public "+clazz.getSimpleName()+" listBy(String id){\n");
		contentBuilder.append("        return " + daoName + ".listBy(id)" + ";");
		contentBuilder.append("\n    }\n\n");

		String arg = clazz.getSimpleName().substring(0,1).toLowerCase() + clazz.getSimpleName().substring(1);
		contentBuilder.append("    public void add(" + clazz.getSimpleName() + " " + arg + "){\n");
		contentBuilder.append("        " + daoName + ".add(" + arg + ");");
		contentBuilder.append("\n    }\n\n");
		contentBuilder.append("    public void delete(String id){\n");
		contentBuilder.append("       "+daoName +".delete(id);");
		contentBuilder.append("\n    }\n\n");
		contentBuilder.append("    public void update(" + clazz.getSimpleName() + " " + arg + "){\n");
		contentBuilder.append("        "+daoName+".update(" + arg + ");");
		contentBuilder.append("\n    }\n");
		contentBuilder.append("}");
		println(daoJavaFile, contentBuilder.toString());
	}

	/**
	 * 生成controller代码
	 * @param clazz
	 * */
	public static void generateController(Class<?> clazz) throws IOException{
		String path = path(clazz);
		String controllerDirectoryName = path.substring(0, path.lastIndexOf("\\")) + File.separator + "controller";
		File controllerDirectory = new File(controllerDirectoryName);
		if(!controllerDirectory.exists()){
			controllerDirectory.mkdir();
		}

		//generate add controller
		String controllerJavaFileName = controllerDirectory.getCanonicalPath() + File.separator + clazz.getSimpleName() + "AddController.java";
		File controllerJavaFile = new File(controllerJavaFileName);
		StringBuilder contentBuilder = new StringBuilder();
		contentBuilder.append("package net.itaem." + clazz.getSimpleName().toLowerCase() + ".controller;");
		contentBuilder.append("\n\n");
		contentBuilder.append("import net.itaem." + clazz.getSimpleName().toLowerCase() + ".entity." + clazz.getSimpleName() + ";\n");
		contentBuilder.append("import net.itaem."+ clazz.getSimpleName().toLowerCase() + ".service.I" + clazz.getSimpleName() + "Service;\n");
		contentBuilder.append("import javax.servlet.http.HttpServletRequest;\n");
		contentBuilder.append("import javax.servlet.http.HttpServletResponse;\n");
		contentBuilder.append("import org.springframework.stereotype.Controller;");
		contentBuilder.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		contentBuilder.append("import org.springframework.web.bind.annotation.RequestMapping;\n");

		contentBuilder.append("\n\n");
		contentBuilder.append("");
		contentBuilder.append("@Controller\n");
		contentBuilder.append("public class "+ clazz.getSimpleName() + "AddController"+"{\n\n");
		String serviceName = clazz.getSimpleName().substring(0, 1).toLowerCase() + clazz.getSimpleName().substring(1) + "Service";
		contentBuilder.append("    @Autowired\n");
		contentBuilder.append("    private I" + clazz.getSimpleName() + "Service " + serviceName + ";\n\n");

		contentBuilder.append("    @RequestMapping(\"/" + clazz.getSimpleName().toLowerCase() + "/add.do\")\n");
		contentBuilder.append("    public String add(HttpServletRequest req){\n");
		contentBuilder.append("        return \"" + clazz.getSimpleName().toLowerCase() + "/add\";\n");
		contentBuilder.append("    }\n\n");

		contentBuilder.append("    @RequestMapping(\"/" + clazz.getSimpleName().toLowerCase() + "/addSubmit.do\")\n");
		contentBuilder.append("    public void addSubmit(" + clazz.getSimpleName() + " " + clazz.getSimpleName().substring(0, 1).toLowerCase() + clazz.getSimpleName().substring(1) + ", HttpServletRequest req, HttpServletResponse resp){\n");
		contentBuilder.append("    }\n");

		contentBuilder.append("\n}");
		println(controllerJavaFile, contentBuilder.toString());

		//clear content builder;
		contentBuilder = new StringBuilder();

		//generate delete controller
		controllerJavaFileName = controllerDirectory.getCanonicalPath() + File.separator + clazz.getSimpleName() + "DeleteController.java";
		controllerJavaFile = new File(controllerJavaFileName);
		contentBuilder = new StringBuilder();
		contentBuilder.append("package net.itaem." + clazz.getSimpleName().toLowerCase() + ".controller;");
		contentBuilder.append("\n\n");
		contentBuilder.append("import net.itaem." + clazz.getSimpleName().toLowerCase() + ".entity." + clazz.getSimpleName() + ";\n");
		contentBuilder.append("import net.itaem."+ clazz.getSimpleName().toLowerCase() + ".service.I" + clazz.getSimpleName() + "Service;\n");
		contentBuilder.append("import javax.servlet.http.HttpServletRequest;\n");
		contentBuilder.append("import javax.servlet.http.HttpServletResponse;\n");
		contentBuilder.append("import org.springframework.stereotype.Controller;");
		contentBuilder.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		contentBuilder.append("import org.springframework.web.bind.annotation.RequestMapping;\n");

		contentBuilder.append("\n\n");
		contentBuilder.append("");
		contentBuilder.append("@Controller\n");
		contentBuilder.append("public class "+ clazz.getSimpleName() + "DeleteController"+"{\n\n");
		contentBuilder.append("    @Autowired\n");
		contentBuilder.append("    private I" + clazz.getSimpleName() + "Service " + serviceName + ";\n\n");

		contentBuilder.append("    @RequestMapping(\"/" + clazz.getSimpleName().toLowerCase() + "/delete.do\")\n");
		contentBuilder.append("    public void delete(HttpServletResponse resp){\n");
		contentBuilder.append("    }\n\n");

		contentBuilder.append("\n}");
		println(controllerJavaFile, contentBuilder.toString());

		//clear content builder;
		contentBuilder = new StringBuilder();

		//generate update controller
		controllerJavaFileName = controllerDirectory.getCanonicalPath() + File.separator + clazz.getSimpleName() + "UpdateController.java";
		controllerJavaFile = new File(controllerJavaFileName);
		contentBuilder = new StringBuilder();
		contentBuilder.append("package net.itaem." + clazz.getSimpleName().toLowerCase() + ".controller;");
		contentBuilder.append("\n\n");
		contentBuilder.append("import net.itaem." + clazz.getSimpleName().toLowerCase() + ".entity." + clazz.getSimpleName() + ";\n");
		contentBuilder.append("import net.itaem."+ clazz.getSimpleName().toLowerCase() + ".service.I" + clazz.getSimpleName() + "Service;\n");
		contentBuilder.append("import javax.servlet.http.HttpServletRequest;\n");
		contentBuilder.append("import javax.servlet.http.HttpServletResponse;\n");
		contentBuilder.append("import org.springframework.stereotype.Controller;");
		contentBuilder.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		contentBuilder.append("import org.springframework.web.bind.annotation.RequestMapping;\n");

		contentBuilder.append("\n\n");
		contentBuilder.append("");
		contentBuilder.append("@Controller\n");
		contentBuilder.append("public class "+ clazz.getSimpleName() + "UpdateController"+"{\n\n");
		contentBuilder.append("    @Autowired\n");
		contentBuilder.append("    private I" + clazz.getSimpleName() + "Service " + serviceName + ";\n\n");

		contentBuilder.append("    @RequestMapping(\"/" + clazz.getSimpleName().toLowerCase() + "/update.do\")\n");
		contentBuilder.append("    public String update(HttpServletRequest req){\n");
		contentBuilder.append("        return \"" + clazz.getSimpleName().toLowerCase() + "/update\";\n");
		contentBuilder.append("    }\n\n");

		contentBuilder.append("    @RequestMapping(\"/" + clazz.getSimpleName().toLowerCase() + "/updateSubmit.do\")\n");
		contentBuilder.append("    public void updateSubmit(" + clazz.getSimpleName() + " " + clazz.getSimpleName().substring(0, 1).toLowerCase() + clazz.getSimpleName().substring(1) + ", HttpServletRequest req, HttpServletResponse resp){\n");
		contentBuilder.append("    }\n");

		contentBuilder.append("\n}");
		println(controllerJavaFile, contentBuilder.toString());

		//clear content builder;
		contentBuilder = new StringBuilder();

		//generate list controller
		controllerJavaFileName = controllerDirectory.getCanonicalPath() + File.separator + clazz.getSimpleName() + "ListController.java";
		controllerJavaFile = new File(controllerJavaFileName);
		contentBuilder = new StringBuilder();
		contentBuilder.append("package net.itaem." + clazz.getSimpleName().toLowerCase() + ".controller;");
		contentBuilder.append("\n\n");
		contentBuilder.append("import net.itaem." + clazz.getSimpleName().toLowerCase() + ".entity." + clazz.getSimpleName() + ";\n");
		contentBuilder.append("import net.itaem."+ clazz.getSimpleName().toLowerCase() + ".service.I" + clazz.getSimpleName() + "Service;\n");
		contentBuilder.append("import javax.servlet.http.HttpServletRequest;\n");
		contentBuilder.append("import javax.servlet.http.HttpServletResponse;\n");
		contentBuilder.append("import org.springframework.stereotype.Controller;");
		contentBuilder.append("import org.springframework.beans.factory.annotation.Autowired;\n");
		contentBuilder.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
		contentBuilder.append("\n\n");
		contentBuilder.append("");
		contentBuilder.append("@Controller\n");
		contentBuilder.append("public class "+ clazz.getSimpleName() + "ListController"+"{\n\n");
		contentBuilder.append("    @Autowired\n");
		contentBuilder.append("    private I" + clazz.getSimpleName() + "Service " + serviceName + ";\n\n");

		contentBuilder.append("    @RequestMapping(\"/" + clazz.getSimpleName().toLowerCase() + "/list.do\")\n");
		contentBuilder.append("    public String list(HttpServletRequest req){\n");
		contentBuilder.append("        return \"" + clazz.getSimpleName().toLowerCase() + "/list\";\n");
		contentBuilder.append("    }\n\n");

		contentBuilder.append("    @RequestMapping(\"/" + clazz.getSimpleName().toLowerCase() + "/listJson.do\")\n");
		contentBuilder.append("    public void listJson(HttpServletResponse resp){\n");
		contentBuilder.append("    }\n\n");

		contentBuilder.append("\n}");
		println(controllerJavaFile, contentBuilder.toString());
	}

	/**
	 * 生成jsp界面，这里面一共有三个jsp，分别是add.jsp, update.jsp, list.jsp
	 * */
	public static void generateJsp(Class<?> clazz) throws IOException{
		File directory = new File("");// 参数为空
		String courseFile = directory.getCanonicalPath();
		String jspRoot = courseFile + File.separator + "WebContent" + File.separator + "WEB-INF" + File.separator + "jsp";
		String newJspPath = jspRoot + File.separator + clazz.getSimpleName().toLowerCase();
		File newJspDirectory = new File(newJspPath);
		if(!newJspDirectory.exists()){
			newJspDirectory.mkdir();
		}

		String patternPath = jspRoot + File.separator + "pattern";

		//将pattern下面的模板jsp文件复制到这个新建立的文件夹中
		copyJsp(patternPath, newJspPath);
	}

	/**
	 * copy置顶文件夹下面的文件夹到新文件夹中
	 * @param src
	 * @param dest
	 * */
	private static void copyJsp(String src, String dest){
		File srcFile = new File(src);
		if(srcFile.exists()){
			File[] files = srcFile.listFiles();
			for(File from: files){
				try {   
					String to = dest + File.separator + from.getName();
					File toFile = new File(to);
					//如果该文件存在，不要进行复制
					if(toFile.exists()){
						continue;
					}
					
					InputStream in = new FileInputStream(from);   
					OutputStream out = new FileOutputStream(to);   

					byte[] buff = new byte[1024];   
					int len = 0;   
					while ((len = in.read(buff)) != -1) {   
						out.write(buff, 0, len);   
					}   
					in.close();   
					out.close();   
				} catch (FileNotFoundException e) {   
					e.printStackTrace();   
				} catch (IOException e) {   
					e.printStackTrace();   
				}   
			}
		}
	}
	/**
	 * 获取该类的文件夹所在位置
	 * @param clazz 
	 * @return 获取该类的文件夹所在位置 
	 * */
	public static String path(Class<?> clazz) throws IOException{
		File directory = new File("");// 参数为空
		String courseFile = directory.getCanonicalPath();		
		String packageName = clazz.getPackage().getName();
		String newPackageName = courseFile + File.separator + "src" + File.separator + packageName.replace(".", File.separator);
		return newPackageName;	
	}

	public static void println(File file, String content){
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(file);
			writer.write(content);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally{
			writer.close();
		}
	}
}
