package Objective;

/**
 * @author caden wuye date: 2019-5-27
 */
public class getout {

	private int id;// 账单编号
	private int drugid;// 药品编号
	private String drugname;// 药品名称
	private double drugprice;// 药品售价
	private String managetype;// 操作类型
	private double number;

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	private String date;// 日期

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDrugid() {
		return drugid;
	}

	public void setDrugid(int drugid) {
		this.drugid = drugid;
	}

	public String getDrugname() {
		return drugname;
	}

	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}

	public double getDrugprice() {
		return drugprice;
	}

	public void setDrugprice(double drugprice) {
		this.drugprice = drugprice;
	}

	public String getManagetype() {
		return managetype;
	}

	public void setManagetype(String managetype) {
		this.managetype = managetype;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
