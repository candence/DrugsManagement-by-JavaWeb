package Objective;

/*
 * ģ��˵����ҩƷ��
 * */

/**
 * @author caden wuye date:2019-5-27 11:20
 */
public class drugs {

	private int id;// ҩƷ���
	private String name = null;// ҩƷ����
	private String jianma = null;// ��ƴ
	private String type = null;// ҩƷ����
	private String genralname = null;// ͨ����
	private String unit = null;// ��λ
	private String norms = null;// ���
	private String approvalnum = null;// ��׼�ĺ�
	private String period = null;// ������
	public String products = null;// ��������
	private int minstock;

	public int getMiinstock() {
		return minstock;
	}

	public void setMinstock(int minstock) {
		this.minstock = minstock;
	}

	private double bid = 0;// ����
	private double price = 0;// �ۼ�

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
