package cn.lailab.sql;

import java.util.List;
import java.util.ArrayList;

import cn.lailab.entity.Customer;

public class test {
	public static void main(String[] args) {
		try {
			List<Customer> customers = new ArrayList<Customer>();
			for(Customer cus : customers) {
				System.out.println(cus.getName()+":"+cus.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}