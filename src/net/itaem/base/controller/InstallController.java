package net.itaem.base.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;

import net.itaem.util.JdbcUtils;
import net.itaem.util.JsonUtil;
import net.itaem.util.PropertiesUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * 安装该程序
 * 系统第一次启动时，安装该程序，系统会提示用户输入数据库名与密码，然后进行初始化
 * 第一次初始化完成之后，用户需要重启tomcat
 * @author luohong 15013336884
 * */
@Controller
public class InstallController extends BaseController {
	/**
	 * 跳转到安装界面
	 * 
	 * */
	@RequestMapping("/install.do")
	public String install(){
		Properties properties = PropertiesUtil.getParameters();
		
		JdbcUtils.init(properties.getProperty("database"), properties.getProperty("username"), properties.getProperty("password"));
		
		Connection conn = JdbcUtils.getConnection();
		
		if(conn != null){
		    String sql = "select install from install_info where id=1";
		    try {
		    	Statement statment = conn.createStatement();
				ResultSet rs = statment.executeQuery(sql);
				if(rs.next()){
					int result = rs.getInt(1);
					rs.close();
					statment.close();
					conn.close();
					if(result == 1){
						return "has_installed";
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "install";
	}

	/**
	 * 安装程序
	 * @throws IOException 
	 * */
	@RequestMapping("/installSubmit.do")
	public void installSubmit(String database, String username, String password, HttpServletResponse resp) throws IOException{
		JdbcUtils.init("jdbc:mysql://localhost:3306/" + database, username, password);
		Connection conn = JdbcUtils.getConnection();
		if(conn == null){
			println(resp, JsonUtil.createJson("error", "安装失败，数据库配置以及用户名和密码是否正确"));
			return;
		}
		//将属性写入到/web-inf/mysql.properties文件
		Properties pros = new Properties();
		pros.put("username", username);
		pros.put("database", "jdbc:mysql://localhost:3306/" + database);
		pros.put("password", password);
		PropertiesUtil.setParameters(pros);
		
		//安装数据库
		String path = InstallController.class.getResource("/").getPath();
		String sqlFileName = (path.replace("/build/classes", "").replace("%20"," ").replace("classes/", "") + "luohong_spring.sql").replaceFirst("/", "");
		try {
			JdbcUtils.load(pros, sqlFileName);
			/**
			 * 记录下该程序已经安装，下次访问该界面时，不再进行安装
			 * */
			String sql = "insert into install_info(install) values(1)";
			JdbcUtils.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		println(resp, JsonUtil.createJson("success", "安装成功"));
	}	
}
