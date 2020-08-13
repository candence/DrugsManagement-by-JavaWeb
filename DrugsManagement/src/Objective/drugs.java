package Objective;

/*
 * 模块说明：药品类
 * */

/**
 * @author caden wuye date:2019-5-27 11:20
 */
public class drugs {

	private int id;// 药品编号
	private String name = null;// 药品名称
	private String jianma = null;// 简拼
	private String type = null;// 药品类型
	private String genralname = null;// 通用名
	private String unit = null;// 单位
	private String norms = null;// 规格
	private String approvalnum = null;// 批准文号
	private String period = null;// 保质期
	public String products = null;// 生产厂家
	private int minstock;

	public int getMiinstock() {
		return minstock;
	}

	public void setMinstock(int minstock) {
		this.minstock = minstock;
	}

	private double bid = 0;// 进价
	private double price = 0;// 售价

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}

	public double getBid() {
		return bid;
	}

	public void setBid(double bid) {
		this.bid = bid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJianma() {
		return jianma;
	}

	public void setJianma(String jianma) {
		this.jianma = jianma;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGenralname() {
		return genralname;
	}

	public void setGenralname(String genralname) {
		this.genralname = genralname;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getNorms() {
		return norms;
	}

	public void setNorms(String norms) {
		this.norms = norms;
	}

	public String getApprovalnum() {
		return approvalnum;
	}

	public void setApprovalnum(String approvalnum) {
		this.approvalnum = approvalnum;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

}
