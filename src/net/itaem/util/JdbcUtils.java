package net.itaem.util ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 
 * Jdbc工具类
 * 目前仅支持
 * 		Integer/int
 * 		String
 * 		Float/float
 * 		Double/double
 * 		Date(java.util.Date/java.sql.Date)
 * 		其他可变类型和批量执行请自行添加
 * @author sen
 * @version 1.0,2015.03.18
 * @version 1.1,2015.03.19
 * 	①将不该抛出的异常try...catch
 *  ②添加了sql直接运行方法，一般用于创建表
 */
public class JdbcUtils {
	private static String url = null;
	private static String username = null;
	private static String password = null;

	/**
	 * 必须要初始化
	 * */
	public static void init(String url, String username, String password){
		JdbcUtils.url = url;
		JdbcUtils.username = username;
		JdbcUtils.password = password;
	}

	/**
	 * 
	 * 获取连接 
	 * @author sen
	 * @version 1.0,2015年3月18日
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void create(String createTableSql) throws SQLException{
		Connection conn = getConnection();
		Statement stat = conn.createStatement();
		stat.executeUpdate(createTableSql);
		stat.close();
		conn.close();
	}

	/**
	 * 
	 * 判断表是否存在 
	 * @author sen
	 * @version 1.0,2015年3月18日
	 * @param tableName
	 * @return
	 * @throws SQLException
	 */
	public static boolean isExist(String tableName) {
		Connection conn = getConnection() ;
		DatabaseMetaData meta;
		try {
			meta = conn.getMetaData();
			ResultSet rs = meta.getTables(null, null, tableName, null) ;
			return rs.next() ;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false ;
	}

	/**
	 * 
	 * 执行更新的sql语句 
	 * 该方法一般用于创建表
	 * @author sen
	 * @version 1.1,2015年3月19日
	 * @param sql
	 * @return
	 */
	public static int executeUpdate(String sql) {
		Connection conn = getConnection() ;
		PreparedStatement pre = null;
		try {
			pre = conn.prepareStatement(sql);
			return pre.executeUpdate() ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				pre.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0 ;
	}

	/**
	 * 将某个sql文件直接调用mysql命令来执行插入
	 * @param properties mysql配置文件，指定数据库，username，password
	 * @param fileName sql文件所在路径
	 * 
	 * @throws IOException 
	 * @throws SQLException 
	 * */
	public static void load(Properties sqlPropertis, String fileName) throws IOException, SQLException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		//读取sql文件
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = reader.readLine()) != null){
			sb.append(line);
		}
		
		JdbcUtils.init(sqlPropertis.getProperty("database"), sqlPropertis.getProperty("username"), sqlPropertis.getProperty("password"));
		//使用;分割成sql语句
		String[] sqls = sb.toString().split(";");
		Connection conn = JdbcUtils.getConnection();
		
		//取消自动提交模式
		conn.setAutoCommit(false);
		Statement stat = conn.createStatement();
		for(String sql: sqls){
			if(sql == null && "".equals(sql)){
				continue;
			}
			stat.addBatch(sql);
		}		
		stat.executeBatch();
		conn.commit();
		reader.close();
	}
}
