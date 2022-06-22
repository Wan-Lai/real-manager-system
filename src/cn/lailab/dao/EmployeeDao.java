package cn.lailab.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.lailab.entity.Employee;
import cn.lailab.sql.sqlHelper;

/**
 * Employee操作
 */
public class EmployeeDao {

	// 增加操作
	public static boolean addEmployee(Employee emp) throws Exception {
		String sql = "INSERT INTO employee(e_name, e_username, e_gender, e_age, e_phone, e_department, e_position, e_salary)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		int rst = sqlHelper.updateByPstmt(sql, emp.getName(), emp.getUsername(), emp.getGender(), emp.getAge(),
				emp.getPhone(), emp.getDepartment(), emp.getPosition(), emp.getSalary());
		return rst == 1;
	}

	// 删除操作
	public static boolean deleteEmployeeById(int id) throws Exception {
		String sql = "DELETE FROM employee WHERE e_id = ?";
		int rst = sqlHelper.updateByPstmt(sql, id);
		return rst == 1;
	}

	// 修改操作
	public static boolean updateEmployee(Employee emp) throws Exception {
		String sql = "UPDATE employee SET e_name=?, e_username=?, e_gender=?,e_age=?, e_phone=?, e_department=?, e_position=?, e_salary=?"
				+ "WHERE e_id=?";
		int rst = sqlHelper.updateByPstmt(sql, emp.getName(), emp.getUsername(), emp.getGender(), emp.getAge(), emp.getPhone(), emp.getDepartment(),
				 emp.getPosition(), emp.getSalary(), emp.getId());
		return rst == 1;
	}

	// 查询操作
	public static List<Employee> queryAllEmployee() throws Exception {
		String sql = "SELECT e_id, e_name, e_username, e_gender, e_age, e_phone, e_department, e_position, e_salary FROM employee";
		ResultSet rst = sqlHelper.query(sql);
		List<Employee> emps = new ArrayList<Employee>();
		while (rst.next()) {
			Employee emp = new Employee();
			emp.setId(rst.getInt(1));
			emp.setName(rst.getString(2));
			emp.setUsername(rst.getString(3));
			emp.setGender(rst.getString(4));
			emp.setAge(rst.getInt(5));
			emp.setPhone(rst.getString(6));
			emp.setDepartment(rst.getString(7));
			emp.setPosition(rst.getString(8));
			emp.setSalary(rst.getDouble(9));
			emps.add(emp);
		}
		return emps;
	}
}
