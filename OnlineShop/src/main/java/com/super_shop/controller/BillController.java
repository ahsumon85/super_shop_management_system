package com.super_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.super_shop.dto.BillDTO;
import com.super_shop.service.BillService;




@Controller
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@RequestMapping(path = "/bill", method = RequestMethod.GET)
	public String price( Model model){
		
		try{
			model.addAttribute("billDTO", new BillDTO());
			model.addAttribute("billList", billService.findAllCutomerBill());
		}catch (Exception e) {
		e.printStackTrace();
		}
		return "bill";
	}
	
	@RequestMapping(path="/bill/details/{billId}", method=RequestMethod.GET)
	public String findBillDetails(Model model, @PathVariable(value="billId") Long billID){
		model.addAttribute("billDetails", billService.findBillDetails(billID));
		return "bill";
		}

}
