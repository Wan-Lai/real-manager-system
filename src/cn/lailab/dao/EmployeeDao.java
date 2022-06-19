package cn.lailab.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Employee操作
 */
@WebServlet("/EmployeeDao")
public class EmployeeDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDao() {
        super();
    }

	/**
	 * GET请求
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 内容输出
		PrintWriter out = response.getWriter();
		// 获取操作
		String operate = request.getParameter("operate");
		// 定义返回字符
		StringBuffer sb = new StringBuffer();
		// 以下是复用数据
		
		// 操作判断
		switch(operate) {
			// 增加操作
			case "add":
				break;
			// 删除操作
			case "del":
				break;
			// 修改操作
			case "update":
				break;
			// 查询操作
			case "select":
				break;
			default :
				out.println("没有这个功能");
				break;
		}
		out.println(operate);
	}

	/**
	 * POST请求
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
