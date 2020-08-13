/*
 * 项目名：药房管理系统
 * @吴冶
 * 创建时间：2019年5月27日上午
 */

package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.AppConstants;

/*
 * 模块说明：数据库工具类
 * 一般操作步骤：
 * 1.加载外部驱动程序（jar包）
 * 2.正式加载驱动程序（class.forName(driverName)）
 * 3.获取connection连接（Drivermanager.getconnection()）
 * 4.创建SQL语句声明，执行SQL语句
 * (以下是四种语句声明，执行的方式)
 * 5.关闭数据库
 * 
 * */
public class DBUtil {

	private static DBUtil db;
	private Connection conn = null;
	private PreparedStatement ps;// jdbc 语句
	private ResultSet rs;// 语句返回的结果集

	private DBUtil() {
		// 工具类一般使用单例模式
	}

	// 获取静态实例
	public static DBUtil getDBUtil() {
		if (db == null) {
			db = new DBUtil();
		}
		return db;
	}

	// 执行sql语句（Insert，delete）
	public int executeUpdate(String sql) {
		int result = -1;
		if (getConn() == null) {
			return result;
		}
		try {
			ps = conn.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int executeUpdate(String sql, Object[] obj) {
		int result = -1;
		if (getConn() == null) {
			return result;
		}
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
			result = ps.executeUpdate();

			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 执行查询语句
	public ResultSet executeQuery(String sql) {
		if (getConn() == null) {
			return null;
		}
		try {
			ps = conn.prepareStatement(sql);// 创建preparestatment对象
			rs = ps.executeQuery();// 执行结果集
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public ResultSet executeQuery(String sql, Object[] obj) {
		if (getConn() == null) {
			return null;
		}
		try {
			ps = conn.prepareStatement(sql);// 创建statement对象
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
			rs = ps.executeQuery();// 执行结果集
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	// 连接数据库操作
	private Connection getConn() {
		try {
			if (conn == null || conn.isClosed()) {
				// 如果未连接数据库，重新连接数据库
				Class.forName(AppConstants.JDBC_DRIVER);// classloader加载对应驱动
				conn = DriverManager.getConnection(AppConstants.JDBC_URL, AppConstants.JDBC_USERNAME,
						Util.AppConstants.JDBC_PASSWORD);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver is not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 关闭数据库
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
