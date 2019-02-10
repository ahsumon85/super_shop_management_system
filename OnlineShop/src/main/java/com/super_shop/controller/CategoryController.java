package com.super_shop.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.super_shop.dto.CategoryDTO;

import com.super_shop.service.CategoryService;



@Controller
public class CategoryController {
	
	@Autowired
	CategoryService cateService;
		
	@RequestMapping(path="/cate")
	public String home(Model model) {
	 try {
		model.addAttribute("categoryDTO", new CategoryDTO());
		model.addAttribute("categorys", cateService.findAllCate());
	} catch (Exception e) {
		e.printStackTrace();
	}
	return "category";	
	}
	

	@RequestMapping(path="/saveCategory", method=RequestMethod.POST)
	public String saveCate(CategoryDTO cateDTO){
		cateService.saveCate(cateDTO);
		return "redirect:/cate";
	}
	
	@RequestMapping(path="/category/edit/{cateId}", method=RequestMethod.GET)
	public String editCategory(Model model, @PathVariable(value="cateId") Long cateId){
		try {
			model.addAttribute("categoryDTO", cateService.findCateId(cateId));
			model.addAttribute("categorys", cateService.findAllCate());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "category";
	}
	



}
