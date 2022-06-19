package cn.lailab.dao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Employee����
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
	 * GET����
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �������
		PrintWriter out = response.getWriter();
		// ��ȡ����
		String operate = request.getParameter("operate");
		// ���巵���ַ�
		StringBuffer sb = new StringBuffer();
		// �����Ǹ�������
		
		// �����ж�
		switch(operate) {
			// ���Ӳ���
			case "add":
				break;
			// ɾ������
			case "del":
				break;
			// �޸Ĳ���
			case "update":
				break;
			// ��ѯ����
			case "select":
				break;
			default :
				out.println("û���������");
				break;
		}
		out.println(operate);
	}

	/**
	 * POST����
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
