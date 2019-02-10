package com.super_shop.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.super_shop.dto.ProductDTO;
import com.super_shop.service.CategoryService;
import com.super_shop.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	CategoryService categoryService;

	@Autowired
	ProductService productService;

	public final String UPLOAD_DIRECTORY = "E:/onlineshop/item";

	@RequestMapping(path = "/item")
	public String item(Model model){
		try {
			model.addAttribute("productDTO", new ProductDTO());
			model.addAttribute("categorys", categoryService.findAllCate());
			model.addAttribute("products", productService.findProduct());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "product";
	}

	@RequestMapping(path = "/saveItem", method = RequestMethod.POST)
	public String itemSave(ProductDTO productDTO, RedirectAttributes redirectAttributes){
		String photoName = productDTO.getPhotos().getOriginalFilename();
		Path path = Paths.get(UPLOAD_DIRECTORY + File.separator + photoName);
		try {
			Files.write(path, productDTO.getPhotos().getBytes());
			productDTO.setItemImage(photoName);
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
		}
		productService.saveitem(productDTO);
		return "redirect:/item";
	}

	@RequestMapping(path = "/product/edit/{itemId}", method = RequestMethod.GET)
	public String editProguct(Model model, @PathVariable(value = "itemId") Long itemId) {
		try {
			model.addAttribute("productDTO", productService.findByStudentID(itemId));
			model.addAttribute("products", productService.findProduct());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "product";
	}

}
