package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Objective.drugs;
import base.BaseDao;

/**
 * @author cadenwuye 2019-5-28
 */

/*
 * 模块说明：药品的增删查改
 * 
 */

public class drugsDao extends BaseDao {
	private final int fieldNum = 13;
	private final int showNum = 15;
	private static drugsDao dr = null;
	private drugs dr2;

	// 获取drugsDao实例对象
	public static synchronized drugsDao getInstance() {
		if (dr == null) {
			dr = new drugsDao();
		}
		return dr;
	}

	// add drugs by keyboard
	public boolean add(drugs dr2) {

		boolean result = false;
		if (dr2 == null)
			return result;
		try {
			if ((dr.queryById(dr2.getId())) != null) {// id存在

				return result;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		String sql = "insert into drugs (id,name,jianma,type,genralname,unit,norms,approvalnum, period,minstock,products,bid,price) values (?,?,?,?,?,?,?,?,?,?,?,?,?);";
		Object[] obj = { dr2.getId(), dr2.getName(), dr2.getJianma(), dr2.getType(), dr2.getGenralname(), dr2.getUnit(),
				dr2.getNorms(), dr2.getApprovalnum(), dr2.getPeriod(), dr2.getMiinstock(), dr2.getProducts(),
				dr2.getBid(), dr2.getPrice() };
		if (db.executeUpdate(sql, obj) == 1) {
			result = true;
		}

		return result;
	}

	// delete by id
	public boolean delete(drugs dr) {
		boolean result = false;
		if (dr == null) {
			return result;
		}
		String sql = "delete from drugs where  id=?";
		Object[] param = { dr.getId() };
		int rowCount = db.executeUpdate(sql, param);
		if (rowCount == 1) {
			result = true;
		}
		destroy();
		return result;
	}

	// query by id
	public drugs queryById(int id) throws SQLException {
		ResultSet rs = null;
		dr2 = null;

		String checkSql = "select * from drugs where id=" + id;
		rs = db.executeQuery(checkSql);

		try {
			while (rs.next()) {
				dr2 = new drugs();
				dr2.setId(rs.getInt(1));
				dr2.setName(rs.getString(2));
				dr2.setJianma(rs.getString(3));
				dr2.setType(rs.getString(4));
				dr2.setGenralname(rs.getString(5));
				dr2.setUnit(rs.getString(6));
				dr2.setNorms(rs.getString(7));
				dr2.setApprovalnum(rs.getString(8));
				dr2.setPeriod(rs.getString(9));
				dr2.setMinstock(rs.getInt(10));
				dr2.setProducts(rs.getString(13));
				dr2.setBid(rs.getDouble(11));
				dr2.setPrice(rs.getDouble(12));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}

		return dr2;
	}

	// query all
	public String[][] list(int pageNum) {
		String[][] result = null;
		if (pageNum < 1) {
			return result;
		}
		List<drugs> drs = new ArrayList<drugs>();
		int i = 0;
		int beginNum = (pageNum - 1) * showNum;
		String sql = "select * from drugs limit ?,?";
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
	private void buildList(ResultSet rs, List<drugs> list, int i) throws SQLException {
		drugs drs = new drugs();
		drs.setId(rs.getInt("id"));
		drs.setName(rs.getString("name"));
		drs.setJianma(rs.getString("jianma"));
		drs.setType(rs.getString("type"));
		drs.setGenralname(rs.getString("genralname"));
		drs.setUnit(rs.getString("unit"));
		drs.setNorms(rs.getString("norms"));
		drs.setApprovalnum(rs.getString("approvalnum"));
		drs.setPeriod(rs.getString("period"));
		drs.setMinstock(rs.getInt("minstock"));
		drs.setProducts(rs.getString("products"));
		drs.setBid(rs.getDouble("bid"));
		drs.setPrice(rs.getDouble("price"));
		list.add(drs);
	}

	// 将list中记录添加到二维数组中
	private void buildResult(String[][] result, List<drugs> drs, int j) {
		drugs dr = drs.get(j);
		result[j][0] = String.valueOf(dr.getId());
		result[j][1] = dr.getName();
		result[j][2] = dr.getJianma();
		result[j][3] = dr.getType();
		result[j][4] = dr.getGenralname();
		result[j][5] = dr.getUnit();
		result[j][6] = dr.getNorms();
		result[j][7] = dr.getApprovalnum();
		result[j][8] = dr.getPeriod();
		result[j][9] = String.valueOf(dr.getMiinstock());
		result[j][10] = String.valueOf(dr.getBid());
		result[j][11] = String.valueOf(dr.getPrice());
		result[j][12] = dr.getProducts();

	}

	// update
	public boolean update(drugs dr2) {
		boolean result = false;
		if (dr2 == null)
			return result;
		try {
			if (dr.queryById(dr2.getId()) == null) {// id不存在
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "update  drugs set minstock =? where id=?";
		Object[] obj = { dr2.getMiinstock(), dr2.getId() };
		if (db.executeUpdate(sql, obj) == 1)
			result = true;
		return result;
	}

}
