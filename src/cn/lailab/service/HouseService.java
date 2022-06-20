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
import cn.lailab.dao.HouseDao;
import cn.lailab.entity.Customer;
import cn.lailab.entity.House;
import cn.lailab.entity.Result;

@WebServlet("/HouseService")
public class HouseService extends HttpServlet {

	public HouseService() {
		super();
	}

	/**
	 * GET请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定义输出对象
		PrintWriter out = response.getWriter();
		// 获取操作类型
		String operate = request.getParameter("operate");
		// 楼盘ID
		int id;
		// 楼盘名称
		String name;
		// 楼盘号码
		String number;
		// 楼盘地址
		String type;
		// 楼盘价格
		double price;
		// 楼盘面积
		int erea;
		// 员工ID(统计人员)
		int eid;
		// 登记时间
		String time;
		// 返回值对象
		Result rst = new Result();
		// 判断操作
		switch (operate) {
		// 增加操作
		case "add":
			name = request.getParameter("name");
			number = request.getParameter("number");
			type = request.getParameter("type");
			price = Double.parseDouble(request.getParameter("price"));
			erea = Integer.parseInt(request.getParameter("erea"));
			eid = Integer.parseInt(request.getParameter("eid"));
			time = request.getParameter("time");
			House hou1 = new House();
			hou1.setName(name);
			hou1.setNumber(number);
			hou1.setType(type);
			hou1.setPrice(price);
			hou1.setErea(erea);
			hou1.setEid(eid);
			hou1.setTime(time);
			try {
				boolean statu = HouseDao.addHouse(hou1);
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
				boolean statu = HouseDao.deleteHouseById(id);
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
			number = request.getParameter("number");
			type = request.getParameter("type");
			price = Double.parseDouble(request.getParameter("price"));
			erea = Integer.parseInt(request.getParameter("erea"));
			eid = Integer.parseInt(request.getParameter("eid"));
			time = request.getParameter("time");
			House hou2 = new House();
			hou2.setId(id);
			hou2.setName(name);
			hou2.setNumber(number);
			hou2.setType(type);
			hou2.setPrice(price);
			hou2.setErea(erea);
			hou2.setEid(eid);
			hou2.setTime(time);
			try {
				boolean statu = HouseDao.updateHouse(hou2);
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
				List<House> hous = HouseDao.queryAllHouse();
				JSONArray ja = new JSONArray().fluentAddAll(hous);
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

	/**
	 * POST请求
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
