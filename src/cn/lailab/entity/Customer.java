package cn.lailab.entity;

public class Customer {
	// 顾客ID
	int id;
	// 顾客姓名
	String name;
	// 顾客购买地址
	String buyaddress;
	// 顾客地址
	String address;
	// 顾客电话
	String phone;
	// 顾客身份证号
	String idnum;
	// 顾客身份证状态
	String idstatu;
	// 顾客登记时间
	String time;
	// 员工编号
	int eid;
	// 顾客希望类型
	String wanttype;
	// 备注
	String commend;

	public Customer() {
	}

	public Customer(int id, String name, String buyaddress, String address, String phone, String idnum, String idstatu,
			String time, String wanttype, int eid, String commend) {
		this.id = id;
		this.name = name;
		this.buyaddress = buyaddress;
		this.address = address;
		this.phone = phone;
		this.idnum = idnum;
		this.idstatu = idstatu;
		this.time = time;
		this.wanttype = wanttype;
		this.eid = eid;
		this.commend = commend;
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

	public String getBuyaddress() {
		return buyaddress;
	}

	public void setBuyaddress(String buyaddress) {
		this.buyaddress = buyaddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	public String getIdstatu() {
		return idstatu;
	}

	public void setIdstatu(String idstatu) {
		this.idstatu = idstatu;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getWanttype() {
		return wanttype;
	}

	public void setWanttype(String wanttype) {
		this.wanttype = wanttype;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getCommend() {
		return commend;
	}

	public void setCommend(String commend) {
		this.commend = commend;
	}
}
