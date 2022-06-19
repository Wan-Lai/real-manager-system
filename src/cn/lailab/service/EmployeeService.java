package cn.lailab.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;

import cn.lailab.dao.EmployeeDao;
import cn.lailab.entity.Employee;
import cn.lailab.entity.Result;

@WebServlet("/EmployeeService")
public class EmployeeService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeService() {
		super();
	}

	/*
	 * GET请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定义输出对象
		PrintWriter out = response.getWriter();
		// 获取操作类型
		String operate = request.getParameter("operate");
		// 员工ID
		int id;
		// 员工名称
		String name;
		// 员工用户名
		String username;
		// 员工性别
		String gender;
		// 员工年龄
		int age;
		// 员工电话
		String phone;
		// 员工部门
		String department;
		// 员工职位
		String position;
		// 员工薪水
		double salary;
		// 返回值对象
		Result rst = new Result();
		// 判断操作
		switch (operate) {
			// 增加操作
			case "add":
				name = request.getParameter("name");
				username = request.getParameter("username");
				gender = request.getParameter("gender");
				age = Integer.parseInt(request.getParameter("age"));
				phone = request.getParameter("phone");
				department = request.getParameter("department");
				position = request.getParameter("position");
				salary = Double.parseDouble(request.getParameter("salary"));
				Employee emp1 = new Employee();
				emp1.setName(name);
				emp1.setUsername(username);
				emp1.setGender(gender);
				emp1.setAge(age);
				emp1.setPhone(phone);
				emp1.setDapartment(department);
				emp1.setPosition(position);
				emp1.setSalary(salary);
				try {
					boolean statu = EmployeeDao.addEmployee(emp1);
					rst.setCode(200);
					rst.setMessage((statu?"1":"0"));
				} catch (Exception e) {
					rst.setCode(400);
					rst.setMessage("添加失败！");
					e.printStackTrace();
				}
				break;
			case "delete":
				id = Integer.parseInt(request.getParameter("id"));
				try {
					boolean statu = EmployeeDao.deleteEmployeeById(id);
					rst.setCode(200);
					rst.setMessage((statu?"1":"0"));
				} catch (Exception e) {
					rst.setCode(400);
					rst.setMessage("删除失败！");
					e.printStackTrace();
				}
				break;
			case "update":
				id = Integer.parseInt(request.getParameter("id"));
				name = request.getParameter("name");
				username = request.getParameter("username");
				gender = request.getParameter("gender");
				age = Integer.parseInt(request.getParameter("age"));
				phone = request.getParameter("phone");
				department = request.getParameter("department");
				position = request.getParameter("position");
				salary = Double.parseDouble(request.getParameter("salary"));
				Employee emp2 = new Employee();
				emp2.setId(id);
				emp2.setName(name);
				emp2.setUsername(username);
				emp2.setGender(gender);
				emp2.setAge(age);
				emp2.setPhone(phone);
				emp2.setDapartment(department);
				emp2.setPosition(position);
				emp2.setSalary(salary);
				try {
					boolean statu = EmployeeDao.updateEmployee(emp2);
					rst.setCode(200);
					rst.setMessage((statu?"1":"0"));
				} catch (Exception e) {
					rst.setCode(400);
					rst.setMessage("修改失败！");
					e.printStackTrace();
				}
				break;
			case "queryAll":
				try {
					List<Employee> emps = EmployeeDao.queryAllEmployee();
					JSONArray ja = new JSONArray().fluentAddAll(emps);
					rst.setCode(200);
					rst.setMessage(ja.toString());
				} catch (Exception e) {
					rst.setCode(400);
				}
				break;
			default:
				rst.setCode(400);
				rst.setMessage("未定义此操作");
				break;
		}
		out.println(rst.toString());
	}

	/*
	 * POST请求
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
