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
	 * GET请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定义输出对象
		PrintWriter out = response.getWriter();
		// 获取操作类型
		String operate = request.getParameter("operate");
		// 顾客ID
		int cid;
		// 员工ID
		int eid;
		// 账单金额
		double price;
		// 付款方式
		String paymentway;
		// 财务类型
		String type;
		// 支付金额
		double paymentamount;
		// 贷款金额
		double loanamount;
		// 银行名称
		String bankname;
		// 财务时间
		String time;
		// 返回值对象
		Result rst = new Result();
		// 判断操作
		switch (operate) {
		// 增加操作
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
				rst.setMessage("添加失败！");
				e.printStackTrace();
			}
			break;
		// 删除操作
		case "delete":
			cid = Integer.parseInt(request.getParameter("cid"));
			eid = Integer.parseInt(request.getParameter("eid"));
			try {
				boolean statu = FinanceDao.deleteFinanceByCIdAndEid(cid, eid);
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
				rst.setMessage("修改失败！");
				e.printStackTrace();
			}
			break;
		// 查询操作
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
