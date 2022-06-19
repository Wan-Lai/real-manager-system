package cn.lailab.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;

public class sqlHelper {
	// ������Ϣ
	private static final String URL = "jdbc:mysql://localhost:3306/db_realmanagersystem?serverTimezone=UTC";
	private static final String DRIVERCLASS = "com.mysql.cj.jdbc.Driver";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123456";

	// ���ݿ��������
	private static Connection con = null;
	private static ResultSet rs = null;
	private static Statement stmt = null;
	private static PreparedStatement pstmt = null;
	private static int rows = 0;

	/**
	 * ��������
	 */
	public static Connection getConnection() throws Exception {

		// ע������
		Class.forName(DRIVERCLASS);
		// �������
		con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return con;
	}

	/**
	 * ��ѯ
	 */
	public static ResultSet query(String sql) throws Exception {
		con = getConnection();
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		return rs;
	}
	
	/**
	 * ��ѯ
	 */
	public static ResultSet queryByPstmt(String sql) throws Exception {
		con = getConnection();
		pstmt = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		rs = pstmt.executeQuery();
		return rs;
	}

	/**
	 * ͨ��PreparedStatementִ�в�ѯ���ܹ���Ч��ֹSQLע��©��
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
	 * ���ӡ�ɾ�����޸�
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
	 * ���ӡ�ɾ�����޸�
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
	 * ͨ��PreparedStatementִ�и��£��ܹ���Ч��ֹSQLע��©��
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
	 * Java SQL��ע��
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
	 * �ͷ���Դ
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
