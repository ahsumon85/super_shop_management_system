package com.super_shop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.super_shop.dto.PriceDTO;
import com.super_shop.service.CategoryService;
import com.super_shop.service.PriceService;
import com.super_shop.service.ProductService;
import com.super_shop.service.SalesService;

@Controller
public class PriceController {
	
	@Autowired
	private PriceService priceServicece;
	
	@Autowired
	private ProductService productService;
	@Autowired
	private SalesService salesService;
	
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(path = "/price", method = RequestMethod.GET)
	public String price( Model model, HttpSession session){
		
		try{
			model.addAttribute("productPriceDTO", new PriceDTO());
			model.addAttribute("prices", salesService.findAllPrice());
			model.addAttribute("categorys", categoryService.findAllCate());
			 session.setAttribute("attribute", "stock empty..!");
		}catch (Exception e) {
		e.printStackTrace();
		}
		return "price";
	}
	
	
	@RequestMapping(path = "/category", method = RequestMethod.GET)
	public String productById( Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(value="id",defaultValue="id") String id){
		Long ID=Long.parseLong(id);
		System.out.println("action is working..."+id);
		try{
			model.addAttribute("productPriceDTO", new PriceDTO());
			model.addAttribute("prices", salesService.findAllPrice());
			model.addAttribute( "products", productService.findProductById(ID));
			model.addAttribute("categorys", categoryService.findAllCate());
		}catch (Exception e) {
		e.printStackTrace();
		}
		return "price";
	}
	
	
	@RequestMapping(path = "/savePrice", method = RequestMethod.POST)
	public String itemSave(Model model, PriceDTO priceDTO){
		Boolean status=false;
		status=priceServicece.savePrice(priceDTO);
		if(status==true){
			System.out.println("data insert successfully....");
		}else{
			System.out.println("please try again....");
		}
		return "redirect:/price";
	}
	
	

}
