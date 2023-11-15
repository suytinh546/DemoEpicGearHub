package com.store.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingCartController {
	@RequestMapping("/Gear/gh")
	public String gh() {
		return "Gear/gh";
	}
}
