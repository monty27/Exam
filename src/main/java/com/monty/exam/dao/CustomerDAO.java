package com.monty.exam.dao;

import java.sql.Connection;

public interface CustomerDAO {
	void createCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(Customer customer);
	Customer getCustomerByUsername(String username);
	Customer getCustomerByID(Connection con, int cust_id);
}
