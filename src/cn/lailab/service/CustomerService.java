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

import cn.lailab.dao.CustomerDao;
import cn.lailab.dao.EmployeeDao;
import cn.lailab.entity.Customer;
import cn.lailab.entity.Employee;
import cn.lailab.entity.Result;

@WebServlet("/CustomerService")
public class CustomerService extends HttpServlet {

	/*
	 * GET请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定义输出对象
		PrintWriter out = response.getWriter();
		// 获取操作类型
		String operate = request.getParameter("operate");
		// 顾客ID
		int id;
		// 顾客名称
		String name;
		// 顾客买房位置
		String buyAddress;
		// 顾客地址
		String address;
		// 顾客电话
		String phone;
		// 顾客身份证号
		String idnum;
		// 顾客身份证状态
		String idstatu;
		// 登记时间
		String time;
		// 期望类型
		String wanttype;
		// 员工编号
		int eid;
		// 顾客备注
		String commend;
		// 员工薪水
		double salary;
		// 返回值对象
		Result rst = new Result();
		// 判断操作
		switch (operate) {
		// 增加操作
		case "add":
			name = request.getParameter("name");
			buyAddress = request.getParameter("buyaddress");
			address = request.getParameter("address");
			phone = request.getParameter("phone");
			idnum = request.getParameter("idnum");
			idstatu = request.getParameter("idstatu");
			wanttype = request.getParameter("wanttype");
			eid = Integer.parseInt(request.getParameter("eid"));
			commend = request.getParameter("commend");
			Customer cus1 = new Customer();
			cus1.setName(name);
			cus1.setBuyaddress(buyAddress);
			cus1.setAddress(address);
			cus1.setPhone(phone);
			cus1.setIdnum(idnum);
			cus1.setIdstatu(idstatu);
			cus1.setWanttype(wanttype);
			cus1.setEid(eid);
			cus1.setCommend(commend);
			try {
				boolean statu = CustomerDao.addCustomer(cus1);
				rst.setCode(200);
				rst.setMessage((statu ? "1" : "0"));
			} catch (Exception e) {
				rst.setCode(400);
				rst.setMessage("添加失败！");
				e.printStackTrace();
			}
			break;
		// 删除操作
		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			try {
				boolean statu = CustomerDao.deleteCustomerById(id);
				rst.setCode(200);
				rst.setMessage((statu ? "1" : "0"));
			} catch (Exception e) {
				rst.setCode(400);
				rst.setMessage("删除失败！");
				e.printStackTrace();
			}
			break;
		// 修改操作
		case "update":
			id = Integer.parseInt(request.getParameter("id"));
			name = request.getParameter("name");
			buyAddress = request.getParameter("buyaddress");
			address = request.getParameter("address");
			phone = request.getParameter("phone");
			idnum = request.getParameter("idnum");
			idstatu = request.getParameter("idstatu");
			time = request.getParameter("time");
			wanttype = request.getParameter("wanttype");
			eid = Integer.parseInt(request.getParameter("eid"));
			commend = request.getParameter("commend");
			Customer cus2 = new Customer();
			cus2.setId(id);
			cus2.setName(name);
			cus2.setBuyaddress(buyAddress);
			cus2.setAddress(address);
			cus2.setPhone(phone);
			cus2.setIdnum(idnum);
			cus2.setIdstatu(idstatu);
			cus2.setTime(time);
			cus2.setWanttype(wanttype);
			cus2.setEid(eid);
			cus2.setCommend(commend);
			try {
				boolean statu = CustomerDao.updateCustomer(cus2);
				rst.setCode(200);
				rst.setMessage((statu ? "1" : "0"));
			} catch (Exception e) {
				rst.setCode(400);
				rst.setMessage("修改失败！");
				e.printStackTrace();
			}
			break;
		// 查询操作
		case "queryAll":
			try {
				List<Customer> cuss = CustomerDao.queryAllCustomer();
				JSONArray ja = new JSONArray().fluentAddAll(cuss);
				rst.setCode(200);
				rst.setMessage(ja.toString());
			} catch (Exception e) {
				rst.setCode(400);
				e.printStackTrace();
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