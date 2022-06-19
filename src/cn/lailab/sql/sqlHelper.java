package cn.lailab.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

public class sqlHelper {
	// 连接信息
	private static final String URL = "jdbc:mysql://localhost:3306/db_realmanagersystem?serverTimezone=UTC";
	private static final String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";

	// 数据库操作变量
	private static Connection con = null;
	private static ResultSet rs = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static int rows = 0;

	/**
	 * 建立连接
	 */
	public static Connection getConnection() throws Exception {

		// 注册驱动
		Class.forName(DRIVERCLASS);
		// 获得连接
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return con;
	}

	/**
	 * 查询
	 */
	public static ResultSet query(String sql) throws Exception {
		con = getConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		return rs;
	}
	
	/**
	 * 查询
	 */
	public static ResultSet queryByPstmt(String sql) throws Exception {
		con = getConnection();
		pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = pstmt.executeQuery();
		return rs;
	}

	/**
	 * 通过PreparedStatement执行查询，能够有效防止SQL注入漏洞
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static ResultSet queryByPstmt(String sql, Object... param) throws Exception {
		con = getConnection();
		PreparedStatement pst = sql2pst(sql, param);
		rs = pst.executeQuery(sql);
		return rs;
	}

	/**
	 * 增加、删除、修改
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static int update(String sql) throws Exception {
		con = getConnection();
		stmt = con.createStatement();
		rows = stmt.executeUpdate(sql);
		return rows;
	}
	
	/**
	 * 增加、删除、修改
	 * 
	 * @param sql
	 * @return
	 * @throws Exception
	 */
//	public static int updateByPstms(String sql) throws Exception {
//		con = getConnection();
//		stmt = con.createStatement();
//		rows = stmt.executeUpdate(sql);
//		return rows;
//	}

	/**
	 * 通过PreparedStatement执行更新，能够有效防止SQL注入漏洞
	 * 
	 * @param sql
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static int updateByPstmt(String sql, Object... param) throws Exception {
		con = getConnection();
		PreparedStatement pst = sql2pst(sql, param);
		rows = pst.executeUpdate();
		return rows;
	}
	
	/**
	 * Java SQL防注入
	 * @param sql
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	public static PreparedStatement sql2pst(String sql, Object... param) throws SQLException {
		PreparedStatement pst = con.prepareStatement(sql);
		for(int i = 0; i < param.length; i++) {
			pst.setObject(i, param[i]);
		}
		return pst;
	}

	/**
	 * 释放资源
	 * 
	 * @throws Exception
	 */
	public static void close() throws Exception {
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
	}
}
