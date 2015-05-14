package net.itaem.util;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import net.itaem.base.controller.InstallController;

/**
 * 读取、设置属性文件工具类
 * @author 骆宏 15013336884 846705189@qq.com
 * */
public class PropertiesUtil {

	/**
	 * 设置/WEB-INF下面的属性文件
	 * @param properties 属性文件内容
	 * @throws IOException 
	 * */
	public static void setParameters(Properties properties){
		String path = InstallController.class.getResource("/").getPath();
		String websiteURL = (path.replace("/build/classes", "").replace("%20"," ").replace("classes/", "") + "mysql.properties").replaceFirst("/", "");
		FileWriter writer = null;
		try {
			writer = new FileWriter(websiteURL);
			writer.write("username=" + properties.getProperty("username") + "\n");
			writer.write("password=" + properties.getProperty("password") + "\n");
			writer.write("database=" + properties.getProperty("database"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取/WEB-INF下面的属性文件，使用Map返回
	 * @return mysql.properties文件内容
	 * */
	public static Properties getParameters() {
		String path = InstallController.class.getResource("/").getPath();
		String websiteURL = (path.replace("/build/classes", "").replace("%20"," ").replace("classes/", "") + "mysql.properties").replaceFirst("/", "");
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(websiteURL);
			properties.load(fileInputStream);

			return properties;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
}
