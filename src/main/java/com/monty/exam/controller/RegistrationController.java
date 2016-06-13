package com.monty.exam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.monty.exam.dao.Customer;
import com.monty.exam.dao.CustomerDAO;

@Controller
public class RegistrationController {
	
	@Autowired
	CustomerDAO c;
	
	@RequestMapping("/Register")
	public String registrationForm(HttpSession session){
		if(session.getAttribute("loggedInCustomer") == null){
			return "Register";
		}
		else{
			return "redirect:Home";
		}
	}
	
	@RequestMapping(value = "/Register", method = RequestMethod.POST)
	public String valiate(@RequestParam String name, @RequestParam String address, @RequestParam int ssn, @RequestParam String username, @RequestParam String password){
		c.createCustomer(new Customer(1,name,address,ssn,username,password));
		System.out.println(name+address+ssn+username+password);
		return "redirect:Home";
		
	}
}
