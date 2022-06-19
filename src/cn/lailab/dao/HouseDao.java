package cn.lailab.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.lailab.entity.Finance;
import cn.lailab.entity.House;
import cn.lailab.sql.sqlHelper;

public class HouseDao {

	// 增加操作
	public static boolean addHouse(House hou) throws Exception {
		String sql = "INSERT INTO house(h_name, h_number, h_type, h_price, h_erea, e_id, h_time)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?);";
		int rst = sqlHelper.updateByPstmt(sql, hou.getName(), hou.getNumber(), hou.getType(), hou.getPrice(),
				hou.getType(), hou.getErea(), hou.getEid(), hou.getTime());
		return rst == 1;
	}

	// 删除操作
	public static boolean deleteHouseById(int id) throws Exception {
		String sql = "DELETE FROM finance" + "WHERE h_id = ?";
		int rst = sqlHelper.updateByPstmt(sql, id);
		return rst == 1;
	}

	// 修改操作
	public static boolean updateHouse(House hou) throws Exception {
		String sql = "UPDATE house SET h_name=?, h_number=?, h_type=?, h_price=?, h_erea=?, e_id=?, h_time=? AND h_id=?";
		int rst = sqlHelper.updateByPstmt(sql, hou.getName(), hou.getNumber(), hou.getType(), hou.getPrice(),
				hou.getType(), hou.getErea(), hou.getEid(), hou.getTime(), hou.getId());
		return rst == 1;
	}

	// 查询操作
	public static List<House> queryAllHouse() throws Exception {
		String sql = "SELECT h_name, h_number, h_type, h_price, h_erea, e_id, h_time FROM house";
		ResultSet rst = sqlHelper.query(sql);
		List<House> hous = new ArrayList<House>();
		while (rst.next()) {
			House hou = new House();
			hou.setId(rst.getInt(1));
			hou.setName(rst.getString(2));
			hou.setNumber(rst.getString(3));
			hou.setType(rst.getString(4));
			hou.setPrice(rst.getDouble(5));
			hou.setErea(rst.getInt(6));
			hou.setEid(rst.getInt(7));
			hou.setTime(rst.getString(8));
			hous.add(hou);
		}
		return hous;
	}
}
