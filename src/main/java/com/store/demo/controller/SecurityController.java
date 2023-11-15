package com.store.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	@RequestMapping("/Gear/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message","Vui lòng đăng nhập lại!");
		return "Gear/login";
	}
	
	@RequestMapping("/Gear/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message","Đăng nhập thành công");
		return "Gear/login";
	}
	
	@RequestMapping("/Gear/login/error")
	public String loginError(Model model) {
		model.addAttribute("message","Đăng nhập thất bại");
		return "Gear/login";
	}
	
	@RequestMapping("/Gear/login/unanthorie")
	public String unanthoried(Model model) {
		model.addAttribute("message","Không có quyền truy xuất");
		return "Gear/login";
	}
	
	@RequestMapping("/Gear/logoff/success")
	public String logoffSuccess(Model model) {
		model.addAttribute("message","Bạn đã đăng xuất");
		return "Gear/login";
	}
}
