package cn.lailab.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.lailab.entity.Finance;
import cn.lailab.sql.sqlHelper;

public class FinanceDao {

	// 增加操作
	public static boolean addFinance(Finance fin) throws Exception {
		String sql = "INSERT INTO finance(c_id, e_id, c_price, c_payment_way, c_type)"
				+ "VALUES(?, ?, ?, ?, ?)";
		int rst = sqlHelper.updateByPstmt(sql, fin.getCid(), fin.getEid(), fin.getPrice(), fin.getPaymentway(),
				fin.getType());
		return rst == 1;
	}

	// 删除操作
	public static boolean deleteFinanceByCIdAndEid(int cid, int eid) throws Exception {
		String sql = "DELETE FROM finance WHERE c_id = ? AND e_id = ?";
		int rst = sqlHelper.updateByPstmt(sql, cid, eid);
		return rst == 1;
	}

	// 修改操作
	public static boolean updateFinance(Finance fin) throws Exception {
		String sql = "UPDATE finance SET c_price=?, c_payment_way=?, c_type=?, c_time=?" + "WHERE c_id=? AND e_id=?";
		int rst = sqlHelper.updateByPstmt(sql, fin.getPrice(), fin.getPaymentway(), fin.getType(), fin.getTime(),
				fin.getCid(), fin.getEid());
		return rst == 1;
	}

	// 查询操作
	public static List<Finance> queryAllFinance() throws Exception {
		String sql = "SELECT c_id, e_id, c_price, c_payment_way, c_type, c_time FROM finance";
		ResultSet rst = sqlHelper.query(sql);
		List<Finance> fins = new ArrayList<Finance>();
		while (rst.next()) {
			Finance fin = new Finance();
			fin.setCid(rst.getInt(1));
			fin.setEid(rst.getInt(2));
			fin.setPrice(rst.getDouble(3));
			fin.setPaymentway(rst.getString(4));
			fin.setType(rst.getString(5));
			fin.setTime(rst.getString(6));
			fins.add(fin);
		}
		return fins;
	}
}
