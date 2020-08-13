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

import Objective.getout;
import base.BaseDao;

public class getoutdao extends BaseDao {

	private static getoutdao god = null;
	private getout out = null;
	private final int fieldNum = 13;
	private final int showNum = 15;
	private final static String outputFile_out="E:\\getout.xls";
	/*-
	 * 
	 * 获取表的实例
	 * */
	public static synchronized getoutdao getInstance() {
		if (god == null) {
			god = new getoutdao();
		}
		return god;
	}

	public boolean add(getout out) {
		boolean result = false;
		if (out == null)
			return result;
		try {
			if ((god.queryById(out.getId())) != null) {// id不存在
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql = "insert into getout (id,drugid,drugname,number,drugprice,managetype,date) values (?,?,?,?,?,?,?);";
		Object[] obj = { out.getId(), out.getDrugid(), out.getDrugname(), out.getNumber(), out.getDrugprice(),
				out.getManagetype(), out.getDate() };
		if (db.executeUpdate(sql, obj) == 1) {
			result = true;
		}
		return result;
	}

	public getout queryById(int id) throws SQLException {
		ResultSet rs = null;
		out = null;

		String checkSql = "select * from getout where id=" + id;
		rs = db.executeQuery(checkSql);

		try {
			while (rs.next()) {
				out = new getout();
				out.setId(rs.getInt(1));
				out.setDrugid(rs.getInt(2));
				out.setDrugname(rs.getString(3));
				out.setNumber(rs.getInt(4));
				out.setDrugprice(rs.getDouble(5));
				out.setManagetype(rs.getString(6));
				out.setDate(rs.getString(7));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			destroy();
		}

		return out;
	}

	// query all
	public String[][] list(int pageNum) {
		String[][] result = null;
		if (pageNum < 1) {
			return result;
		}
		List<getout> drs = new ArrayList<getout>();
		int i = 0;
		int beginNum = (pageNum - 1) * showNum;
		String sql = "select * from getout limit ?,?";
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
	private void buildList(ResultSet rs, List<getout> list, int i) throws SQLException {
		out = new getout();
		out.setId(rs.getInt("id"));
		out.setDrugid(rs.getInt("drugid"));
		out.setDrugname(rs.getString("drugname"));
		out.setNumber(rs.getInt("number"));
		out.setDrugprice(rs.getDouble("drugprice"));
		out.setManagetype(rs.getString("managetype"));
		out.setDate(rs.getString("date"));
		;
		list.add(out);
	}

	// 将list中记录添加到二维数组中
	private void buildResult(String[][] result, List<getout> drs, int j) {
		getout dr = drs.get(j);
		result[j][0] = String.valueOf(dr.getId());
		result[j][1] = String.valueOf(dr.getDrugid());
		result[j][2] = dr.getDrugname();
		result[j][3] = String.valueOf(dr.getNumber());
		result[j][4] = String.valueOf(dr.getDrugprice());
		result[j][5] = dr.getManagetype();
		result[j][6] = dr.getDate();

	}
	
	//讀取出庫表
	public void ReadExcelFromDb() {
		ResultSet rs = db.executeQuery("select * from getout;");

		XSSFWorkbook workbook = new XSSFWorkbook();// 创建一个新的工作簿
		XSSFSheet sheet = workbook.createSheet("getout");// 创建创建一个新的Sheet
		XSSFRow row = sheet.createRow(0);// 创建新行，需要指定行号，行号从0开始
		XSSFCell cell = null;
		cell = row.createCell(0);// 创建新的单元格
		cell.setCellValue("id"); // 设置单元格的值
		cell = row.createCell(1);
		cell.setCellValue("drugid");
		cell = row.createCell(2);
		cell.setCellValue("drugname");
		cell = row.createCell(3);
		cell.setCellValue("number");
		cell = row.createCell(4);
		cell.setCellValue("drugprice");
		cell = row.createCell(5);
		cell.setCellValue("managetype");
		cell = row.createCell(6);
		cell.setCellValue("date");
		cell = row.createCell(7);
		int i = 1;// 设置递增变量
		try {
			while (rs.next()) {

				row = sheet.createRow(i);// 设置为第I行
				// 设置单元格的值
				cell = row.createCell(0);
				cell.setCellValue(rs.getInt("id"));
				cell = row.createCell(2);
				cell.setCellValue(rs.getInt("drugid"));
				cell = row.createCell(3);
				cell.setCellValue(rs.getString("drugname"));
				cell = row.createCell(4);
				cell.setCellValue(rs.getDouble("drugprice"));
				cell = row.createCell(5);
				cell.setCellValue(rs.getString("managetype"));
				cell = row.createCell(6);
				cell.setCellValue(rs.getString("date"));
				i++;

			}

			FileOutputStream FOut = new FileOutputStream(outputFile_out);
			workbook.write(FOut);
			FOut.flush();
			FOut.close();
			System.out.println("Excel文件生成成功...");
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
