package cn.lailab.sql;

import java.sql.ResultSet;
import java.util.List;

import cn.lailab.dao.EmployeeDao;
import cn.lailab.entity.Employee;

public class test {
	public static void main(String[] args) {
		try {
			List<Employee> emps = EmployeeDao.queryAllEmployee();
			for(Employee emp : emps) {
				System.out.println(emp.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}