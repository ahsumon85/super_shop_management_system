package com.super_shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.super_shop.dto.LoginDTO;
import com.super_shop.dto.ManagerInfoDTO;
import com.super_shop.dto.PriceDTO;
import com.super_shop.entity.Login;
import com.super_shop.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String login(Model model) {
		try {
			model.addAttribute("loginDTO", new LoginDTO());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}

	@RequestMapping(path = "/signUp", method = RequestMethod.GET)
	public String signUp(Model model) {
		try {
			model.addAttribute("managerDTO", new ManagerInfoDTO());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "signUp";
	}
	
	@RequestMapping(path = "/saveSignUp", method = RequestMethod.POST)
	public String signUp(Model model, ManagerInfoDTO managerInfoDTO) {
	
			Boolean status=false;
			status=loginService.saveSignUp(managerInfoDTO);
			if (status==true) {
				System.out.println("return redirect:/");
				return "redirect:/";
			} else {
				System.out.println("return redirect:/signUp");
				return "redirect:/signUp";
			}	
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String loginSave(Model model, LoginDTO loginDTO) {
		Login login = new Login();
		login = loginService.findUserInfo(loginDTO.getUserName());
		if (login.getPassword().equals(loginDTO.getPassword())) {
			return "redirect:/cate";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(Model model) {
		try {
			model.addAttribute("loginDTO", new LoginDTO());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "login";
	}
	
	
	@GetMapping("error")
	public ModelAndView error() {
	    ModelAndView mav = new ModelAndView();
	    String errorMessage= "You are not authorized for the requested data.";
	    mav.addObject("errorMsg", errorMessage);
	    mav.setViewName("403");
	    return mav;
        }
	

}
