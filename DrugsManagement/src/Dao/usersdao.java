package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Objective.users;
import base.BaseDao;

/**
 * @author cadenwuye 2019-5.28
 */

/*
 * 模块说明：用户的增删查改
 * 
 */
public class usersdao extends BaseDao {

	private static usersdao us;
	private users user;
	private final int fieldNum = 13;
	private final int showNum = 15;

	// 获取用户实例
	public static synchronized usersdao getInstance() {
		if (us == null) {
			us = new usersdao();
		}
		return us;
	}

	// 用户登录时查询密码账号,返回一个字符串，不同字符串权限不同
	public String queryLogin(String name, String password) {
		ResultSet rs = null;
		String s = null;
		String sql = "select ygjs from users where name=? and password=?";
		String[] param = { name, password };
		rs = db.executeQuery(sql, param);
		try {
			while (rs.next()) {
				s = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	// 用户删除
	public boolean delete(users ur) {
		boolean result = false;
		if (ur == null) {
			return result;
		}
		String sql = "delete from users where id=? ";
		Object[] param = { ur.getId() };
		int rowCount = db.executeUpdate(sql, param);
		if (rowCount == 1) {
			result = true;
		}
		destroy();
		return result;
	}

	// 用户查询
	public users queryByName(int id) throws SQLException {
		ResultSet rs = null;
		user = null;

		String checkSql = "select * from users where id= " + id;
		rs = db.executeQuery(checkSql);
		if (rs != null) {
			try {
				while (rs.next()) {
					user = new users();
					user.setId(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setPassword(rs.getString(3));
					user.setSex(rs.getString(4));
					user.setType(rs.getString(5));
				}

			} catch (SQLException se) {
				se.printStackTrace();
			} finally {
				db.close();

			}
		}

		return user;
	}

	// 用户注册
	// add drugs by keyboard
	public boolean add(users user) {
		boolean result = false;
		if (user == null)
			return result;
		try {
			if ((us.queryByName(user.getId())) != null) {// name存在
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql = "insert into users (id,name,password,sex,ygjs) values (?,?,?,?,?);";
		Object[] obj = { user.getId(), user.getName(), user.getPassword(), user.getSex(), user.getType() };
		if (db.executeUpdate(sql, obj) == 1) {
			result = true;
		}
		return result;
	}

	// query all
	public String[][] list(int pageNum) {
		String[][] result = null;
		if (pageNum < 1) {
			return result;
		}
		List<users> drs = new ArrayList<users>();
		int i = 0;
		int beginNum = (pageNum - 1) * showNum;
		String sql = "select * from users limit ?,?";
		Integer[] param = { beginNum, showNum };
		rs = db.executeQuery(sql, param);
		try {
			while (rs.next()) {
				buildList(rs, drs, i);
				i++;
			}
			if (drs.size() > 0) {
				result = new String[drs.size()][fieldNum];
				for (int j = 0; j < drs.size(); j++) {
					buildResult(result, drs, j);
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}

		return result;
	}

	// 将rs记录添加到list中
	private void buildList(ResultSet rs, List<users> list, int i) throws SQLException {
		users drs = new users();
		drs.setId(rs.getInt("id"));
		drs.setName(rs.getString("name"));
		drs.setPassword(rs.getString("password"));
		drs.setType(rs.getString("ygjs"));
		drs.setSex(rs.getString("sex"));
		list.add(drs);
	}

	// 将list中记录添加到二维数组中
	private void buildResult(String[][] result, List<users> drs, int j) {
		users dr = drs.get(j);
		result[j][0] = String.valueOf(dr.getId());
		result[j][1] = dr.getName();
		result[j][2] = dr.getPassword();
		result[j][3] = dr.getType();
		result[j][4] = dr.getSex();
	}
}
