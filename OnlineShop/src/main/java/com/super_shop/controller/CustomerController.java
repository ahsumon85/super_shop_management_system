package com.super_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.super_shop.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(path = "/customer", method = RequestMethod.GET)
	public String customer(Model model){
		try{
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "null";
	}
	
	

}
