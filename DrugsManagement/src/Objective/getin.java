package Objective;

/**
 * @author caden wuye date:2019-5-27
 */
/*
 * 模块说明：购买订单类
 * 
 */
public class getin {

	private int buyid;// 购买订单号
	private int drugid;// 药品编号
	private String drugname;// 药品名称
	private double number;// 数量
	private double drugbid;// 药品进价
	private String managertype;// 操作类型
	private String date;// 时间

	public int getBuyid() {
		return buyid;
	}

	public void setBuyid(int buyid) {
		this.buyid = buyid;
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

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	public double getDrugbid() {
		return drugbid;
	}

	public void setDrugbid(double drugbid) {
		this.drugbid = drugbid;
	}

	public String getManagertype() {
		return managertype;
	}

	public void setManagertype(String managertype) {
		this.managertype = managertype;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
