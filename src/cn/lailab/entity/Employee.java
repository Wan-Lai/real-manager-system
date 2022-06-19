package cn.lailab.entity;

public class Employee {
	// Ա��ID
	int id;
	// Ա������
	String name;
	// Ա���û���
	String username;
	// Ա���Ա�
	String gender;
	// Ա������
	int age;
	// Ա���绰��
	String phone;
	// Ա������
	String dapartment;
	// Ա��ְλ
	String position;
	// Ա��нˮ
	double salary;

	public Employee() {
	}

	public Employee(int id, String name, String username, String gender, int age, String phone, String dapartment,
			String position, double salary) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.dapartment = dapartment;
		this.position = position;
		this.salary = salary;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDapartment() {
		return dapartment;
	}

	public void setDapartment(String dapartment) {
		this.dapartment = dapartment;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
