package cn.lailab.bean;

public class finance {
	// �˿�ID
	int cid;
	// Ա��ID
	int eid;
	// �˵����
	double price;
	// ���ʽ
	String paymentway;
	// ��������
	String type;
	// ����ʱ��
	String time;

	public finance(int cid, int eid, double price, String paymentway, String type, String time) {
		this.cid = cid;
		this.eid = eid;
		this.price = price;
		this.paymentway = paymentway;
		this.type = type;
		this.time = time;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPaymentway() {
		return paymentway;
	}

	public void setPaymentway(String paymentway) {
		this.paymentway = paymentway;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
