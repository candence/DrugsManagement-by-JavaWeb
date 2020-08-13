package Dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Objective.getin;

import base.BaseDao;

public class getindao extends BaseDao {

	private static getindao god = null;
	private getin in = null;
	private final int fieldNum = 13;
	private final int showNum = 15;
	public final static String outputFile = "lib:\\getin.xls";

	/*-
	 * 
	 * ��ȡ���ʵ��
	 * */
	public static synchronized getindao getInstance() {
		if (god == null) {
			god = new getindao();
		}
		return god;
	}

	public boolean add(getin in) {
		boolean result = false;
		if (in == null)
			return result;
		try {
			if ((god.queryById(in.getBuyid())) != null) {// id������
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "insert into getin (buyid,drugid,drugname,number,drugbid,managertype,date) values (?,?,?,?,?,?,?);";
		Object[] obj = { in.getBuyid(), in.getDrugid(), in.getDrugname(), in.getNumber(), in.getDrugbid(),
				in.getManagertype(), in.getDate() };
		if (db.executeUpdate(sql, obj) == 1) {
			result = true;
		}
		return result;
	}

	public getin queryById(int id) throws SQLException {
		ResultSet rs = null;
		in = null;

		String checkSql = "select * from getin where buyid=" + id;
		rs = db.executeQuery(checkSql);

		try {
			while (rs.next()) {
				in = new getin();
				in.setBuyid(rs.getInt(1));
				in.setDrugid(rs.getInt(2));
				in.setDrugname(rs.getString(3));
				in.setNumber(rs.getInt(4));
				in.setDrugbid(rs.getDouble(5));
				in.setManagertype(rs.getString(6));
				in.setDate(rs.getString(7));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}

		return in;
	}

	// query all
	public String[][] list(int pageNum) {
		String[][] result = null;
		if (pageNum < 1) {
			return result;
		}
		List<getin> drs = new ArrayList<getin>();
		int i = 0;// ���õ�������
		int beginNum = (pageNum - 1) * showNum;
		String sql = "select * from getin limit ?,?";
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

	// ��rs��¼��ӵ�list��
	private void buildList(ResultSet rs, List<getin> list, int i) throws SQLException {
		in = new getin();
		in.setBuyid(rs.getInt("buyid"));
		in.setDrugid(rs.getInt("drugid"));
		in.setDrugname(rs.getString("drugname"));
		in.setNumber(rs.getInt("number"));
		in.setDrugbid(rs.getDouble("drugbid"));
		in.setManagertype(rs.getString("managertype"));
		in.setDate(rs.getString("date"));
		list.add(in);
	}

	// ��list�м�¼��ӵ���ά������
	private void buildResult(String[][] result, List<getin> drs, int j) {
		getin dr = drs.get(j);
		result[j][0] = String.valueOf(dr.getBuyid());
		result[j][1] = String.valueOf(dr.getDrugid());
		result[j][2] = dr.getDrugname();
		result[j][3] = String.valueOf(dr.getNumber());
		result[j][4] = String.valueOf(dr.getDrugbid());
		result[j][5] = dr.getManagertype();
		result[j][6] = dr.getDate();

	}

	// �����ݿ��ȡExcel
	public void ReadExcelFromDb() {
		ResultSet rs = db.executeQuery("select * from getin;");

		XSSFWorkbook workbook = new XSSFWorkbook();// ����һ���µĹ�����
		XSSFSheet sheet = workbook.createSheet("getin");// ��������һ���µ�Sheet
		XSSFRow row = sheet.createRow(0);// �������У���Ҫָ���кţ��кŴ�0��ʼ
		XSSFCell cell = null;
		cell = row.createCell(0);// �����µĵ�Ԫ��
		cell.setCellValue("buyid"); // ���õ�Ԫ���ֵ
		cell = row.createCell(1);
		cell.setCellValue("drugid");
		cell = row.createCell(2);
		cell.setCellValue("drugname");
		cell = row.createCell(3);
		cell.setCellValue("number");
		cell = row.createCell(4);
		cell.setCellValue("drugbid");
		cell = row.createCell(5);
		cell.setCellValue("managetype");
		cell = row.createCell(6);
		cell.setCellValue("date");
		cell = row.createCell(7);
		int i = 1;// ���õ�������
		try {
			while (rs.next()) {

				row = sheet.createRow(i);// ����Ϊ��I��
				// ���õ�Ԫ���ֵ
				cell = row.createCell(0);
				cell.setCellValue(rs.getInt("buyid"));
				cell = row.createCell(2);
				cell.setCellValue(rs.getString("drugname"));
				cell = row.createCell(3);
				cell.setCellValue(rs.getInt("number"));
				cell = row.createCell(4);
				cell.setCellValue(rs.getDouble("drugbid"));
				cell = row.createCell(5);
				cell.setCellValue(rs.getString("managertype"));
				cell = row.createCell(6);
				cell.setCellValue(rs.getString("date"));
				i++;

			}

			FileOutputStream FOut = new FileOutputStream(outputFile);
			workbook.write(FOut);
			FOut.flush();
			FOut.close();
			System.out.println("Excel�ļ����ɳɹ�...");
		}

		catch (Exception e) {

			e.printStackTrace();
		}finally{
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
