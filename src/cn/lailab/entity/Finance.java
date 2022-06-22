package cn.lailab.entity;

public class Finance {
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
	// ������
	double paymentamount;
	// ������
	double loanamount;
	// ��������
	String bankname;
	// ����ʱ��
	String time;

	public Finance() {
	}

	public Finance(int cid, int eid, double price, String paymentway, String type, double paymentamount,
			double loanamount, String bankname, String time) {
		this.cid = cid;
		this.eid = eid;
		this.price = price;
		this.paymentway = paymentway;
		this.type = type;
		this.paymentamount = paymentamount;
		this.loanamount = loanamount;
		this.bankname = bankname;
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

	public double getPaymentamount() {
		return paymentamount;
	}

	public void setPaymentamount(double paymentamount) {
		this.paymentamount = paymentamount;
	}

	public double getLoanamount() {
		return loanamount;
	}

	public void setLoanamount(double loanamount) {
		this.loanamount = loanamount;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
