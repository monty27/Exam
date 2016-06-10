package com.monty.exam.dao;

import java.util.List;

public interface CustomerDAO {
	List<Customer> getALLCustomers();
	void createCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(Customer customer);
	Customer getCustomerByUsername(String username);
}
