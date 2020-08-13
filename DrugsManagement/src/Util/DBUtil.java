/*
 * ��Ŀ����ҩ������ϵͳ
 * @��ұ
 * ����ʱ�䣺2019��5��27������
 */

package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Util.AppConstants;

/*
 * ģ��˵�������ݿ⹤����
 * һ��������裺
 * 1.�����ⲿ��������jar����
 * 2.��ʽ������������class.forName(driverName)��
 * 3.��ȡconnection���ӣ�Drivermanager.getconnection()��
 * 4.����SQL���������ִ��SQL���
 * (�������������������ִ�еķ�ʽ)
 * 5.�ر����ݿ�
 * 
 * */
public class DBUtil {

	private static DBUtil db;
	private Connection conn = null;
	private PreparedStatement ps;// jdbc ���
	private ResultSet rs;// ��䷵�صĽ����

	private DBUtil() {
		// ������һ��ʹ�õ���ģʽ
	}

	// ��ȡ��̬ʵ��
	public static DBUtil getDBUtil() {
		if (db == null) {
			db = new DBUtil();
		}
		return db;
	}

	// ִ��sql��䣨Insert��delete��
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

	// ִ�в�ѯ���
	public ResultSet executeQuery(String sql) {
		if (getConn() == null) {
			return null;
		}
		try {
			ps = conn.prepareStatement(sql);// ����preparestatment����
			rs = ps.executeQuery();// ִ�н����
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
			ps = conn.prepareStatement(sql);// ����statement����
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i + 1, obj[i]);
			}
			rs = ps.executeQuery();// ִ�н����
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rs;
	}

	// �������ݿ����
	private Connection getConn() {
		try {
			if (conn == null || conn.isClosed()) {
				// ���δ�������ݿ⣬�����������ݿ�
				Class.forName(AppConstants.JDBC_DRIVER);// classloader���ض�Ӧ����
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

	// �ر����ݿ�
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
