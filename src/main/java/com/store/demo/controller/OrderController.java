package com.store.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.store.demo.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	@RequestMapping("/Gear/order/checkout")
	public String checkout() {
		return "Gear/order/checkout";
	}
	@RequestMapping("/Gear/order/detail/{id}")
	public String detail(@PathVariable("id") Integer id,Model model) {
		model.addAttribute("order", orderService.findById(id));
		return "Gear/order/detail";
	}
	@RequestMapping("/Gear/order/list")
	public String list(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("orders", orderService.findByUsername(username));
		return "Gear/order/list";
	}
	
}
