package cn.lailab.sql;

import java.sql.ResultSet;

public class test {
	public static void main(String[] args) {
		try {
			String sql = "SELECT * FROM employee";
			ResultSet rs = sqlHelper.query(sql);
			while(rs.next()) {
				String name = rs.getString("e_name");
				System.out.println(name);
			}
			sqlHelper.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}