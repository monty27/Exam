package com.monty.exam.dao;

import java.util.List;

public interface TestDAO {
	void addTest(Test test);
	List<Test> getAllTestsForACustomer(Customer customer);
	Test getTestByID(int tid);
}
