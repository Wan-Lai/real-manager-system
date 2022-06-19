package cn.lailab.entity;

public class Customer {
	// �˿�ID
	int id;
	// �˿�����
	String name;
	// �˿͹����ַ
	String buyaddress;
	// �˿͵�ַ
	String address;
	// �˿����֤��
	String idnum;
	// �˿����֤״̬
	String idstatu;
	// �˿͵Ǽ�ʱ��
	String time;
	// �˿�ϣ������
	String wanttype;
	// ��ע
	String commend;

	public Customer(int id, String name, String buyaddress, String address, String idnum, String idstatu, String time,
			String wanttype, String commend) {
		this.id = id;
		this.name = name;
		this.buyaddress = buyaddress;
		this.address = address;
		this.idnum = idnum;
		this.idstatu = idstatu;
		this.time = time;
		this.wanttype = wanttype;
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

	public String getCommend() {
		return commend;
	}

	public void setCommend(String commend) {
		this.commend = commend;
	}
}
