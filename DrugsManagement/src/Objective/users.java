package Objective;

/**
 * @author caden wuye date:2019-5-27 11:20
 */
public class users {

	private int id;// 用户id
	private String name;// 用户姓名
	private String password;// 用户密码
	private String sex;// 用户性别
	private String ygjs;// 用户类别

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getType() {
		return ygjs;
	}

	public void setType(String ygjs) {
		this.ygjs = ygjs;
	}

}
