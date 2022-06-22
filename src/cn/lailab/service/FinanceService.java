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
import cn.lailab.dao.FinanceDao;
import cn.lailab.entity.Employee;
import cn.lailab.entity.Finance;
import cn.lailab.entity.Result;

@WebServlet("/FinanceService")
public class FinanceService extends HttpServlet {

	public FinanceService() {
		super();
	}

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
		int cid;
		// Ա��ID
		int eid;
		// �˵����
		double price;
		// ���ʽ
		String paymentway;
		// ��������
		String type;
		// ֧�����
		double paymentamount;
		// ������
		double loanamount;
		// ��������
		String bankname;
		// ����ʱ��
		String time;
		// ����ֵ����
		Result rst = new Result();
		// �жϲ���
		switch (operate) {
		// ���Ӳ���
		case "add":
			cid = Integer.parseInt(request.getParameter("cid"));
			eid = Integer.parseInt(request.getParameter("eid"));
			price = Double.parseDouble(request.getParameter("price"));
			paymentway = request.getParameter("paymentway");
			type = request.getParameter("type");
			paymentamount = Double.parseDouble(request.getParameter("paymentamount"));
			loanamount = Double.parseDouble(request.getParameter("loanamount"));
			bankname = request.getParameter("bankname");
			time = request.getParameter("time");
			Finance fin1 = new Finance();
			fin1.setCid(cid);
			fin1.setEid(eid);
			fin1.setPrice(price);
			fin1.setPaymentway(paymentway);
			fin1.setType(type);
			fin1.setPaymentamount(paymentamount);
			fin1.setLoanamount(loanamount);
			fin1.setBankname(bankname);
			fin1.setTime(time);
			try {
				boolean statu = FinanceDao.addFinance(fin1);
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
			cid = Integer.parseInt(request.getParameter("cid"));
			eid = Integer.parseInt(request.getParameter("eid"));
			try {
				boolean statu = FinanceDao.deleteFinanceByCIdAndEid(cid, eid);
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
			cid = Integer.parseInt(request.getParameter("cid"));
			eid = Integer.parseInt(request.getParameter("eid"));
			price = Double.parseDouble(request.getParameter("price"));
			paymentway = request.getParameter("paymentway");
			type = request.getParameter("type");
			paymentamount = Double.parseDouble(request.getParameter("paymentamount"));
			loanamount = Double.parseDouble(request.getParameter("loanamount"));
			bankname = request.getParameter("bankname");
			time = request.getParameter("time");
			Finance fin2 = new Finance();
			fin2.setCid(cid);
			fin2.setEid(eid);
			fin2.setPrice(price);
			fin2.setPaymentway(paymentway);
			fin2.setType(type);
			fin2.setPaymentamount(paymentamount);
			fin2.setLoanamount(loanamount);
			fin2.setBankname(bankname);
			fin2.setTime(time);
			try {
				boolean statu = FinanceDao.updateFinance(fin2);
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
				List<Finance> fins = FinanceDao.queryAllFinance();
				JSONArray ja = new JSONArray().fluentAddAll(fins);
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
