package cn.lailab.entity;

public class House {
	// 楼盘ID
	int id;
	// 楼盘名称
	String name;
	// 楼盘号码
	String number;
	// 楼盘类型
	String type;
	// 楼盘价格
	double price;
	// 楼盘面积
	int erea;
	// 操作人员
	int eid;
	// 楼盘时间
	String time;

	public House() {
	}

	public House(int id, String name, String number, String type, double price, int erea, int eid, String time) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.type = type;
		this.price = price;
		this.erea = erea;
		this.eid = eid;
		this.time = time;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getErea() {
		return erea;
	}

	public void setErea(int erea) {
		this.erea = erea;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}