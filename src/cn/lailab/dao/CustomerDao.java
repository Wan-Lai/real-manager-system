package cn.lailab.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.lailab.entity.Customer;
import cn.lailab.sql.sqlHelper;

public class CustomerDao {

	// 增加操作
	public static boolean addCustomer(Customer cus) throws Exception {
		String sql = "INSERT INTO customer(c_name, c_buy_address, c_address, c_phone, c_id_num, c_id_statu, c_want_type, c_commend)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?);";
		int rst = sqlHelper.updateByPstmt(sql, cus.getName(), cus.getBuyaddress(), cus.getAddress(), cus.getPhone(),
				cus.getIdnum(), cus.getIdstatu(), cus.getWanttype(), cus.getCommend());
		return rst == 1;
	}

	// 删除操作
	public static boolean deleteCustomerById(int id) throws Exception {
		String sql = "DELETE FROM customer WHERE c_id = ?";
		int rst = sqlHelper.updateByPstmt(sql, id);
		return rst == 1;
	}

	// 修改操作
	public static boolean updateCustomer(Customer cus) throws Exception {
		String sql = "UPDATE customer SET c_name=?, c_buy_address=?, c_address=?, c_phone=?, c_id_num=?, c_id_statu=?, c_time=?, c_want_type=?, c_commend=?"
				+ "WHERE c_id=?";
		int rst = sqlHelper.updateByPstmt(sql, cus.getName(), cus.getBuyaddress(), cus.getAddress(), cus.getPhone(),
				cus.getIdnum(), cus.getIdstatu(), cus.getTime(), cus.getWanttype(), cus.getCommend(), cus.getId());
		return rst == 1;
	}

	// 查询操作
	public static List<Customer> queryAllCustomer() throws Exception {
		String sql = "SELECT c_id, c_name, c_buy_address, c_address, c_phone, c_id_num, c_id_statu, c_time, c_want_type, c_commend FROM customer";
		ResultSet rst = sqlHelper.query(sql);
		List<Customer> cuss = new ArrayList<Customer>();
		while (rst.next()) {
			Customer cus = new Customer();
			cus.setId(rst.getInt(1));
			cus.setName(rst.getString(2));
			cus.setBuyaddress(rst.getString(3));
			cus.setAddress(rst.getString(4));
			cus.setPhone(rst.getString(5));
			cus.setIdnum(rst.getString(6));
			cus.setIdstatu(rst.getString(7));
			cus.setTime(rst.getString(8));
			cus.setWanttype(rst.getString(9));
			cus.setCommend(rst.getString(10));
			cuss.add(cus);
		}
		return cuss;
	}
}
