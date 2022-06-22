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
	 * GET����
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �����������
		PrintWriter out = response.getWriter();
		// ��ȡ��������
		String operate = request.getParameter("operate");
		// �˿�ID
		int id;
		// �˿�����
		String name;
		// �˿���λ��
		String buyAddress;
		// �˿͵�ַ
		String address;
		// �˿͵绰
		String phone;
		// �˿����֤��
		String idnum;
		// �˿����֤״̬
		String idstatu;
		// �Ǽ�ʱ��
		String time;
		// ��������
		String wanttype;
		// Ա�����
		int eid;
		// �˿ͱ�ע
		String commend;
		// Ա��нˮ
		double salary;
		// ����ֵ����
		Result rst = new Result();
		// �жϲ���
		switch (operate) {
		// ���Ӳ���
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
				rst.setMessage("���ʧ�ܣ�");
				e.printStackTrace();
			}
			break;
		// ɾ������
		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			try {
				boolean statu = CustomerDao.deleteCustomerById(id);
				rst.setCode(200);
				rst.setMessage((statu ? "1" : "0"));
			} catch (Exception e) {
				rst.setCode(400);
				rst.setMessage("ɾ��ʧ�ܣ�");
				e.printStackTrace();
			}
			break;
		// �޸Ĳ���
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
				rst.setMessage("�޸�ʧ�ܣ�");
				e.printStackTrace();
			}
			break;
		// ��ѯ����
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
			rst.setMessage("δ����˲���");
			break;
		}
		out.println(rst.toString());
	}

	/*
	 * POST����
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}