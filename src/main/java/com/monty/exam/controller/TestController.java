package com.monty.exam.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.monty.exam.dao.Customer;
import com.monty.exam.dao.Test;
import com.monty.exam.dao.TestDAO;

@Controller
public class TestController {
	
	@Autowired
	TestDAO t;
	
	@RequestMapping("/ViewTests")
	public ModelAndView displayAllTests(HttpSession session){
		if(session.getAttribute("loggedInCustomer") == null){
			return new ModelAndView("Login");
		}
		else{
			
			List<Test> tests = t.getAllTestsForACustomer((Customer) session.getAttribute("loggedInCustomer"));
			return new ModelAndView("ViewTests", "tests", tests);
		}
	}
	
	@RequestMapping(value ="/ViewTest", method = RequestMethod.GET)
	public ModelAndView displayATests(@RequestParam int tid, HttpSession session){
		Test test = t.getTestByID(tid);
		
		return new ModelAndView("ViewTest", "test", test);
	}
}
