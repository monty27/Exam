package com.monty.exam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.monty.exam.dao.Customer;
import com.monty.exam.dao.CustomerDAO;

@Controller
public class LoginController {
	@Autowired
	private CustomerDAO c;
	
	@RequestMapping("/Home")
	public String emptyForm(HttpSession session){
		if(session.getAttribute("loggedInCustomer") == null){
			return "Login";
		}
		else{
			return "Home";
		}
	}
	@RequestMapping(value = "/Home", method = RequestMethod.POST)
	public ModelAndView valiate(@RequestParam boolean logout, @RequestParam String username, @RequestParam String password, HttpSession session){
		if(!logout){
			Customer customer = c.getCustomerByUsername(username);
			if(customer.getPassword().equals(password)){
				session.setAttribute("loggedInCustomer", customer);
				return new ModelAndView("Home", "customer", customer);
			}else{
				return new ModelAndView("Login");
				
			}
		}else{
			session.invalidate();
			return new ModelAndView("Login");
		}
	}
}
